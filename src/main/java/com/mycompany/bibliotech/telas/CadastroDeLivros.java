package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.dao.AutorDAO;
import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.LivroAutorDAO;
import com.mycompany.bibliotech.dao.LivroDAO;
import com.mycompany.bibliotech.model.bean.ApplicationContext;
import com.mycompany.bibliotech.model.bean.Autor;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.Livro;
import com.mycompany.bibliotech.model.bean.Login;
import com.mycompany.bibliotech.model.bean.ValidadorIsbn;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class CadastroDeLivros extends javax.swing.JFrame {

    public CadastroDeLivros() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbSelect.getModel();
        tbSelect.setRowSorter(new TableRowSorter(modelo));
        listarCategorias();
        listarNacionalidades();
        listarIdiomasDoLivro();
        readJTable();
        // Impede que o ISBN seja setado sem selecionar o tipo quando abre a tela.
        formatedIsbn.setEditable(false);
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

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tbSelect.getModel();
        tbSelect.setDefaultRenderer(Object.class, new CenterRenderer());
        JTableHeader header = tbSelect.getTableHeader();
        header.setDefaultRenderer(new CenterRenderer());

        // Para evitar que todos os dados sejam duplicados após um insert
        modelo.setNumRows(0);

        LivroDAO ldao = new LivroDAO();

        for (Livro l : ldao.read()) {

            modelo.addRow(new Object[]{
                l.getId(),
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        janelaDeAbas = new javax.swing.JTabbedPane();
        jpnLivro = new javax.swing.JPanel();
        txtDeBoasVindasLivro = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAnoDePublicacao = new javax.swing.JTextField();
        txtNumeroDePaginas = new javax.swing.JTextField();
        cboxCategoria = new javax.swing.JComboBox<>();
        cboxSubCategoria = new javax.swing.JComboBox<>();
        cboxLivroIdioma = new javax.swing.JComboBox<>();
        txtNomeDaEditora = new javax.swing.JTextField();
        boxSinopse = new javax.swing.JScrollPane();
        txtSinopseDoLivro = new javax.swing.JTextArea();
        btnTelaPrinCadLivro = new javax.swing.JButton();
        btnLimparLivro = new javax.swing.JButton();
        btnProximaAbaLivro = new javax.swing.JButton();
        btnEditarLivro = new javax.swing.JButton();
        btnDeletarLivro = new javax.swing.JButton();
        formatedIsbn = new javax.swing.JFormattedTextField();
        cboxIsbnSelect = new javax.swing.JComboBox<>();
        jpnAutor = new javax.swing.JPanel();
        txtDeBoasVindasAutor = new javax.swing.JTextField();
        btnTelaPrinCadAutor = new javax.swing.JButton();
        btnLimparAutor = new javax.swing.JButton();
        btnProximaAbaAutor = new javax.swing.JButton();
        jpnCadastroAutor = new javax.swing.JPanel();
        txtNomeDoAutor = new javax.swing.JTextField();
        cboxSexoDoAutor = new javax.swing.JComboBox<>();
        cboxNacionalidadeDoAutor = new javax.swing.JComboBox<>();
        btnCadastraAutor = new javax.swing.JButton();
        jpnSelecaoAutorCadastrado = new javax.swing.JPanel();
        btnBuscarAutor = new javax.swing.JButton();
        btnSelecionarResultadoAutor = new javax.swing.JButton();
        cboxResultadoBuscaAutor = new javax.swing.JComboBox<>();
        txtAutorPesquisado = new javax.swing.JTextField();
        btnLimparAutoresSelecionados = new javax.swing.JButton();
        boxAutoresSelecionados = new javax.swing.JScrollPane();
        txtCampoDeAutoresSelecionados = new javax.swing.JTextArea();
        btnAutorNaoCadastrado = new javax.swing.JButton();
        jpnAvaliacao = new javax.swing.JPanel();
        txtDeBoasVindasAvaliacao = new javax.swing.JTextField();
        cboxAvaliacaoDoLivro = new javax.swing.JComboBox<>();
        boxComentarioAvaliacao = new javax.swing.JScrollPane();
        txtComentarioAvaliacao = new javax.swing.JTextArea();
        btnTelaPrinCadAvaliacao = new javax.swing.JButton();
        btnLimparAvaliacao = new javax.swing.JButton();
        btnFinalizarCadastro = new javax.swing.JButton();
        jpnSelect = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSelect = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        janelaDeAbas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jpnLivro.setBackground(new java.awt.Color(255, 255, 255));

        txtDeBoasVindasLivro.setEditable(false);
        txtDeBoasVindasLivro.setBackground(new java.awt.Color(255, 255, 255));
        txtDeBoasVindasLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDeBoasVindasLivro.setText("Bem-vindo ao formulário de cadastro de livro. Os campo com asterisco são de preenchimento obrigatório.");
        txtDeBoasVindasLivro.setBorder(null);
        txtDeBoasVindasLivro.setFocusable(false);
        txtDeBoasVindasLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeBoasVindasLivroActionPerformed(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Título *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtAnoDePublicacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAnoDePublicacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ano de Publicação *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
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

        txtNumeroDePaginas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNumeroDePaginas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de Páginas *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
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

        cboxCategoria.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaActionPerformed(evt);
            }
        });

        cboxSubCategoria.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSubCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxSubCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sub-categoria *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSubCategoriaActionPerformed(evt);
            }
        });

        cboxLivroIdioma.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxLivroIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informado" }));
        cboxLivroIdioma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Idioma *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtNomeDaEditora.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeDaEditora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome da Editora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        boxSinopse.setBackground(new java.awt.Color(255, 255, 255));
        boxSinopse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sinopse do Livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtSinopseDoLivro.setColumns(20);
        txtSinopseDoLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSinopseDoLivro.setLineWrap(true);
        txtSinopseDoLivro.setRows(5);
        boxSinopse.setViewportView(txtSinopseDoLivro);

        btnTelaPrinCadLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnTelaPrinCadLivro.setText("Tela Principal");
        btnTelaPrinCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaPrinCadLivroActionPerformed(evt);
            }
        });

        btnLimparLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparLivro.setText("Limpar");
        btnLimparLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparLivroActionPerformed(evt);
            }
        });

        btnProximaAbaLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnProximaAbaLivro.setText("Próxima Aba");
        btnProximaAbaLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaAbaLivroActionPerformed(evt);
            }
        });

        btnEditarLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEditarLivro.setText("Editar");

        btnDeletarLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnDeletarLivro.setText("Deletar");

        formatedIsbn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISBN *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        try {
            formatedIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formatedIsbn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        formatedIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatedIsbnActionPerformed(evt);
            }
        });

        cboxIsbnSelect.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxIsbnSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "ISBN-13", "ISBN-10" }));
        cboxIsbnSelect.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxIsbnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxIsbnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnLivroLayout = new javax.swing.GroupLayout(jpnLivro);
        jpnLivro.setLayout(jpnLivroLayout);
        jpnLivroLayout.setHorizontalGroup(
            jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLivroLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDeBoasVindasLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnLivroLayout.createSequentialGroup()
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnLivroLayout.createSequentialGroup()
                                .addComponent(btnProximaAbaLivro)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarLivro)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletarLivro))
                            .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnLivroLayout.createSequentialGroup()
                        .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpnLivroLayout.createSequentialGroup()
                                    .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLivroLayout.createSequentialGroup()
                                    .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cboxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpnLivroLayout.createSequentialGroup()
                                    .addComponent(btnTelaPrinCadLivro)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLimparLivro)))
                            .addGroup(jpnLivroLayout.createSequentialGroup()
                                .addComponent(cboxIsbnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(formatedIsbn)))
                        .addGap(18, 18, 18)
                        .addComponent(boxSinopse)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jpnLivroLayout.setVerticalGroup(
            jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLivroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtDeBoasVindasLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnLivroLayout.createSequentialGroup()
                        .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(formatedIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(cboxIsbnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(boxSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLivroLayout.createSequentialGroup()
                        .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimparLivro)
                            .addComponent(btnTelaPrinCadLivro))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLivroLayout.createSequentialGroup()
                        .addGroup(jpnLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeletarLivro)
                            .addComponent(btnEditarLivro)
                            .addComponent(btnProximaAbaLivro))
                        .addGap(16, 16, 16))))
        );

        janelaDeAbas.addTab("Livro", jpnLivro);

        jpnAutor.setBackground(new java.awt.Color(255, 255, 255));
        jpnAutor.setPreferredSize(new java.awt.Dimension(1280, 390));

        txtDeBoasVindasAutor.setEditable(false);
        txtDeBoasVindasAutor.setBackground(new java.awt.Color(255, 255, 255));
        txtDeBoasVindasAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDeBoasVindasAutor.setText("Bem-vindo ao formulário de cadastro do autor. Os campo com asterisco são de preenchimento obrigatório.");
        txtDeBoasVindasAutor.setBorder(null);
        txtDeBoasVindasAutor.setFocusable(false);

        btnTelaPrinCadAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnTelaPrinCadAutor.setText("Tela Principal");
        btnTelaPrinCadAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaPrinCadAutorActionPerformed(evt);
            }
        });

        btnLimparAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparAutor.setText("Limpar");
        btnLimparAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAutorActionPerformed(evt);
            }
        });

        btnProximaAbaAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnProximaAbaAutor.setText("Próxima Aba");
        btnProximaAbaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaAbaAutorActionPerformed(evt);
            }
        });

        jpnCadastroAutor.setBackground(new java.awt.Color(255, 255, 255));
        jpnCadastroAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Autor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jpnCadastroAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        txtNomeDoAutor.setEditable(false);
        txtNomeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeDoAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        txtNomeDoAutor.setFocusable(false);
        txtNomeDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDoAutorActionPerformed(evt);
            }
        });

        cboxSexoDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSexoDoAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informado", "Masculino", "Feminino" }));
        cboxSexoDoAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxSexoDoAutor.setEnabled(false);
        cboxSexoDoAutor.setFocusable(false);
        cboxSexoDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSexoDoAutorActionPerformed(evt);
            }
        });

        cboxNacionalidadeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxNacionalidadeDoAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxNacionalidadeDoAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nacionalidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxNacionalidadeDoAutor.setEnabled(false);
        cboxNacionalidadeDoAutor.setFocusable(false);
        cboxNacionalidadeDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNacionalidadeDoAutorActionPerformed(evt);
            }
        });

        btnCadastraAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCadastraAutor.setText("Cadastrar");
        btnCadastraAutor.setEnabled(false);
        btnCadastraAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnCadastroAutorLayout = new javax.swing.GroupLayout(jpnCadastroAutor);
        jpnCadastroAutor.setLayout(jpnCadastroAutorLayout);
        jpnCadastroAutorLayout.setHorizontalGroup(
            jpnCadastroAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroAutorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpnCadastroAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNomeDoAutor)
                    .addComponent(cboxSexoDoAutor, 0, 390, Short.MAX_VALUE)
                    .addComponent(cboxNacionalidadeDoAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastraAutor)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpnCadastroAutorLayout.setVerticalGroup(
            jpnCadastroAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroAutorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCadastroAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastraAutor)
                    .addGroup(jpnCadastroAutorLayout.createSequentialGroup()
                        .addComponent(txtNomeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxSexoDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxNacionalidadeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnSelecaoAutorCadastrado.setBackground(new java.awt.Color(255, 255, 255));
        jpnSelecaoAutorCadastrado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleção de Autor Cadastrado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jpnSelecaoAutorCadastrado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        btnBuscarAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnBuscarAutor.setText("Buscar");
        btnBuscarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutorActionPerformed(evt);
            }
        });

        btnSelecionarResultadoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSelecionarResultadoAutor.setText("Selecionar");
        btnSelecionarResultadoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarResultadoAutorActionPerformed(evt);
            }
        });

        cboxResultadoBuscaAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxResultadoBuscaAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxResultadoBuscaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxResultadoBuscaAutorActionPerformed(evt);
            }
        });

        txtAutorPesquisado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAutorPesquisado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Autor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        btnLimparAutoresSelecionados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparAutoresSelecionados.setText("Limpar");
        btnLimparAutoresSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAutoresSelecionadosActionPerformed(evt);
            }
        });

        txtCampoDeAutoresSelecionados.setEditable(false);
        txtCampoDeAutoresSelecionados.setBackground(new java.awt.Color(255, 255, 255));
        txtCampoDeAutoresSelecionados.setColumns(20);
        txtCampoDeAutoresSelecionados.setRows(5);
        txtCampoDeAutoresSelecionados.setFocusable(false);
        boxAutoresSelecionados.setViewportView(txtCampoDeAutoresSelecionados);

        javax.swing.GroupLayout jpnSelecaoAutorCadastradoLayout = new javax.swing.GroupLayout(jpnSelecaoAutorCadastrado);
        jpnSelecaoAutorCadastrado.setLayout(jpnSelecaoAutorCadastradoLayout);
        jpnSelecaoAutorCadastradoLayout.setHorizontalGroup(
            jpnSelecaoAutorCadastradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSelecaoAutorCadastradoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpnSelecaoAutorCadastradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxAutoresSelecionados)
                    .addComponent(txtAutorPesquisado, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(cboxResultadoBuscaAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpnSelecaoAutorCadastradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelecionarResultadoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimparAutoresSelecionados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpnSelecaoAutorCadastradoLayout.setVerticalGroup(
            jpnSelecaoAutorCadastradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSelecaoAutorCadastradoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnSelecaoAutorCadastradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutorPesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnSelecaoAutorCadastradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxResultadoBuscaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarResultadoAutor))
                .addGap(18, 18, 18)
                .addGroup(jpnSelecaoAutorCadastradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimparAutoresSelecionados)
                    .addComponent(boxAutoresSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnAutorNaoCadastrado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnAutorNaoCadastrado.setText("Autor Não Cadastrado");
        btnAutorNaoCadastrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorNaoCadastradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnAutorLayout = new javax.swing.GroupLayout(jpnAutor);
        jpnAutor.setLayout(jpnAutorLayout);
        jpnAutorLayout.setHorizontalGroup(
            jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAutorLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDeBoasVindasAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnAutorLayout.createSequentialGroup()
                        .addGroup(jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpnAutorLayout.createSequentialGroup()
                                .addComponent(btnTelaPrinCadAutor)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimparAutor)
                                .addGap(203, 203, 203)
                                .addComponent(btnAutorNaoCadastrado))
                            .addComponent(jpnSelecaoAutorCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnAutorLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jpnCadastroAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnAutorLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnProximaAbaAutor)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jpnAutorLayout.setVerticalGroup(
            jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAutorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtDeBoasVindasAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnSelecaoAutorCadastrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnCadastroAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpnAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTelaPrinCadAutor)
                    .addComponent(btnLimparAutor)
                    .addComponent(btnProximaAbaAutor)
                    .addComponent(btnAutorNaoCadastrado))
                .addGap(20, 20, 20))
        );

        jpnCadastroAutor.getAccessibleContext().setAccessibleName("Cadastrar Autor");

        janelaDeAbas.addTab("Autor", jpnAutor);

        jpnAvaliacao.setBackground(new java.awt.Color(255, 255, 255));

        txtDeBoasVindasAvaliacao.setEditable(false);
        txtDeBoasVindasAvaliacao.setBackground(new java.awt.Color(255, 255, 255));
        txtDeBoasVindasAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDeBoasVindasAvaliacao.setText("Bem-vindo ao formulário de avaliação. Os campo com asterisco são de preenchimento obrigatório.");
        txtDeBoasVindasAvaliacao.setBorder(null);
        txtDeBoasVindasAvaliacao.setFocusable(false);
        txtDeBoasVindasAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeBoasVindasAvaliacaoActionPerformed(evt);
            }
        });

        cboxAvaliacaoDoLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxAvaliacaoDoLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada", "10 - Excelente", "9 - Ótimo", "8 - Muito Bom", "7 - Bom", "6 - Satisfatório", "5 - Regular", "4 - Abaixo da Média", "3 - Ruim", "2 - Muito Ruim", "1 - Péssimo", "0 - Inaceitável" }));
        cboxAvaliacaoDoLivro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avaliação *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
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
        txtComentarioAvaliacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comentário da Avaliação *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        boxComentarioAvaliacao.setViewportView(txtComentarioAvaliacao);

        btnTelaPrinCadAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnTelaPrinCadAvaliacao.setText("Tela Principal");
        btnTelaPrinCadAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaPrinCadAvaliacaoActionPerformed(evt);
            }
        });

        btnLimparAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparAvaliacao.setText("Limpar");
        btnLimparAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAvaliacaoActionPerformed(evt);
            }
        });

        btnFinalizarCadastro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnFinalizarCadastro.setText("Finalizar Cadastro");
        btnFinalizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnAvaliacaoLayout = new javax.swing.GroupLayout(jpnAvaliacao);
        jpnAvaliacao.setLayout(jpnAvaliacaoLayout);
        jpnAvaliacaoLayout.setHorizontalGroup(
            jpnAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAvaliacaoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpnAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnAvaliacaoLayout.createSequentialGroup()
                        .addComponent(btnTelaPrinCadAvaliacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparAvaliacao)
                        .addGap(875, 875, 875)
                        .addComponent(btnFinalizarCadastro))
                    .addGroup(jpnAvaliacaoLayout.createSequentialGroup()
                        .addComponent(txtDeBoasVindasAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(621, 621, 621))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnAvaliacaoLayout.createSequentialGroup()
                        .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxComentarioAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jpnAvaliacaoLayout.setVerticalGroup(
            jpnAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAvaliacaoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtDeBoasVindasAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxComentarioAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jpnAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTelaPrinCadAvaliacao)
                    .addComponent(btnLimparAvaliacao)
                    .addComponent(btnFinalizarCadastro))
                .addGap(16, 16, 16))
        );

        janelaDeAbas.addTab("Avaliação", jpnAvaliacao);

        jpnSelect.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbSelect.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tbSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "ISBN", "Ano", "Nº de Páginas", "Categoria", "Sub-categoria", "Idioma", "Editora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSelect);

        javax.swing.GroupLayout jpnSelectLayout = new javax.swing.GroupLayout(jpnSelect);
        jpnSelect.setLayout(jpnSelectLayout);
        jpnSelectLayout.setHorizontalGroup(
            jpnSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpnSelectLayout.setVerticalGroup(
            jpnSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(janelaDeAbas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(janelaDeAbas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCadastroActionPerformed

        Livro livro = new Livro();
        Autor autor = new Autor();
        Avaliacao avaliacao = new Avaliacao();
        Login login = ApplicationContext.getLogin();
        ValidadorIsbn validadorIsbn = new ValidadorIsbn();
        LivroDAO livroDao = new LivroDAO();
        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
        LivroAutorDAO livroAutorDao = new LivroAutorDAO();

        // Captura informações preenchidas na aba Livro.
        String livroTitulo = txtTitulo.getText();
        String livroTipoIsbn = cboxIsbnSelect.getSelectedItem().toString();
        String livroNumeroIsbn = formatedIsbn.getText();
        String livroAno = txtAnoDePublicacao.getText();
        String livroNumeroDePaginas = txtNumeroDePaginas.getText();
        String livroCategoria = cboxCategoria.getSelectedItem().toString();
        String livroSubCategoria = cboxSubCategoria.getSelectedItem().toString();
        String livroEditora = txtNomeDaEditora.getText();
        String livroIdioma = cboxLivroIdioma.getSelectedItem().toString();
        String livroSinopse = txtSinopseDoLivro.getText();

        // Captura informações preenchidas na aba Avaliar Livro.
        String avaliarLivroAvaliacao = cboxAvaliacaoDoLivro.getSelectedItem().toString();
        String avaliarLivroComentario = txtComentarioAvaliacao.getText();

        // Verifica se os campos obrigatórios da aba Livro foram preenchidos corretamente.
        // Atribui um número de erro se não.
        int codigoDoErro = 0;

        if (livroTitulo.isBlank()) {
            codigoDoErro = 1;
        }

        if (livroTipoIsbn.equals("Selecione")) {
            codigoDoErro = 2;
        }

        if (validadorIsbn.valida(livroNumeroIsbn) == false) {
            codigoDoErro = 3;
        }

        if (livroDao.verificaDuplicidadeIsbn(livroNumeroIsbn).equals(livroNumeroIsbn)) {
            codigoDoErro = 4;
        }

        if (livroAno.isBlank()) {
            codigoDoErro = 5;
        }

        if (livroNumeroDePaginas.isBlank()) {
            codigoDoErro = 6;
        }

        if (livroCategoria.equals("Não Informada") || livroSubCategoria.equals("Não Informada")) {
            codigoDoErro = 7;
        }

        if (livroIdioma.equals("Não Informado")) {
            codigoDoErro = 8;
        }

        // Verifica se os campos obrigatórios da aba Avaliação foram preenchidos corretamente.
        if (avaliarLivroAvaliacao.equals("Não Informada")) {
            codigoDoErro = 9;
        }

        if (avaliarLivroComentario.isBlank()) {
            codigoDoErro = 10;
        }

        // Usa o código de erro atribuído anteriormente e mostra uma mensagem.
        switch (codigoDoErro) {
            case 1 ->
                JOptionPane.showMessageDialog(null, "Digite um título válido para o livro.");
            case 2 ->
                JOptionPane.showMessageDialog(null, "Selecione o tipo do ISBN.");
            case 3 ->
                JOptionPane.showMessageDialog(null, "ISBN inválido.");
            case 4 ->
                JOptionPane.showMessageDialog(null, "Esse ISBN já está cadastrado.");
            case 5 ->
                JOptionPane.showMessageDialog(null, "Digite o ano de publicação do livro.");
            case 6 ->
                JOptionPane.showMessageDialog(null, "Digite o número de páginas do livro.");
            case 7 ->
                JOptionPane.showMessageDialog(null, "Você precisa selecionar a categoria e sub-categoria do livro.");
            case 8 ->
                JOptionPane.showMessageDialog(null, "Selecione um idioma para o livro.");
            case 9 ->
                JOptionPane.showMessageDialog(null, "Selecione uma nota para o livro");
            case 10 ->
                JOptionPane.showMessageDialog(null, "Faça o comentário da avaliação");
            default -> { // Caso nenhum erro seja encontrado.

                livro.setTitulo(livroTitulo);
                livro.setIsbn(livroNumeroIsbn);
                livro.setAnoDePublicacao(Integer.parseInt(livroAno));
                livro.setNumeroDePaginas(Integer.parseInt(livroNumeroDePaginas));
                livro.setCategoria(livroCategoria);
                livro.setSubCategoria(livroSubCategoria);
                livro.setIdioma(livroIdioma);
                livro.setEditora(livroEditora);
                livro.setSinopse(livroSinopse);

                // Avaliação
                avaliacao.setAvaliacaoDoUsuario(avaliarLivroAvaliacao.substring(0, 2));
                avaliacao.setComentarioAvaliacao(avaliarLivroComentario);

                livroDao.create(livro);

                // Usa o nick do usuário logado para informar quem avaliou o livro.
                avaliacaoDao.create(avaliacao, txtTitulo.getText(), login.getNick());

                // Captura o ID do livro cadastrado.
                String idDoLivro = livroAutorDao.buscaIdDoLivro(livro);

                // Tabela LivroAutor
                // Os autores que foram selecionados pelo usuário.
                String todosOsAutoresSelecionados = txtCampoDeAutoresSelecionados.getText();

                // A quantidade de linhas da string (quantidade de autores).
                String[] arrayDeAutores = todosOsAutoresSelecionados.split("\n");
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
                readJTable();
            }
        }
    }//GEN-LAST:event_btnFinalizarCadastroActionPerformed

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
        new TelaPrincipalCliente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTelaPrinCadLivroActionPerformed

    private void cboxSexoDoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSexoDoAutorActionPerformed

    }//GEN-LAST:event_cboxSexoDoAutorActionPerformed

    private void btnLimparLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparLivroActionPerformed

        // Limpar os campos já preenchidos e define valor "Não Informado" para todas as JComboBox
        txtTitulo.setText("");
        formatedIsbn.setText(null);
        txtAnoDePublicacao.setText("");
        txtNumeroDePaginas.setText("");
        cboxCategoria.setSelectedItem("Não Informada");
        cboxSubCategoria.setSelectedItem("Não Informada");
        cboxLivroIdioma.setSelectedItem("Não Informado");
        txtNomeDaEditora.setText("");
        cboxAvaliacaoDoLivro.setSelectedItem("Não Informada");
        txtComentarioAvaliacao.setText("");
        txtSinopseDoLivro.setText("");
        cboxIsbnSelect.setSelectedItem("Selecione");

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

    private void txtDeBoasVindasLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeBoasVindasLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeBoasVindasLivroActionPerformed

    private void btnProximaAbaLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaAbaLivroActionPerformed
        this.janelaDeAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btnProximaAbaLivroActionPerformed

    private void btnLimparAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAutorActionPerformed

        // Limpar os campos já preenchidos e define valor "Selecione" para todas as JComboBox
        txtNomeDoAutor.setText("");
        cboxSexoDoAutor.setSelectedItem("Não Informado");
        cboxNacionalidadeDoAutor.setSelectedItem("Não Informada");

    }//GEN-LAST:event_btnLimparAutorActionPerformed

    private void btnTelaPrinCadAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaPrinCadAutorActionPerformed
        new TelaPrincipalAdministrador().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTelaPrinCadAutorActionPerformed

    private void txtDeBoasVindasAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeBoasVindasAvaliacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeBoasVindasAvaliacaoActionPerformed

    private void btnTelaPrinCadAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaPrinCadAvaliacaoActionPerformed
        new TelaPrincipalAdministrador().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTelaPrinCadAvaliacaoActionPerformed

    private void btnLimparAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAvaliacaoActionPerformed

        // Limpar os campos já preenchidos e define valor "Não Informado" para todas as JComboBox
        cboxAvaliacaoDoLivro.setSelectedItem("Não Informada");
        txtComentarioAvaliacao.setText("");
    }//GEN-LAST:event_btnLimparAvaliacaoActionPerformed

    private void btnProximaAbaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaAbaAutorActionPerformed
        this.janelaDeAbas.setSelectedIndex(2);
    }//GEN-LAST:event_btnProximaAbaAutorActionPerformed

    private void txtAnoDePublicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoDePublicacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoDePublicacaoActionPerformed

    private void txtNumeroDePaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDePaginasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDePaginasActionPerformed

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
            formatedIsbn.setBorder(javax.swing.BorderFactory.createTitledBorder("ISBN-13"));
            try {
                formatedIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-###-####-#")));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (selecionado.equals("ISBN-10")) {
            formatedIsbn.setEditable(true);
            formatedIsbn.setBorder(javax.swing.BorderFactory.createTitledBorder("ISBN-10"));
            try {
                formatedIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-###-#####-#")));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroDeLivros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            formatedIsbn.setEditable(false);
            formatedIsbn.setBorder(javax.swing.BorderFactory.createTitledBorder("ISBN"));
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

    }//GEN-LAST:event_btnSelecionarResultadoAutorActionPerformed

    private void txtNomeDoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDoAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDoAutorActionPerformed

    private void btnLimparAutoresSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAutoresSelecionadosActionPerformed
        txtCampoDeAutoresSelecionados.setText("");
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

    private void txtAnoDePublicacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoDePublicacaoKeyTyped
        // Impede que texto seja digitado no campo.
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnoDePublicacaoKeyTyped

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
    private javax.swing.JScrollPane boxAutoresSelecionados;
    private javax.swing.JScrollPane boxComentarioAvaliacao;
    private javax.swing.JScrollPane boxSinopse;
    private javax.swing.JButton btnAutorNaoCadastrado;
    private javax.swing.JButton btnBuscarAutor;
    private javax.swing.JButton btnCadastraAutor;
    private javax.swing.JButton btnDeletarLivro;
    private javax.swing.JButton btnEditarLivro;
    private javax.swing.JButton btnFinalizarCadastro;
    private javax.swing.JButton btnLimparAutor;
    private javax.swing.JButton btnLimparAutoresSelecionados;
    private javax.swing.JButton btnLimparAvaliacao;
    private javax.swing.JButton btnLimparLivro;
    private javax.swing.JButton btnProximaAbaAutor;
    private javax.swing.JButton btnProximaAbaLivro;
    private javax.swing.JButton btnSelecionarResultadoAutor;
    private javax.swing.JButton btnTelaPrinCadAutor;
    private javax.swing.JButton btnTelaPrinCadAvaliacao;
    private javax.swing.JButton btnTelaPrinCadLivro;
    private javax.swing.JComboBox<String> cboxAvaliacaoDoLivro;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxIsbnSelect;
    private javax.swing.JComboBox<String> cboxLivroIdioma;
    private javax.swing.JComboBox<String> cboxNacionalidadeDoAutor;
    private javax.swing.JComboBox<String> cboxResultadoBuscaAutor;
    private javax.swing.JComboBox<String> cboxSexoDoAutor;
    private javax.swing.JComboBox<String> cboxSubCategoria;
    private javax.swing.JFormattedTextField formatedIsbn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane janelaDeAbas;
    private javax.swing.JPanel jpnAutor;
    private javax.swing.JPanel jpnAvaliacao;
    private javax.swing.JPanel jpnCadastroAutor;
    private javax.swing.JPanel jpnLivro;
    private javax.swing.JPanel jpnSelecaoAutorCadastrado;
    private javax.swing.JPanel jpnSelect;
    private javax.swing.JTable tbSelect;
    private javax.swing.JTextField txtAnoDePublicacao;
    private javax.swing.JTextField txtAutorPesquisado;
    private javax.swing.JTextArea txtCampoDeAutoresSelecionados;
    private javax.swing.JTextArea txtComentarioAvaliacao;
    private javax.swing.JTextField txtDeBoasVindasAutor;
    private javax.swing.JTextField txtDeBoasVindasAvaliacao;
    private javax.swing.JTextField txtDeBoasVindasLivro;
    private javax.swing.JTextField txtNomeDaEditora;
    private javax.swing.JTextField txtNomeDoAutor;
    private javax.swing.JTextField txtNumeroDePaginas;
    private javax.swing.JTextArea txtSinopseDoLivro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
