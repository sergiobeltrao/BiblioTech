package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.dao.AutorDAO;
import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.ExcluirUserDAO;
import com.mycompany.bibliotech.dao.ImagemDAO;
import com.mycompany.bibliotech.dao.LivroAutorDAO;
import com.mycompany.bibliotech.dao.LivroDAO;
import com.mycompany.bibliotech.dao.UsuarioCadastroDAO;
import com.mycompany.bibliotech.dao.UsuarioLoginDAO;
import com.mycompany.bibliotech.model.bean.ApplicationContext;
import com.mycompany.bibliotech.model.bean.Autor;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.Endereco;
import com.mycompany.bibliotech.model.bean.Favoritos;
import com.mycompany.bibliotech.model.bean.Hash;
import com.mycompany.bibliotech.model.bean.Livro;
import com.mycompany.bibliotech.model.bean.Login;
import com.mycompany.bibliotech.model.bean.Telefone;
import com.mycompany.bibliotech.model.bean.Usuario;
import com.mycompany.bibliotech.model.bean.ValidadorIsbn;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class CadastroDeLivros extends javax.swing.JFrame {

    public CadastroDeLivros() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbLivro.getModel();
        tbLivro.setRowSorter(new TableRowSorter(modelo));
        listarCategorias();
        listarNacionalidades();
        listarIdiomasDoLivro();
        selectTabelaLivro();
        selectTabelaAutor();
        selectTabelaAvaliacao();
        // Impede que o ISBN seja setado sem selecionar o tipo quando abre a tela.
        formatedIsbn.setEditable(false);
        UsuarioLoginDAO usuarioLoginDao = new UsuarioLoginDAO();

        if (usuarioLoginDao.tipoDoUsuarioLogado()) {
            CadUserButton.setVisible(true);
            ExcluirUserButton.setVisible(true);
            btnEdicaoDeLivro.setVisible(true);
        } else {
            CadUserButton.setVisible(false);
            ExcluirUserButton.setVisible(false);
            btnEdicaoDeLivro.setVisible(false);
        }
    }

    public class CenterRenderer extends DefaultTableCellRenderer {

        // Pra centralizar o conteúdo da JTable
        public CenterRenderer() {
            setHorizontalAlignment(CENTER);
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return this;
        }
    }

    public void selectTabelaLivro() {
        DefaultTableModel modelo = (DefaultTableModel) tbLivro.getModel();
        tbLivro.setDefaultRenderer(Object.class, new CenterRenderer());
        JTableHeader header = tbLivro.getTableHeader();
        header.setDefaultRenderer(new CenterRenderer());

        // Para evitar que todos os dados sejam duplicados após um insert
        modelo.setNumRows(0);

        LivroDAO ldao = new LivroDAO();

        for (Livro l : ldao.read()) {

            modelo.addRow(new Object[]{
                l.getTitulo(),
                l.getIsbn(),
                l.getAnoDePublicacao(),
                l.getNumeroDePaginas(),
                l.getCategoria(),
                l.getSubCategoria(),
                l.getIdioma(),
                l.getEditora()});
        }
    }

    public void selectTabelaAutor() {
        DefaultTableModel modelo = (DefaultTableModel) tbAutor.getModel();
        tbAutor.setDefaultRenderer(Object.class, new CenterRenderer());
        JTableHeader header = tbAutor.getTableHeader();
        header.setDefaultRenderer(new CenterRenderer());

        // Para evitar que todos os dados sejam duplicados após um insert
        modelo.setNumRows(0);

        AutorDAO autorDao = new AutorDAO();

        for (Autor a : autorDao.read()) {
            modelo.addRow(new Object[]{
                a.getNome(),
                a.getNacionalidade(),
                a.getSexo()
            });
        }
    }

    public void selectTabelaAvaliacao() {
        DefaultTableModel modelo = (DefaultTableModel) tbAvaliacao.getModel();
        tbAvaliacao.setDefaultRenderer(Object.class, new CenterRenderer());
        JTableHeader header = tbAvaliacao.getTableHeader();
        header.setDefaultRenderer(new CenterRenderer());

        // Para evitar que todos os dados sejam duplicados após um insert
        modelo.setNumRows(0);

        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();

        for (Avaliacao av : avaliacaoDao.read()) {
            // Supondo que você tenha um método getTitulo() na classe Livro para obter o título do livro
            modelo.addRow(new Object[]{
                av.getLivro().getTitulo(),
                av.getAvaliacaoDoUsuario(),
                av.getComentarioAvaliacao()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuLateral = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        AvaButton1 = new javax.swing.JButton();
        btnEncerrarSessao = new javax.swing.JButton();
        edicaoUserButton = new javax.swing.JButton();
        btnTelaPrinCadLivro = new javax.swing.JButton();
        CadUserButton = new javax.swing.JButton();
        ExcluirUserButton = new javax.swing.JToggleButton();
        btnEdicaoDeLivro = new javax.swing.JButton();
        janelaDeAbas = new javax.swing.JTabbedPane();
        jpnLivro = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        cboxCategoria = new javax.swing.JComboBox<>();
        cboxSubCategoria = new javax.swing.JComboBox<>();
        cboxLivroIdioma = new javax.swing.JComboBox<>();
        cboxIsbnSelect = new javax.swing.JComboBox<>();
        txtTitulo = new javax.swing.JTextField();
        txtNumeroDePaginas = new javax.swing.JTextField();
        txtNomeDaEditora = new javax.swing.JTextField();
        formatedIsbn = new javax.swing.JFormattedTextField();
        boxSinopse = new javax.swing.JScrollPane();
        txtSinopseDoLivro = new javax.swing.JTextArea();
        boxTabelaLivro = new javax.swing.JScrollPane();
        tbLivro = new javax.swing.JTable();
        btnLimparLivro = new javax.swing.JButton();
        btnInserirCapa = new javax.swing.JButton();
        btnProximaAbaLivro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtAnoDePublicacao = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jlbCapaDoLivro = new javax.swing.JLabel();
        jpnAutor = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        cboxNacionalidadeDoAutor = new javax.swing.JComboBox<>();
        cboxSexoDoAutor = new javax.swing.JComboBox<>();
        cboxResultadoBuscaAutor = new javax.swing.JComboBox<>();
        boxAutoresSelecionados = new javax.swing.JScrollPane();
        txtCampoDeAutoresSelecionados = new javax.swing.JTextArea();
        boxTabelaAutor = new javax.swing.JScrollPane();
        tbAutor = new javax.swing.JTable();
        txtAutorPesquisado = new javax.swing.JTextField();
        txtNomeDoAutor = new javax.swing.JTextField();
        btnAutorNaoCadastrado = new javax.swing.JButton();
        btnLimparAutor = new javax.swing.JButton();
        btnProximaAbaAutor = new javax.swing.JButton();
        btnLimparAutoresSelecionados = new javax.swing.JButton();
        btnSelecionarResultadoAutor = new javax.swing.JButton();
        btnBuscarAutor = new javax.swing.JButton();
        btnCadastraAutor = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jpnAvaliacao = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        cboxAvaliacaoDoLivro = new javax.swing.JComboBox<>();
        boxComentarioAvaliacao = new javax.swing.JScrollPane();
        txtComentarioAvaliacao = new javax.swing.JTextArea();
        boxTabelaAvaliacao = new javax.swing.JScrollPane();
        tbAvaliacao = new javax.swing.JTable();
        btnLimparAvaliacao = new javax.swing.JButton();
        btnFinalizarCadastro = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de livro");

        MenuLateral.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkGradientFocus(900);
        kGradientPanel2.setkStartColor(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Menu");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        AvaButton1.setBackground(new java.awt.Color(102, 102, 102));
        AvaButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AvaButton1.setText("Avaliação");
        AvaButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        AvaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvaButton1ActionPerformed(evt);
            }
        });

        btnEncerrarSessao.setBackground(new java.awt.Color(102, 102, 102));
        btnEncerrarSessao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEncerrarSessao.setText("Encerrar Sessão");
        btnEncerrarSessao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEncerrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarSessaoActionPerformed(evt);
            }
        });

        edicaoUserButton.setBackground(new java.awt.Color(102, 102, 102));
        edicaoUserButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        edicaoUserButton.setText("Edição de Usuario");
        edicaoUserButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        edicaoUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edicaoUserButtonActionPerformed(evt);
            }
        });

        btnTelaPrinCadLivro.setBackground(new java.awt.Color(102, 102, 102));
        btnTelaPrinCadLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnTelaPrinCadLivro.setText("Inicio");
        btnTelaPrinCadLivro.setToolTipText("ir para inicio");
        btnTelaPrinCadLivro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTelaPrinCadLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTelaPrinCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaPrinCadLivroActionPerformed(evt);
            }
        });

        CadUserButton.setBackground(new java.awt.Color(102, 102, 102));
        CadUserButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CadUserButton.setText("Cadastro de Usuario");
        CadUserButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CadUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadUserButtonActionPerformed(evt);
            }
        });

        ExcluirUserButton.setBackground(new java.awt.Color(102, 102, 102));
        ExcluirUserButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ExcluirUserButton.setText("Excluir Usuarios");
        ExcluirUserButton.setBorder(new javax.swing.border.MatteBorder(null));
        ExcluirUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirUserButtonActionPerformed(evt);
            }
        });

        btnEdicaoDeLivro.setBackground(new java.awt.Color(102, 102, 102));
        btnEdicaoDeLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEdicaoDeLivro.setText("Edição de Livro");
        btnEdicaoDeLivro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEdicaoDeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdicaoDeLivroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edicaoUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTelaPrinCadLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExcluirUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdicaoDeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(btnTelaPrinCadLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edicaoUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExcluirUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdicaoDeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout MenuLateralLayout = new javax.swing.GroupLayout(MenuLateral);
        MenuLateral.setLayout(MenuLateralLayout);
        MenuLateralLayout.setHorizontalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MenuLateralLayout.setVerticalGroup(
            MenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        janelaDeAbas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        janelaDeAbas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        janelaDeAbas.setPreferredSize(new java.awt.Dimension(1280, 720));

        jpnLivro.setBackground(new java.awt.Color(255, 255, 255));
        jpnLivro.setPreferredSize(new java.awt.Dimension(1109, 685));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setkGradientFocus(350);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        cboxCategoria.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxCategoria.setToolTipText("escolha a categoria principal do livro");
        cboxCategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaActionPerformed(evt);
            }
        });

        cboxSubCategoria.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSubCategoria.setToolTipText("escolha a sub-categoria do livro");
        cboxSubCategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxSubCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSubCategoriaActionPerformed(evt);
            }
        });

        cboxLivroIdioma.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxLivroIdioma.setToolTipText("escolha o idioma do livro");
        cboxLivroIdioma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxLivroIdioma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cboxIsbnSelect.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxIsbnSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "ISBN-13", "ISBN-10" }));
        cboxIsbnSelect.setToolTipText("escolha o tipo de ISBN do livro");
        cboxIsbnSelect.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxIsbnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxIsbnSelect.setMaximumSize(new java.awt.Dimension(108, 25));
        cboxIsbnSelect.setPreferredSize(new java.awt.Dimension(108, 25));
        cboxIsbnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxIsbnSelectActionPerformed(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTitulo.setToolTipText("insira o nome do livro à cadastrar");
        txtTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        txtNumeroDePaginas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNumeroDePaginas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroDePaginas.setToolTipText("insira o numero de paginas do livro");
        txtNumeroDePaginas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtNumeroDePaginas.setMaximumSize(new java.awt.Dimension(70, 25));
        txtNumeroDePaginas.setPreferredSize(new java.awt.Dimension(70, 25));
        txtNumeroDePaginas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDePaginasActionPerformed(evt);
            }
        });
        txtNumeroDePaginas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroDePaginasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroDePaginasKeyTyped(evt);
            }
        });

        txtNomeDaEditora.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeDaEditora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNomeDaEditora.setToolTipText("insira o nome da editora");
        txtNomeDaEditora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        formatedIsbn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            formatedIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatedIsbn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formatedIsbn.setToolTipText("insira o ISBN do livro");
        formatedIsbn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        formatedIsbn.setMaximumSize(new java.awt.Dimension(25, 203));
        formatedIsbn.setPreferredSize(new java.awt.Dimension(25, 203));
        formatedIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatedIsbnActionPerformed(evt);
            }
        });

        boxSinopse.setBackground(new java.awt.Color(255, 255, 255));
        boxSinopse.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtSinopseDoLivro.setColumns(20);
        txtSinopseDoLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSinopseDoLivro.setLineWrap(true);
        txtSinopseDoLivro.setRows(5);
        txtSinopseDoLivro.setToolTipText("insira a sinopse do livro");
        boxSinopse.setViewportView(txtSinopseDoLivro);

        tbLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tbLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Título", "ISBN", "Ano", "Páginas", "Categoria", "Sub-categoria", "Idioma", "Editora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLivro.setToolTipText("lista de livros cadastrado ");
        tbLivro.setColumnSelectionAllowed(true);
        boxTabelaLivro.setViewportView(tbLivro);
        tbLivro.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnLimparLivro.setBackground(new java.awt.Color(102, 102, 102));
        btnLimparLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparLivro.setText("Limpar");
        btnLimparLivro.setToolTipText("apagar todas as infomações escritas");
        btnLimparLivro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimparLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparLivroActionPerformed(evt);
            }
        });

        btnInserirCapa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnInserirCapa.setText("Inserir");
        btnInserirCapa.setToolTipText("inserir imagem do livro");
        btnInserirCapa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInserirCapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInserirCapa.setMaximumSize(new java.awt.Dimension(80, 25));
        btnInserirCapa.setPreferredSize(new java.awt.Dimension(80, 25));
        btnInserirCapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirCapaActionPerformed(evt);
            }
        });

        btnProximaAbaLivro.setBackground(new java.awt.Color(102, 102, 102));
        btnProximaAbaLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnProximaAbaLivro.setText("Próxima ");
        btnProximaAbaLivro.setToolTipText("ir para proxima aba");
        btnProximaAbaLivro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProximaAbaLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProximaAbaLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaAbaLivroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Os campo com asterisco são de preenchimento obrigatório.");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Titulo:");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("ISBN:");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Ano:");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Tipo do ISBN:");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Páginas:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");

        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");

        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Categoria:");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Sub-categoria:");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Idioma:");
        jLabel19.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Editora:");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Capa:");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("*");

        txtAnoDePublicacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAnoDePublicacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnoDePublicacao.setToolTipText("escreva o ano de publicação do livro");
        txtAnoDePublicacao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAnoDePublicacao.setMinimumSize(new java.awt.Dimension(53, 25));
        txtAnoDePublicacao.setPreferredSize(new java.awt.Dimension(53, 25));
        txtAnoDePublicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoDePublicacaoActionPerformed(evt);
            }
        });
        txtAnoDePublicacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnoDePublicacaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoDePublicacaoKeyTyped(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 51, 51));
        jLabel37.setText("*");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel38.setText("Sinopse do Livro:");

        jlbCapaDoLivro.setBackground(new java.awt.Color(0, 0, 0));
        jlbCapaDoLivro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boxTabelaLivro, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnLimparLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboxIsbnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(formatedIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7))
                                .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel18))
                                .addComponent(cboxSubCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel20))
                                .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel19))
                                .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnInserirCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel21))))))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jlbCapaDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(boxSinopse, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)))
                    .addComponent(btnProximaAbaLivro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxIsbnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(formatedIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInserirCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlbCapaDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProximaAbaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(boxTabelaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnLivroLayout = new javax.swing.GroupLayout(jpnLivro);
        jpnLivro.setLayout(jpnLivroLayout);
        jpnLivroLayout.setHorizontalGroup(
            jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnLivroLayout.setVerticalGroup(
            jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        janelaDeAbas.addTab("Livro", jpnLivro);

        jpnAutor.setBackground(new java.awt.Color(255, 255, 255));
        jpnAutor.setPreferredSize(new java.awt.Dimension(1109, 685));

        kGradientPanel3.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel3.setkGradientFocus(350);
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setPreferredSize(new java.awt.Dimension(1109, 685));

        cboxNacionalidadeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxNacionalidadeDoAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxNacionalidadeDoAutor.setToolTipText("Escolha a nacionalidade do autor");
        cboxNacionalidadeDoAutor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxNacionalidadeDoAutor.setEnabled(false);
        cboxNacionalidadeDoAutor.setFocusable(false);
        cboxNacionalidadeDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNacionalidadeDoAutorActionPerformed(evt);
            }
        });

        cboxSexoDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSexoDoAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informado", "Masculino", "Feminino" }));
        cboxSexoDoAutor.setToolTipText("escolha uma das opções");
        cboxSexoDoAutor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxSexoDoAutor.setEnabled(false);
        cboxSexoDoAutor.setFocusable(false);
        cboxSexoDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSexoDoAutorActionPerformed(evt);
            }
        });

        cboxResultadoBuscaAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxResultadoBuscaAutor.setToolTipText("resultado a pesquisa de autor");
        cboxResultadoBuscaAutor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxResultadoBuscaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxResultadoBuscaAutorActionPerformed(evt);
            }
        });

        txtCampoDeAutoresSelecionados.setEditable(false);
        txtCampoDeAutoresSelecionados.setBackground(new java.awt.Color(255, 255, 255));
        txtCampoDeAutoresSelecionados.setColumns(20);
        txtCampoDeAutoresSelecionados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCampoDeAutoresSelecionados.setRows(5);
        txtCampoDeAutoresSelecionados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCampoDeAutoresSelecionados.setFocusable(false);
        boxAutoresSelecionados.setViewportView(txtCampoDeAutoresSelecionados);

        tbAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tbAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Nacionalidade", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        boxTabelaAutor.setViewportView(tbAutor);

        txtAutorPesquisado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAutorPesquisado.setToolTipText("insira o nome do autor a ser pesquisado");
        txtAutorPesquisado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtNomeDoAutor.setEditable(false);
        txtNomeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeDoAutor.setToolTipText("nome do novo autor");
        txtNomeDoAutor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtNomeDoAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNomeDoAutor.setFocusable(false);
        txtNomeDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDoAutorActionPerformed(evt);
            }
        });

        btnAutorNaoCadastrado.setBackground(new java.awt.Color(102, 102, 102));
        btnAutorNaoCadastrado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnAutorNaoCadastrado.setText("Cadastrar novo");
        btnAutorNaoCadastrado.setToolTipText("Cadastrar novo autor");
        btnAutorNaoCadastrado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAutorNaoCadastrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorNaoCadastradoActionPerformed(evt);
            }
        });

        btnLimparAutor.setBackground(new java.awt.Color(102, 102, 102));
        btnLimparAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparAutor.setText("Limpar");
        btnLimparAutor.setToolTipText("limpar busca ");
        btnLimparAutor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimparAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAutorActionPerformed(evt);
            }
        });

        btnProximaAbaAutor.setBackground(new java.awt.Color(102, 102, 102));
        btnProximaAbaAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnProximaAbaAutor.setText("Próxima ");
        btnProximaAbaAutor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProximaAbaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaAbaAutorActionPerformed(evt);
            }
        });

        btnLimparAutoresSelecionados.setBackground(new java.awt.Color(102, 102, 102));
        btnLimparAutoresSelecionados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparAutoresSelecionados.setText("Limpar");
        btnLimparAutoresSelecionados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimparAutoresSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAutoresSelecionadosActionPerformed(evt);
            }
        });

        btnSelecionarResultadoAutor.setBackground(new java.awt.Color(102, 102, 102));
        btnSelecionarResultadoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSelecionarResultadoAutor.setText("Selecionar");
        btnSelecionarResultadoAutor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSelecionarResultadoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarResultadoAutorActionPerformed(evt);
            }
        });

        btnBuscarAutor.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscarAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnBuscarAutor.setText("Buscar");
        btnBuscarAutor.setToolTipText("buscar autor");
        btnBuscarAutor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutorActionPerformed(evt);
            }
        });

        btnCadastraAutor.setBackground(new java.awt.Color(102, 102, 102));
        btnCadastraAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCadastraAutor.setText("Cadastrar");
        btnCadastraAutor.setToolTipText("cadastrar novo autor");
        btnCadastraAutor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCadastraAutor.setEnabled(false);
        btnCadastraAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraAutorActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setText("Os campo com asterisco são de preenchimento obrigatório.");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel24.setText("Resultado:");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel25.setText("Pesquisar Autor:");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel26.setText("Sexo:");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel27.setText("Nacionalidade:");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel28.setText("Novo do Autor:");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("*");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("*");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 51, 51));
        jLabel39.setText("*");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel40.setText("Autores Selecionados");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40))
                    .addComponent(jLabel23)
                    .addComponent(boxAutoresSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(txtAutorPesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(kGradientPanel3Layout.createSequentialGroup()
                            .addComponent(btnLimparAutoresSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAutorNaoCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel3Layout.createSequentialGroup()
                            .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(cboxResultadoBuscaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSelecionarResultadoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxTabelaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxSexoDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnLimparAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCadastraAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel29)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(cboxNacionalidadeDoAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomeDoAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel28))))
                        .addGap(57, 57, 57)
                        .addComponent(btnProximaAbaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(8, 8, 8)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAutorPesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarAutor))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxResultadoBuscaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSelecionarResultadoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimparAutoresSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAutorNaoCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel31)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxSexoDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxNacionalidadeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimparAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadastraAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProximaAbaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxTabelaAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addComponent(boxAutoresSelecionados))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jpnAutorLayout = new javax.swing.GroupLayout(jpnAutor);
        jpnAutor.setLayout(jpnAutorLayout);
        jpnAutorLayout.setHorizontalGroup(
            jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
        );
        jpnAutorLayout.setVerticalGroup(
            jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        janelaDeAbas.addTab("Autor", jpnAutor);

        jpnAvaliacao.setBackground(new java.awt.Color(255, 255, 255));
        jpnAvaliacao.setPreferredSize(new java.awt.Dimension(1109, 685));

        kGradientPanel4.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel4.setkGradientFocus(350);
        kGradientPanel4.setkStartColor(new java.awt.Color(255, 255, 255));

        cboxAvaliacaoDoLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxAvaliacaoDoLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada", "10 - Excelente", "9 - Ótimo", "8 - Muito Bom", "7 - Bom", "6 - Satisfatório", "5 - Regular", "4 - Abaixo da Média", "3 - Ruim", "2 - Muito Ruim", "1 - Péssimo", "0 - Inaceitável" }));
        cboxAvaliacaoDoLivro.setToolTipText("escolha a nota de avaliação do livro");
        cboxAvaliacaoDoLivro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxAvaliacaoDoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAvaliacaoDoLivroActionPerformed(evt);
            }
        });

        boxComentarioAvaliacao.setBorder(null);

        txtComentarioAvaliacao.setColumns(20);
        txtComentarioAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtComentarioAvaliacao.setLineWrap(true);
        txtComentarioAvaliacao.setRows(5);
        txtComentarioAvaliacao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        boxComentarioAvaliacao.setViewportView(txtComentarioAvaliacao);

        tbAvaliacao.setFont(new java.awt.Font("Serif", 0, 13)); // NOI18N
        tbAvaliacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Nota", "Comentário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        boxTabelaAvaliacao.setViewportView(tbAvaliacao);

        btnLimparAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparAvaliacao.setText("Limpar");
        btnLimparAvaliacao.setToolTipText("limpar toda avaliação");
        btnLimparAvaliacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimparAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAvaliacaoActionPerformed(evt);
            }
        });

        btnFinalizarCadastro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnFinalizarCadastro.setText("Finalizar Cadastro");
        btnFinalizarCadastro.setToolTipText("cinalizar o cadastro do livro");
        btnFinalizarCadastro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFinalizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCadastroActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("*");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel34.setText("Nota da Avaliação:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel35.setText("Comentario da avaliação");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel36.setText("Os campo com asterisco são de preenchimento obrigatório.");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boxTabelaAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel4Layout.createSequentialGroup()
                        .addComponent(btnLimparAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizarCadastro)
                        .addGap(33, 33, 33))
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(boxComentarioAvaliacao)
                                .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxComentarioAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(boxTabelaAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnAvaliacaoLayout = new javax.swing.GroupLayout(jpnAvaliacao);
        jpnAvaliacao.setLayout(jpnAvaliacaoLayout);
        jpnAvaliacaoLayout.setHorizontalGroup(
            jpnAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnAvaliacaoLayout.setVerticalGroup(
            jpnAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        janelaDeAbas.addTab("Avaliação", jpnAvaliacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(janelaDeAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(janelaDeAbas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1296, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCadastroActionPerformed

        Livro livro = new Livro();
        Autor autor = new Autor();
        Avaliacao avaliacao = new Avaliacao();
        Login login = ApplicationContext.getLogin();
        LivroDAO livroDao = new LivroDAO();
        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
        LivroAutorDAO livroAutorDao = new LivroAutorDAO();
        ImagemDAO imagemDAO = new ImagemDAO();

        // Seta os dados caso nenhum erro seja encontrado ou mostra o erro na tela.
        if (verificaErroCadastro() != null) {
            JOptionPane.showMessageDialog(null, verificaErroCadastro());
        } else {
            livro.setTitulo(txtTitulo.getText());
            livro.setIsbn(formatedIsbn.getText());
            livro.setAnoDePublicacao(Integer.parseInt(txtAnoDePublicacao.getText()));
            livro.setNumeroDePaginas(Integer.parseInt(txtNumeroDePaginas.getText()));
            livro.setCategoria(cboxCategoria.getSelectedItem().toString());
            livro.setSubCategoria(cboxSubCategoria.getSelectedItem().toString());
            livro.setIdioma(cboxLivroIdioma.getSelectedItem().toString());
            livro.setEditora(txtNomeDaEditora.getText());
            livro.setSinopse(txtSinopseDoLivro.getText());

            if (jlbCapaDoLivro.getIcon() != null) {
                // Pegando a imagem da JLabel.
                ImageIcon icon = (ImageIcon) jlbCapaDoLivro.getIcon();
                // Relacionado ao insert da capa do livro.
                if (icon != null && icon.getImage() != null) {
                    Image imagem = icon.getImage();
                    // Redimensionando.
                    Image novaImagem = imagem.getScaledInstance(250, 350, Image.SCALE_SMOOTH);

                    // Convertendo a imagem para um array de bytes.
                    BufferedImage bufferedImage = new BufferedImage(novaImagem.getWidth(null), novaImagem.getHeight(null), BufferedImage.TYPE_INT_RGB);
                    bufferedImage.getGraphics().drawImage(novaImagem, 0, 0, null);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();

                    try {
                        ImageIO.write(bufferedImage, "jpg", stream);
                    } catch (IOException ex) {
                        Logger.getLogger(EdicaoDeLivro.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    byte[] bytesImagem = stream.toByteArray();

                    livro.setImagem(bytesImagem);

                    try {
                        imagemDAO.alterarImagem(livro);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar imagem: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                }

            } else {
                livro.setImagem(null);
            }

            avaliacao.setAvaliacaoDoUsuario(cboxAvaliacaoDoLivro.getSelectedItem().toString().substring(0, 2));
            avaliacao.setComentarioAvaliacao(txtComentarioAvaliacao.getText());

            livroDao.create(livro);

            // Usa o nick do usuário logado para informar quem avaliou o livro.
            avaliacaoDao.create(avaliacao, txtTitulo.getText(), login.getNick());

            // Captura o ID do livro cadastrado.
            String idDoLivro = livroAutorDao.buscaIdDoLivro(livro);

            // Tabela LivroAutor
            // A quantidade de linhas da string (quantidade de autores).
            String[] arrayDeAutores = txtCampoDeAutoresSelecionados.getText().split("\n");
            int quantidadeDeAutores = arrayDeAutores.length;

            for (int i = 0; i < quantidadeDeAutores; i++) {

                // Exemplo de dado não tratado: 'Laura Bens, Brasil, Mulher'
                // Divide a informação em três.
                String autorSelecionado = arrayDeAutores[i];

                String nomeAutor = "";
                String nacionalidadeAutor = "";

                String[] partes = autorSelecionado.split(", ");

                if (partes.length == 2) {
                    nomeAutor = partes[0];
                    nacionalidadeAutor = partes[1];
                }

                autor.setNome(nomeAutor);
                autor.setNacionalidade(nacionalidadeAutor);

                String idDoAutor = livroAutorDao.buscaIdDoAutor(nomeAutor, nacionalidadeAutor);
                livroAutorDao.preencheTabelaLivroAutor(idDoLivro, idDoAutor);
            }
            // Para que a leitura da tabela seja feita novamente após salvar novas informações.
            selectTabelaLivro();
            selectTabelaAutor();
            selectTabelaAvaliacao();
        }

    }//GEN-LAST:event_btnFinalizarCadastroActionPerformed

    public String verificaErroCadastro() {
        // Verifica se algum dos dados obrigatórios não foram preenchidos.

        ValidadorIsbn validadorIsbn = new ValidadorIsbn();
        LivroDAO livroDao = new LivroDAO();

        String mensagemDeErro = null;

        // Avaliação sem comentário.
        if (txtComentarioAvaliacao.getText().isBlank()) {
            mensagemDeErro = "Faça o comentário da avaliação";
        }

        // Avaliação sem nota.
        if (cboxAvaliacaoDoLivro.getSelectedItem().toString().equals("Não Informada")) {
            mensagemDeErro = "Selecione uma nota para o livro";
        }

        // Livro sem autor.
        if (txtCampoDeAutoresSelecionados.getText().isBlank()) {
            mensagemDeErro = "Você precisa selecionar pelo menos um autor.";
        }

        // Livro sem idioma.
        if (cboxLivroIdioma.getSelectedItem().toString().equals("Selecione")) {
            mensagemDeErro = "Selecione um idioma para o livro.";
        }

        String categoriaSelecionada = cboxCategoria.getSelectedItem().toString();
        String subCategoriaSelecionada = cboxSubCategoria.getSelectedItem().toString();

        // Livro sem categoria ou subcategoria.
        if (categoriaSelecionada.equals("Selecione") || subCategoriaSelecionada.equals("Selecione")) {
            mensagemDeErro = "Você precisa selecionar a categoria e sub-categoria do livro.";
        }

        // Livro sem número de páginas.
        if (txtNumeroDePaginas.getText().isBlank()) {
            mensagemDeErro = "Digite o número de páginas do livro.";
        }

        // Livro sem ano de publicação.
        if (txtAnoDePublicacao.getText().isBlank()) {
            mensagemDeErro = "Digite o ano de publicação do livro.";
        }

        // ISBN já consta no banco.
        if (livroDao.verificaDuplicidadeIsbn(formatedIsbn.getText()).equals(formatedIsbn.getText())) {
            mensagemDeErro = "Esse ISBN já está cadastrado.";
        }

        // ISBN inválido.
        if (validadorIsbn.valida(formatedIsbn.getText()) == false) {
            mensagemDeErro = "ISBN inválido.";
        }

        String isbnSelecionado = cboxIsbnSelect.getSelectedItem().toString();
        String isbnParaTexto = formatedIsbn.getText().replaceAll("[\\s-]", ""); // Remove espaços e hífens

        // Tipo do ISBN foi selecionado mas nada foi digitado.
        if (!isbnSelecionado.equals("Selecione") && (isbnParaTexto.isBlank() || isbnParaTexto.equals(""))) {
            mensagemDeErro = "Você precisa digitar o ISBN";
        }

        // Tipo do ISBN não selecionado.
        if (cboxIsbnSelect.getSelectedItem().toString().equals("Selecione")) {
            mensagemDeErro = "Selecione o tipo do ISBN.";
        }

        // Livro sem título.
        if (txtTitulo.getText().isBlank()) {
            mensagemDeErro = "Digite um título válido para o livro.";
        }

        return mensagemDeErro;
    }

    public void listarIdiomasDoLivro() {
        LivroDAO.listaDeIdiomas(cboxLivroIdioma);
    }

    public void listarNacionalidades() {
        AutorDAO.listaNacionalidadesParaAutores(cboxNacionalidadeDoAutor);
    }

    public void listarCategorias() {
        LivroCategoriaDAO.listarCategorias(cboxCategoria);
    }

    public void listarSubCategoria(String idCategoria) {
        LivroCategoriaDAO.listarSubCategoria(cboxSubCategoria, idCategoria);
    }

    private void btnTelaPrinCadLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaPrinCadLivroActionPerformed
        UsuarioLoginDAO usuarioLoginDao = new UsuarioLoginDAO();

        if (usuarioLoginDao.tipoDoUsuarioLogado()) {
            new TelaPrincipalAdministrador().setVisible(true);
            this.dispose();
        } else {
            new TelaPrincipalCliente().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnTelaPrinCadLivroActionPerformed

    private void cboxSexoDoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSexoDoAutorActionPerformed

    }//GEN-LAST:event_cboxSexoDoAutorActionPerformed

    private void btnLimparLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparLivroActionPerformed

        // Limpar os campos já preenchidos e define valor "Não Informado" para todas as JComboBox
        txtTitulo.setText("");
        cboxIsbnSelect.setSelectedItem("Selecione");
        formatedIsbn.setText(null);
        txtAnoDePublicacao.setText("");
        txtNumeroDePaginas.setText("");
        cboxCategoria.setSelectedItem("Selecione");
        cboxSubCategoria.setSelectedItem("Selecione");
        txtNomeDaEditora.setText("");
        cboxLivroIdioma.setSelectedItem("Selecione");
        txtSinopseDoLivro.setText("");
        jlbCapaDoLivro.setIcon(null);
    }//GEN-LAST:event_btnLimparLivroActionPerformed

    private void cboxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaActionPerformed
        // Executar após o clique final na ComboBox
        String dados[] = String.valueOf(cboxCategoria.getSelectedItem()).split(" - ");
        if (!dados[0].equalsIgnoreCase("Não Informada")) {
            cboxSubCategoria.removeAllItems();
            cboxSubCategoria.addItem("Não Informada");
            listarSubCategoria(dados[0]);

        } else {
            cboxSubCategoria.removeAllItems();
            cboxSubCategoria.addItem("Não Informada");
        }
    }//GEN-LAST:event_cboxCategoriaActionPerformed

    private void cboxSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSubCategoriaActionPerformed

    }//GEN-LAST:event_cboxSubCategoriaActionPerformed

    private void cboxNacionalidadeDoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxNacionalidadeDoAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxNacionalidadeDoAutorActionPerformed

    private void cboxAvaliacaoDoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAvaliacaoDoLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAvaliacaoDoLivroActionPerformed

    private void btnProximaAbaLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaAbaLivroActionPerformed
        this.janelaDeAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btnProximaAbaLivroActionPerformed

    private void btnLimparAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAutorActionPerformed

        // Limpar os campos já preenchidos e define valor "Selecione" para todas as JComboBox
        txtNomeDoAutor.setText("");
        cboxSexoDoAutor.setSelectedItem("Não Informado");
        cboxNacionalidadeDoAutor.setSelectedItem("Não Informada");
    }//GEN-LAST:event_btnLimparAutorActionPerformed

    private void btnLimparAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAvaliacaoActionPerformed
        // Limpar os campos já preenchidos e define valor "Não Informado" para todas as JComboBox
        cboxAvaliacaoDoLivro.setSelectedItem("Não Informada");
        txtComentarioAvaliacao.setText("");
    }//GEN-LAST:event_btnLimparAvaliacaoActionPerformed

    private void btnProximaAbaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaAbaAutorActionPerformed
        this.janelaDeAbas.setSelectedIndex(2);
    }//GEN-LAST:event_btnProximaAbaAutorActionPerformed

    private void txtNumeroDePaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDePaginasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDePaginasActionPerformed

    private void txtNumeroDePaginasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDePaginasKeyPressed
        String anoDePublicacao = txtNumeroDePaginas.getText();
        int tamanho = anoDePublicacao.length();
        char c = evt.getKeyChar();
        int keyCode = evt.getExtendedKeyCode();

        // Permite usar teclas como "Back Space" e "Delete" para corrigir algum erro.
        if (keyCode == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_DELETE) {
            txtNumeroDePaginas.setEditable(true);
        } else if (!Character.isDigit(c)) {
            evt.consume(); // Se não for um número, impede a entrada.
        } else {
            if (tamanho >= 4) {
                txtNumeroDePaginas.setEditable(false); // Desabilita a edição.
                Timer timer = new Timer(500, e -> {
                    txtNumeroDePaginas.setEditable(true); // Habilita novamente após 500ms.
                    ((Timer) e.getSource()).stop(); // Para o timer após a execução.
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                txtNumeroDePaginas.setEditable(true); // Permite a edição se ainda não atingiu o limite
            }
        }
    }//GEN-LAST:event_txtNumeroDePaginasKeyPressed

    private void cboxIsbnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxIsbnSelectActionPerformed
        String selecionado = cboxIsbnSelect.getSelectedItem().toString();

        formatedIsbn.setValue(null);

        if (selecionado.equals("ISBN-13")) {
            formatedIsbn.setEditable(true);
            //formatedIsbn.setBorder(javax.swing.BorderFactory.createTitledBorder("ISBN-13 *"));
            try {
                formatedIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-###-####-#")));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (selecionado.equals("ISBN-10")) {
            formatedIsbn.setEditable(true);
            //formatedIsbn.setBorder(javax.swing.BorderFactory.createTitledBorder("ISBN-10 *"));
            try {
                formatedIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-###-#####-#")));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            formatedIsbn.setEditable(false);
            //formatedIsbn.setBorder(javax.swing.BorderFactory.createTitledBorder("ISBN *"));
            try {
                formatedIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboxIsbnSelectActionPerformed

    private void formatedIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatedIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formatedIsbnActionPerformed

    private void btnBuscarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutorActionPerformed
        String pesquisa = txtAutorPesquisado.getText();
        if (pesquisa.length() < 3) {
            JOptionPane.showMessageDialog(null, "Use pelo menos 3 caracteres na busca.");
        } else {
            AutorDAO.mostraNomePaisESexoDoAutor(cboxResultadoBuscaAutor, pesquisa);
        }
    }//GEN-LAST:event_btnBuscarAutorActionPerformed

    private void btnSelecionarResultadoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarResultadoAutorActionPerformed
        if (cboxResultadoBuscaAutor.getSelectedItem() != null) {

            String cboxSelecionarAuto = cboxResultadoBuscaAutor.getSelectedItem().toString();
            String caixaDeAutoresSelecionados = txtCampoDeAutoresSelecionados.getText();

            if (cboxSelecionarAuto.equals("Nada encontrado")) {
                JOptionPane.showMessageDialog(null, "Selecione um valor válido.");
            } else {

                if (caixaDeAutoresSelecionados.isEmpty()) {
                    txtCampoDeAutoresSelecionados.setText(cboxSelecionarAuto);
                } else {
                    txtCampoDeAutoresSelecionados.setText(caixaDeAutoresSelecionados + "\n" + cboxResultadoBuscaAutor.getSelectedItem().toString());
                }
            }

            // Limpa os campos depois da adicionar o autor.
            txtAutorPesquisado.setText("");
            cboxResultadoBuscaAutor.removeAllItems();
        } else {
            JOptionPane.showMessageDialog(null, "Não existe nenhum autor na ComboBox.");
        }
    }//GEN-LAST:event_btnSelecionarResultadoAutorActionPerformed

    private void txtNomeDoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDoAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDoAutorActionPerformed

    private void btnLimparAutoresSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAutoresSelecionadosActionPerformed
        txtCampoDeAutoresSelecionados.setText("");
        txtAutorPesquisado.setText("");
        cboxResultadoBuscaAutor.removeAllItems();
    }//GEN-LAST:event_btnLimparAutoresSelecionadosActionPerformed

    private void btnCadastraAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraAutorActionPerformed
        Autor autor = new Autor();
        AutorDAO autorDao = new AutorDAO();

        String autorNome = txtNomeDoAutor.getText();
        String autorSexo = cboxSexoDoAutor.getSelectedItem().toString();
        String autorNacionalidade = cboxNacionalidadeDoAutor.getSelectedItem().toString();

        autor.setNome(autorNome);
        autor.setNacionalidade(autorNacionalidade);

        String valorSelecionado = "OUTRO"; // Valor padrão.

        if (autorSexo.equals("Masculino")) {
            valorSelecionado = "MASC";
        } else if (autorSexo.equals("Feminino")) {
            valorSelecionado = "FEM";
        }

        autor.setSexo(valorSelecionado);

        // Verifica se o autor já está cadastrado antes de fazer o insert no banco.
        if (autorDao.verificaSeAutorJaEstaCadastrado(autor) == true) {
            JOptionPane.showMessageDialog(null, "Autor cadastrado. Por favor utilize a busca para selecionar.");
        } else {
            autorDao.cadastraAutor(autor);

            txtNomeDoAutor.setText("");
            txtNomeDoAutor.setEditable(false);
            txtNomeDoAutor.setFocusable(false);

            cboxSexoDoAutor.setSelectedItem("Não Informado");
            cboxSexoDoAutor.setEnabled(false);
            cboxSexoDoAutor.setFocusable(false);

            cboxNacionalidadeDoAutor.setSelectedItem("Não Informada");
            cboxNacionalidadeDoAutor.setEnabled(false);
            cboxNacionalidadeDoAutor.setFocusable(false);
        }

        selectTabelaAutor();
    }//GEN-LAST:event_btnCadastraAutorActionPerformed

    private void btnAutorNaoCadastradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorNaoCadastradoActionPerformed
        txtNomeDoAutor.setEditable(true);
        txtNomeDoAutor.setFocusable(true);

        cboxSexoDoAutor.setEnabled(true);
        cboxSexoDoAutor.setFocusable(true);

        cboxNacionalidadeDoAutor.setEnabled(true);
        cboxNacionalidadeDoAutor.setFocusable(true);

        btnCadastraAutor.setEnabled(true);
    }//GEN-LAST:event_btnAutorNaoCadastradoActionPerformed

    private void txtNumeroDePaginasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDePaginasKeyTyped
        // Impede que texto seja digitado no campo.
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroDePaginasKeyTyped

    private void cboxResultadoBuscaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxResultadoBuscaAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxResultadoBuscaAutorActionPerformed

    private void AvaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvaButton1ActionPerformed
        Avaliacao avaliacao = new Avaliacao();
        new TelaAvaliacao(avaliacao).setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_AvaButton1ActionPerformed

    private void btnEncerrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarSessaoActionPerformed
        // TODO add your handling code here:
        new TelaDeLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEncerrarSessaoActionPerformed

    private void edicaoUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edicaoUserButtonActionPerformed

        UsuarioCadastroDAO userdao = new UsuarioCadastroDAO();
        Usuario user = new Usuario();
        Endereco endereco = new Endereco();
        Favoritos favoritos = new Favoritos();
        Telefone telefone = new Telefone();

        // Solicita o nome do usuário ao usuário
        String userNome = JOptionPane.showInputDialog(this, "Digite o nick do usuário a ser editado:", "Edição de Usuario", JOptionPane.QUESTION_MESSAGE);

        // Verifica se o usuário inseriu um nome
        if (userNome != null) {
            // Verifica se o nome fornecido não está vazio
            if (!userNome.isEmpty()) {
                // Obtém o usuário com base no nome fornecido
                user = userdao.obterUsuarioPorNome(userNome);

                // Verifica se o usuário foi encontrado
                if (user.getUserId() != 0) {
                    // Criar um JPanel personalizado com um JPasswordField
                    JPanel panel = new JPanel();
                    JLabel label = new JLabel("Senha:");
                    JPasswordField passwordField = new JPasswordField(10);
                    panel.add(label);
                    panel.add(passwordField);

                    // Exibir o JOptionPane com o JPanel personalizado
                    int result = JOptionPane.showOptionDialog(null, panel, "Digite a senha",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                    // Verificar a resposta do JOptionPane
                    if (result == JOptionPane.OK_OPTION) {
                        // Obtém a senha do usuário
                        char[] senhaDigitada = passwordField.getPassword();

                        // Verifica se a senha digitada coincide com a senha do banco
                        String senhaDoBanco = userdao.obterSenhaPorNome(userNome);
                        Hash rehash = new Hash();

                        try {
                            String senhaDigitadaHash = rehash.geradorDeHash(new String(senhaDigitada));
                            if (senhaDoBanco != null && senhaDoBanco.equals(senhaDigitadaHash)) {
                                // Abre a tela de edição com os dados do usuário
                                EdicaoUsuario edicaoUsuarioFrame = new EdicaoUsuario(user, endereco, telefone, favoritos);
                                edicaoUsuarioFrame.setVisible(true);
                                this.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(this, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Digite um nome de usuário válido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Usuário pressionou Cancelar
            JOptionPane.showMessageDialog(this, "Operação cancelada pelo usuário", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_edicaoUserButtonActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void CadUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadUserButtonActionPerformed
        new CadastroUsuario().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadUserButtonActionPerformed

    private void ExcluirUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirUserButtonActionPerformed

        ExcluirUserDAO ex = new ExcluirUserDAO();
        ex.mostrarEExcluirUsuario();
    }//GEN-LAST:event_ExcluirUserButtonActionPerformed

    private void btnEdicaoDeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdicaoDeLivroActionPerformed
        new EdicaoDeLivro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEdicaoDeLivroActionPerformed

    private void txtAnoDePublicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoDePublicacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoDePublicacaoActionPerformed

    private void txtAnoDePublicacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoDePublicacaoKeyPressed
        String anoDePublicacao = txtAnoDePublicacao.getText();
        int tamanho = anoDePublicacao.length();
        char c = evt.getKeyChar();
        int keyCode = evt.getExtendedKeyCode();

        // Permite usar teclas como "Back Space" e "Delete" para corrigir algum erro.
        if (keyCode == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_DELETE) {
            txtAnoDePublicacao.setEditable(true);
        } else if (!Character.isDigit(c)) {
            evt.consume(); // Se não for um número, impede a entrada.
        } else {
            if (tamanho >= 4) {
                txtAnoDePublicacao.setEditable(false); // Desabilita a edição.
                Timer timer = new Timer(500, e -> {
                    txtAnoDePublicacao.setEditable(true); // Habilita novamente após 500ms.
                    ((Timer) e.getSource()).stop(); // Para o timer após a execução.
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                txtAnoDePublicacao.setEditable(true); // Permite a edição se ainda não atingiu o limite
            }
        }
    }//GEN-LAST:event_txtAnoDePublicacaoKeyPressed

    private void txtAnoDePublicacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoDePublicacaoKeyTyped
        // Impede que texto seja digitado no campo.
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnoDePublicacaoKeyTyped


    private void btnInserirCapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirCapaActionPerformed
        JFileChooser seletorDeImagem = new JFileChooser();
        int resultado = seletorDeImagem.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = seletorDeImagem.getSelectedFile();
            String caminho = arquivo.getAbsolutePath();
            try {
                // Para redimensionar a imagem.
                BufferedImage redimensionar = ImageIO.read(new File(caminho));
                // O tamanho da imagem.
                Image imagem = redimensionar.getScaledInstance(150, 210, Image.SCALE_SMOOTH);
                ImageIcon icone = new ImageIcon(imagem);
                jlbCapaDoLivro.setIcon(icone);
            } catch (IOException ex) {
                Logger.getLogger(EdicaoDeLivro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Nenhuma imagem foi selecionada.");
        }
    }//GEN-LAST:event_btnInserirCapaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroDeLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDeLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDeLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDeLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDeLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AvaButton1;
    private javax.swing.JButton CadUserButton;
    private javax.swing.JToggleButton ExcluirUserButton;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JScrollPane boxAutoresSelecionados;
    private javax.swing.JScrollPane boxComentarioAvaliacao;
    private javax.swing.JScrollPane boxSinopse;
    private javax.swing.JScrollPane boxTabelaAutor;
    private javax.swing.JScrollPane boxTabelaAvaliacao;
    private javax.swing.JScrollPane boxTabelaLivro;
    private javax.swing.JButton btnAutorNaoCadastrado;
    private javax.swing.JButton btnBuscarAutor;
    private javax.swing.JButton btnCadastraAutor;
    private javax.swing.JButton btnEdicaoDeLivro;
    private javax.swing.JButton btnEncerrarSessao;
    private javax.swing.JButton btnFinalizarCadastro;
    private javax.swing.JButton btnInserirCapa;
    private javax.swing.JButton btnLimparAutor;
    private javax.swing.JButton btnLimparAutoresSelecionados;
    private javax.swing.JButton btnLimparAvaliacao;
    private javax.swing.JButton btnLimparLivro;
    private javax.swing.JButton btnProximaAbaAutor;
    private javax.swing.JButton btnProximaAbaLivro;
    private javax.swing.JButton btnSelecionarResultadoAutor;
    private javax.swing.JButton btnTelaPrinCadLivro;
    private javax.swing.JComboBox<String> cboxAvaliacaoDoLivro;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxIsbnSelect;
    private javax.swing.JComboBox<String> cboxLivroIdioma;
    private javax.swing.JComboBox<String> cboxNacionalidadeDoAutor;
    private javax.swing.JComboBox<String> cboxResultadoBuscaAutor;
    private javax.swing.JComboBox<String> cboxSexoDoAutor;
    private javax.swing.JComboBox<String> cboxSubCategoria;
    private javax.swing.JButton edicaoUserButton;
    private javax.swing.JFormattedTextField formatedIsbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane janelaDeAbas;
    private javax.swing.JLabel jlbCapaDoLivro;
    private javax.swing.JPanel jpnAutor;
    private javax.swing.JPanel jpnAvaliacao;
    private javax.swing.JPanel jpnLivro;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JTable tbAutor;
    private javax.swing.JTable tbAvaliacao;
    private javax.swing.JTable tbLivro;
    private javax.swing.JTextField txtAnoDePublicacao;
    private javax.swing.JTextField txtAutorPesquisado;
    private javax.swing.JTextArea txtCampoDeAutoresSelecionados;
    private javax.swing.JTextArea txtComentarioAvaliacao;
    private javax.swing.JTextField txtNomeDaEditora;
    private javax.swing.JTextField txtNomeDoAutor;
    private javax.swing.JTextField txtNumeroDePaginas;
    private javax.swing.JTextArea txtSinopseDoLivro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
