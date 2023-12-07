package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.EnderecoDAO;
import com.mycompany.bibliotech.dao.ExcluirUserDAO;
import com.mycompany.bibliotech.dao.FavoritosDAO;
import com.mycompany.bibliotech.dao.HomeAdmDAO;
import com.mycompany.bibliotech.dao.RankDAO;
import com.mycompany.bibliotech.dao.TelefoneDAO;
import com.mycompany.bibliotech.dao.UsuarioCadastroDAO;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.ContagemAvaliacoesLivro;
import com.mycompany.bibliotech.model.bean.Endereco;
import com.mycompany.bibliotech.model.bean.Favoritos;
import com.mycompany.bibliotech.model.bean.Hash;
import com.mycompany.bibliotech.model.bean.Telefone;
import com.mycompany.bibliotech.model.bean.Usuario;
import com.mycompany.bibliotech.model.bean.UsuariosAvaliando;
import java.awt.Component;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class TelaPrincipalAdministrador extends javax.swing.JFrame {

    public TelaPrincipalAdministrador() {
        initComponents();
        List<String> rankList = HomeAdmDAO.data();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        List<UsuariosAvaliando> contagensList = HomeAdmDAO.numeroDeNotasPorUser();
        DefaultListModel<String> listContagens = new DefaultListModel<>();

        if (rankList != null) {
            int rankNumber = 1;
            for (String item : rankList) {
                listModel.addElement(rankNumber + ". " + item);
                rankNumber++;
            }
        }

        jList1.setCellRenderer(new TelaPrincipalAdministrador.CenteredTextRenderer());
        jList1.setModel(listModel);

        List<String> recordList = HomeAdmDAO.record();
        DefaultListModel<String> listRecord = new DefaultListModel<>();

        if (recordList != null) {
            int recordNumber = 1;
            for (String item : recordList) {
                listRecord.addElement(recordNumber + ". " + item);
                recordNumber++;
            }
        }

        if (contagensList != null) {
            int rankNumber = 1;
            for (UsuariosAvaliando item : contagensList) {
                listContagens.addElement(rankNumber + ". " + item.getNomeUsuario() + ": " + item.getQuantidadeAvaliacoes() + " avaliações");
                rankNumber++;
            }
        }

        listaComMaisAvaliacao.setCellRenderer(new TelaPrincipalAdministrador.CenteredTextRenderer());
        listaComMaisAvaliacao.setModel(listContagens);

        jList2.setCellRenderer(new TelaPrincipalAdministrador.CenteredTextRenderer());
        jList2.setModel(listRecord);
    }

    public class CenteredTextRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Configura o alinhamento do texto para o centro
            setHorizontalAlignment(DefaultListCellRenderer.CENTER);

            return this;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPainel = new javax.swing.JPanel();
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
        MinhasAvaButton = new javax.swing.JButton();
        MinhasAvaButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        rank = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        avaliado = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        numeroAvaliado = new javax.swing.JScrollPane();
        listaComMaisAvaliacao = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        MenuPainel.setBackground(new java.awt.Color(255, 255, 255));

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
        edicaoUserButton.setToolTipText("editar usuarios cadastrados");
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
        ExcluirUserButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        btnEncerrarSessao.setToolTipText("encerrar a sessaão atual");
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
        EditAvaButton.setToolTipText("editar avaliações de usuarios");
        EditAvaButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        EditAvaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditAvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAvaButtonActionPerformed(evt);
            }
        });

        MinhasAvaButton.setBackground(new java.awt.Color(102, 102, 102));
        MinhasAvaButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MinhasAvaButton.setForeground(new java.awt.Color(0, 0, 0));
        MinhasAvaButton.setText("Minhas Avaliações");
        MinhasAvaButton.setToolTipText("ir para minhas avaliações de livros");
        MinhasAvaButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MinhasAvaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MinhasAvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinhasAvaButtonActionPerformed(evt);
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
                            .addComponent(MinhasAvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinhasAvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(edicaoUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExcluirUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdicaoDeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditAvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MinhasAvaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MinhasAvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout MenuPainelLayout = new javax.swing.GroupLayout(MenuPainel);
        MenuPainel.setLayout(MenuPainelLayout);
        MenuPainelLayout.setHorizontalGroup(
            MenuPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(MenuPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MenuPainelLayout.createSequentialGroup()
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        MenuPainelLayout.setVerticalGroup(
            MenuPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(MenuPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        jList1.setBackground(new java.awt.Color(204, 204, 204));
        jList1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList1.setToolTipText("");
        rank.setViewportView(jList1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ultimas interações ");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jList2.setBackground(new java.awt.Color(204, 204, 204));
        jList2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        avaliado.setViewportView(jList2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Novos usuarios");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        listaComMaisAvaliacao.setBackground(new java.awt.Color(204, 204, 204));
        listaComMaisAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listaComMaisAvaliacao.setToolTipText("");
        numeroAvaliado.setViewportView(listaComMaisAvaliacao);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Usuarios mais ativos");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rank, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(avaliado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numeroAvaliado, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(avaliado, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addComponent(rank)
                    .addComponent(numeroAvaliado))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1294, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncerrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarSessaoActionPerformed
        // TODO add your handling code here:
        new TelaDeLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEncerrarSessaoActionPerformed

    private void CadLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadLivroButtonActionPerformed
        new CadastroDeLivros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadLivroButtonActionPerformed

    private void CadUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadUserButtonActionPerformed
        new CadastroUsuario().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadUserButtonActionPerformed

    private void ExcluirUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirUserButtonActionPerformed

        ExcluirUserDAO ex = new ExcluirUserDAO();
        ex.mostrarEExcluirUsuario();
    }//GEN-LAST:event_ExcluirUserButtonActionPerformed

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

    private void AvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvaButtonActionPerformed
        Avaliacao avaliacao = new Avaliacao();
        new TelaAvaliacao(avaliacao).setVisible(true);
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_AvaButtonActionPerformed

    private void btnEdicaoDeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdicaoDeLivroActionPerformed
        new EdicaoDeLivro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEdicaoDeLivroActionPerformed

    private void EditAvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAvaButtonActionPerformed
        new EdicaoAvaliacoes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EditAvaButtonActionPerformed

    private void MinhasAvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinhasAvaButtonActionPerformed
        new TelaMinhasAvaliacoes().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MinhasAvaButtonActionPerformed

    private void MinhasAvaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinhasAvaButton1ActionPerformed
        new ForumLivros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MinhasAvaButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AvaButton;
    private javax.swing.JButton CadLivroButton;
    private javax.swing.JButton CadUserButton;
    private javax.swing.JButton EditAvaButton;
    private javax.swing.JToggleButton ExcluirUserButton;
    private javax.swing.JPanel MenuPainel;
    private javax.swing.JButton MinhasAvaButton;
    private javax.swing.JButton MinhasAvaButton1;
    private javax.swing.JScrollPane avaliado;
    private javax.swing.JButton btnEdicaoDeLivro;
    private javax.swing.JButton btnEncerrarSessao;
    private javax.swing.JButton edicaoUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JList<String> listaComMaisAvaliacao;
    private javax.swing.JScrollPane numeroAvaliado;
    private javax.swing.JScrollPane rank;
    // End of variables declaration//GEN-END:variables
}
