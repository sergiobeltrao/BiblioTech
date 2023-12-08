package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.ExcluirUserDAO;
import com.mycompany.bibliotech.dao.ImagemDAO;
import com.mycompany.bibliotech.dao.UsuarioCadastroDAO;
import com.mycompany.bibliotech.dao.UsuarioLoginDAO;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.Endereco;
import com.mycompany.bibliotech.model.bean.Favoritos;
import com.mycompany.bibliotech.model.bean.Hash;
import com.mycompany.bibliotech.model.bean.Telefone;
import com.mycompany.bibliotech.model.bean.Usuario;
import java.security.NoSuchAlgorithmException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class TelaMinhasAvaliacoes extends javax.swing.JFrame {

    public TelaMinhasAvaliacoes() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();
        jtbAvaliacoes.setRowSorter(new TableRowSorter(modelo));
        selectTabelaLivro();
        UsuarioLoginDAO usuarioLoginDao = new UsuarioLoginDAO();

        if (usuarioLoginDao.tipoDoUsuarioLogado()) {
            CadUserButton.setVisible(true);
            ExcluirUserButton.setVisible(true);
            btnEdicaoDeLivro.setVisible(true);
            EditAvaButton.setVisible(true);
        } else {
            CadUserButton.setVisible(false);
            ExcluirUserButton.setVisible(false);
            btnEdicaoDeLivro.setVisible(false);
            EditAvaButton.setVisible(false);
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
        DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();
        jtbAvaliacoes.setDefaultRenderer(Object.class, new TelaMinhasAvaliacoes.CenterRenderer());
        JTableHeader header = jtbAvaliacoes.getTableHeader();
        header.setDefaultRenderer(new TelaMinhasAvaliacoes.CenterRenderer());

        UsuarioLoginDAO usuarioLoginDao = new UsuarioLoginDAO();
        String idUsuarioString = usuarioLoginDao.idDoUsuarioLogado();
        int idUsuario = Integer.parseInt(idUsuarioString);

        // Para evitar que todos os dados sejam duplicados após um insert
        modelo.setNumRows(0);

        AvaliacaoDAO avdao = new AvaliacaoDAO();

        for (Avaliacao a : avdao.avaliacoesDoUsuario(idUsuario)) {
            modelo.addRow(new Object[]{
                a.getLivro().getId(),
                a.getLivro().getTitulo(),
                a.getAvaliacaoDoUsuario(),
                a.getComentarioAvaliacao()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLateral = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        CadUserButton = new javax.swing.JButton();
        edicaoUserButton = new javax.swing.JButton();
        CadLivroButton = new javax.swing.JButton();
        AvaButton = new javax.swing.JButton();
        ExcluirUserButton = new javax.swing.JToggleButton();
        btnEncerrarSessao = new javax.swing.JButton();
        btnEdicaoDeLivro = new javax.swing.JButton();
        EditAvaButton = new javax.swing.JButton();
        MinhasAvaButton1 = new javax.swing.JButton();
        txtMenu = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jlbCapaDoLivro = new javax.swing.JLabel();
        cboxNotaLivro = new javax.swing.JComboBox<>();
        tpnComentarioDoLivro = new javax.swing.JScrollPane();
        txtComentarioLivro = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtTituloLivro = new javax.swing.JTextField();
        tpnTabelaAvaliacoes = new javax.swing.JScrollPane();
        jtbAvaliacoes = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meu Perfil ");
        setPreferredSize(new java.awt.Dimension(1280, 720));

        menuLateral.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel2.setkGradientFocus(350);
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Menu");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        CadUserButton.setBackground(new java.awt.Color(102, 102, 102));
        CadUserButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CadUserButton.setForeground(new java.awt.Color(0, 0, 0));
        CadUserButton.setText("Cadastro de Usuario");
        CadUserButton.setToolTipText("cadastrar novos usuarios");
        CadUserButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CadUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CadUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadUserButtonActionPerformed(evt);
            }
        });

        edicaoUserButton.setBackground(new java.awt.Color(102, 102, 102));
        edicaoUserButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        edicaoUserButton.setForeground(new java.awt.Color(0, 0, 0));
        edicaoUserButton.setText("Edição de Usuario");
        edicaoUserButton.setToolTipText("edição de usuarios  cadastrados");
        edicaoUserButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        edicaoUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edicaoUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edicaoUserButtonActionPerformed(evt);
            }
        });

        CadLivroButton.setBackground(new java.awt.Color(102, 102, 102));
        CadLivroButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CadLivroButton.setForeground(new java.awt.Color(0, 0, 0));
        CadLivroButton.setText("Cadastro de Livro");
        CadLivroButton.setToolTipText("cadastrar novos livros");
        CadLivroButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CadLivroButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CadLivroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadLivroButtonActionPerformed(evt);
            }
        });

        AvaButton.setBackground(new java.awt.Color(102, 102, 102));
        AvaButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AvaButton.setForeground(new java.awt.Color(0, 0, 0));
        AvaButton.setText("Avaliação");
        AvaButton.setToolTipText("ir para avaliações de livros");
        AvaButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        AvaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvaButtonActionPerformed(evt);
            }
        });

        ExcluirUserButton.setBackground(new java.awt.Color(102, 102, 102));
        ExcluirUserButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ExcluirUserButton.setForeground(new java.awt.Color(0, 0, 0));
        ExcluirUserButton.setText("Excluir Usuarios");
        ExcluirUserButton.setToolTipText("excluir usuarios cadastrados");
        ExcluirUserButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ExcluirUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExcluirUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirUserButtonActionPerformed(evt);
            }
        });

        btnEncerrarSessao.setBackground(new java.awt.Color(102, 102, 102));
        btnEncerrarSessao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEncerrarSessao.setForeground(new java.awt.Color(0, 0, 0));
        btnEncerrarSessao.setText("Encerrar Sessão");
        btnEncerrarSessao.setToolTipText("encerrar sessão atual");
        btnEncerrarSessao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEncerrarSessao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEncerrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarSessaoActionPerformed(evt);
            }
        });

        btnEdicaoDeLivro.setBackground(new java.awt.Color(102, 102, 102));
        btnEdicaoDeLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEdicaoDeLivro.setForeground(new java.awt.Color(0, 0, 0));
        btnEdicaoDeLivro.setText("Edição de Livro");
        btnEdicaoDeLivro.setToolTipText("editar livros cadastrados");
        btnEdicaoDeLivro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEdicaoDeLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdicaoDeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdicaoDeLivroActionPerformed(evt);
            }
        });

        EditAvaButton.setBackground(new java.awt.Color(102, 102, 102));
        EditAvaButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        EditAvaButton.setForeground(new java.awt.Color(0, 0, 0));
        EditAvaButton.setText("Editar Avaliações");
        EditAvaButton.setToolTipText("editar avaliações dos usuarios");
        EditAvaButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        EditAvaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditAvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAvaButtonActionPerformed(evt);
            }
        });

        MinhasAvaButton1.setBackground(new java.awt.Color(102, 102, 102));
        MinhasAvaButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MinhasAvaButton1.setForeground(new java.awt.Color(0, 0, 0));
        MinhasAvaButton1.setText("Forum Livros");
        MinhasAvaButton1.setToolTipText("ir para forum de livros");
        MinhasAvaButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MinhasAvaButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MinhasAvaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinhasAvaButton1ActionPerformed(evt);
            }
        });

        txtMenu.setBackground(new java.awt.Color(102, 102, 102));
        txtMenu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtMenu.setForeground(new java.awt.Color(0, 0, 0));
        txtMenu.setText("Inicio");
        txtMenu.setToolTipText("Ir para o Inicio");
        txtMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMenuActionPerformed(evt);
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
                            .addComponent(edicaoUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExcluirUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdicaoDeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CadLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditAvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinhasAvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(txtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(CadUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(edicaoUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ExcluirUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(CadLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnEdicaoDeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(AvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(EditAvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(MinhasAvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jlbCapaDoLivro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Imagem:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jlbCapaDoLivro.setEnabled(false);

        cboxNotaLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxNotaLivro.setForeground(new java.awt.Color(0, 0, 0));
        cboxNotaLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada", "10 - Excelente", "9 - Ótimo", "8 - Muito Bom", "7 - Bom", "6 - Satisfatório", "5 - Regular", "4 - Abaixo da Média", "3 - Ruim", "2 - Muito Ruim", "1 - Péssimo", "0 - Inaceitável" }));
        cboxNotaLivro.setAutoscrolls(true);
        cboxNotaLivro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxNotaLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxNotaLivro.setEnabled(false);

        txtComentarioLivro.setColumns(20);
        txtComentarioLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtComentarioLivro.setForeground(new java.awt.Color(0, 0, 0));
        txtComentarioLivro.setLineWrap(true);
        txtComentarioLivro.setRows(5);
        txtComentarioLivro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Comentario:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13), new java.awt.Color(0, 0, 0))); // NOI18N
        txtComentarioLivro.setEnabled(false);
        tpnComentarioDoLivro.setViewportView(txtComentarioLivro);

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(0, 0, 0));
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("salvar as alterações");
        btnSalvar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(0, 0, 0));
        btnDeletar.setText("Deletar");
        btnDeletar.setToolTipText("deletar avaliação selecionada");
        btnDeletar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnSelecionar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSelecionar.setForeground(new java.awt.Color(0, 0, 0));
        btnSelecionar.setText("Selecionar");
        btnSelecionar.setToolTipText("selecione uma avaliação");
        btnSelecionar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSelecionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("limpar seleções");
        btnLimpar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtTituloLivro.setEditable(false);
        txtTituloLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTituloLivro.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloLivro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTituloLivro.setToolTipText("nome do livro selecionado");
        txtTituloLivro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtTituloLivro.setFocusable(false);
        txtTituloLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloLivroActionPerformed(evt);
            }
        });

        jtbAvaliacoes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtbAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID do Livro", "Títlulo", "Nota", "Comentário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbAvaliacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbAvaliacoesMouseClicked(evt);
            }
        });
        tpnTabelaAvaliacoes.setViewportView(jtbAvaliacoes);
        if (jtbAvaliacoes.getColumnModel().getColumnCount() > 0) {
            jtbAvaliacoes.getColumnModel().getColumn(0).setMinWidth(65);
            jtbAvaliacoes.getColumnModel().getColumn(0).setPreferredWidth(70);
            jtbAvaliacoes.getColumnModel().getColumn(0).setMaxWidth(75);
            jtbAvaliacoes.getColumnModel().getColumn(1).setMinWidth(345);
            jtbAvaliacoes.getColumnModel().getColumn(1).setPreferredWidth(350);
            jtbAvaliacoes.getColumnModel().getColumn(1).setMaxWidth(355);
            jtbAvaliacoes.getColumnModel().getColumn(2).setMinWidth(65);
            jtbAvaliacoes.getColumnModel().getColumn(2).setPreferredWidth(70);
            jtbAvaliacoes.getColumnModel().getColumn(2).setMaxWidth(75);
        }

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Título do Livro:");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Avaliação:");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxNotaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tpnComentarioDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addComponent(jlbCapaDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpnTabelaAvaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxNotaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tpnComentarioDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlbCapaDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(tpnTabelaAvaliacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout menuPrincipalLayout = new javax.swing.GroupLayout(menuPrincipal);
        menuPrincipal.setLayout(menuPrincipalLayout);
        menuPrincipalLayout.setHorizontalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        menuPrincipalLayout.setVerticalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1294, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbAvaliacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbAvaliacoesMouseClicked

    }//GEN-LAST:event_jtbAvaliacoesMouseClicked

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        ImagemDAO imagemDao = new ImagemDAO();

        int linha = jtbAvaliacoes.getSelectedRow();

        if (linha != -1) {

            cboxNotaLivro.setEnabled(true);
            txtComentarioLivro.setEnabled(true);
            jlbCapaDoLivro.setEnabled(true);

            DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();

            String idDoLivroString = modelo.getValueAt(linha, 0).toString();
            txtTituloLivro.setText(modelo.getValueAt(linha, 1).toString());
            String valorDaNota = modelo.getValueAt(linha, 2).toString();
            txtComentarioLivro.setText(modelo.getValueAt(linha, 3).toString());

            String notaTexto = null;

            switch (valorDaNota) {
                case "10.00" ->
                    notaTexto = "10 - Excelente";
                case "9.00" ->
                    notaTexto = "9 - Ótimo";
                case "8.00" ->
                    notaTexto = "8 - Muito Bom";
                case "7.00" ->
                    notaTexto = "7 - Bom";
                case "6.00" ->
                    notaTexto = "6 - Satisfatório";
                case "5.00" ->
                    notaTexto = "5 - Regular";
                case "4.00" ->
                    notaTexto = "4 - Abaixo da Média";
                case "3.00" ->
                    notaTexto = "3 - Ruim";
                case "2.00" ->
                    notaTexto = "2 - Muito Ruim";
                case "1.00" ->
                    notaTexto = "1 - Péssimo";
                case "0.00" ->
                    notaTexto = "0 - Inaceitável";
            }

            cboxNotaLivro.setSelectedItem(notaTexto);

            int idDoLivro = Integer.parseInt(idDoLivroString);
            byte[] iconeBytes = imagemDao.buscarImagemPorId(idDoLivro);

            if (iconeBytes != null && iconeBytes.length > 0) {
                // Converte o array de bytes em um ImageIcon
                ImageIcon icone = new ImageIcon(iconeBytes);

                // Define o ícone no JLabel
                jlbCapaDoLivro.setIcon(icone);
            } else {
                // Define o ícone como nulo caso o array de bytes seja vazio ou nulo
                jlbCapaDoLivro.setIcon(null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum item.");
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtTituloLivro.setText("");
        cboxNotaLivro.setSelectedItem("Não Informada");
        txtComentarioLivro.setText("");
        jlbCapaDoLivro.setIcon(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
        UsuarioLoginDAO usuarioLoginDao = new UsuarioLoginDAO();
        int linha = jtbAvaliacoes.getSelectedRow();

        String idUsuarioString = usuarioLoginDao.idDoUsuarioLogado();
        int idUsuario = Integer.parseInt(idUsuarioString);

        if (cboxNotaLivro.getSelectedItem().toString().equals("Não Informada")) {
            JOptionPane.showMessageDialog(null, "Use o botão selecionar.");
        } else if (linha != -1) {

            DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();

            String valorDaNotaString = modelo.getValueAt(linha, 2).toString();
            double valorDaNotaDouble = Double.parseDouble(valorDaNotaString);
            String comentario = txtComentarioLivro.getText();

            int confirmacao = JOptionPane.showConfirmDialog(
                    null,
                    "Tem certeza que deseja deletar esta avaliação?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION) {
                avaliacaoDao.deletarAvaliacao(idUsuario, valorDaNotaDouble, comentario);
                JOptionPane.showMessageDialog(null, "Avaliação deletada");
                selectTabelaLivro();
                txtTituloLivro.setText("");
                cboxNotaLivro.setSelectedItem("Não Informada");
                txtComentarioLivro.setText("");
                jlbCapaDoLivro.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário");
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
        UsuarioLoginDAO usuarioLoginDao = new UsuarioLoginDAO();

        int linha = jtbAvaliacoes.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();
        String valorIdLivro = modelo.getValueAt(linha, 0).toString();

        String idUsuarioString = usuarioLoginDao.idDoUsuarioLogado();
        int idUsuario = Integer.parseInt(idUsuarioString);

        String notaSelecionada = cboxNotaLivro.getSelectedItem().toString();
        String comentarioLivro = txtComentarioLivro.getText();
        String notaFormatada = null;

        if (notaSelecionada.equals("Não Informada")) {
            JOptionPane.showMessageDialog(null, "Você precisa informar a nota.");
        } else {
            switch (notaSelecionada) {
                case "10 - Excelente" ->
                    notaFormatada = "10";
                case "9 - Ótimo" ->
                    notaFormatada = "9";
                case "8 - Muito Bom" ->
                    notaFormatada = "8";
                case "7 - Bom" ->
                    notaFormatada = "7";
                case "6 - Satisfatório" ->
                    notaFormatada = "6";
                case "5 - Regular" ->
                    notaFormatada = "5";
                case "4 - Abaixo da Média" ->
                    notaFormatada = "4";
                case "3 - Ruim" ->
                    notaFormatada = "3";
                case "2 - Muito Ruim" ->
                    notaFormatada = "2";
                case "1 - Péssimo" ->
                    notaFormatada = "1";
                case "0 - Inaceitável" ->
                    notaFormatada = "0";
            }

            int confirmacao = JOptionPane.showConfirmDialog(
                    null,
                    "Tem certeza que deseja atualizar esta avaliação?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION) {
                avaliacaoDao.atualizarAvaliacao(idUsuario, notaFormatada, comentarioLivro, valorIdLivro);
                JOptionPane.showMessageDialog(null, "Avaliação atualizada com sucesso!");
                selectTabelaLivro();
                txtTituloLivro.setText("");
                cboxNotaLivro.setSelectedItem("Não Informada");
                txtComentarioLivro.setText("");
                jlbCapaDoLivro.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void CadUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadUserButtonActionPerformed
        new CadastroUsuario().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadUserButtonActionPerformed

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

    private void CadLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadLivroButtonActionPerformed
        new CadastroDeLivros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadLivroButtonActionPerformed

    private void AvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvaButtonActionPerformed
        Avaliacao avaliacao = new Avaliacao();
        new TelaAvaliacao(avaliacao).setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_AvaButtonActionPerformed

    private void ExcluirUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirUserButtonActionPerformed

        ExcluirUserDAO ex = new ExcluirUserDAO();
        ex.mostrarEExcluirUsuario();
    }//GEN-LAST:event_ExcluirUserButtonActionPerformed

    private void btnEncerrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarSessaoActionPerformed
        // TODO add your handling code here:
        new TelaDeLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEncerrarSessaoActionPerformed

    private void btnEdicaoDeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdicaoDeLivroActionPerformed
        new EdicaoDeLivro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEdicaoDeLivroActionPerformed

    private void EditAvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAvaButtonActionPerformed
        new EdicaoAvaliacoes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EditAvaButtonActionPerformed

    private void MinhasAvaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinhasAvaButton1ActionPerformed
        new ForumLivros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MinhasAvaButton1ActionPerformed

    private void txtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMenuActionPerformed
        UsuarioLoginDAO usuarioLoginDao = new UsuarioLoginDAO();

        if (usuarioLoginDao.tipoDoUsuarioLogado()) {
            new TelaPrincipalAdministrador().setVisible(true);
            this.dispose();
        } else {
            new TelaPrincipalCliente().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_txtMenuActionPerformed

    private void txtTituloLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloLivroActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMinhasAvaliacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AvaButton;
    private javax.swing.JButton CadLivroButton;
    private javax.swing.JButton CadUserButton;
    private javax.swing.JButton EditAvaButton;
    private javax.swing.JToggleButton ExcluirUserButton;
    private javax.swing.JButton MinhasAvaButton1;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEdicaoDeLivro;
    private javax.swing.JButton btnEncerrarSessao;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cboxNotaLivro;
    private javax.swing.JButton edicaoUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jlbCapaDoLivro;
    private javax.swing.JTable jtbAvaliacoes;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JPanel menuPrincipal;
    private javax.swing.JScrollPane tpnComentarioDoLivro;
    private javax.swing.JScrollPane tpnTabelaAvaliacoes;
    private javax.swing.JTextArea txtComentarioLivro;
    private javax.swing.JButton txtMenu;
    private javax.swing.JTextField txtTituloLivro;
    // End of variables declaration//GEN-END:variables
}
