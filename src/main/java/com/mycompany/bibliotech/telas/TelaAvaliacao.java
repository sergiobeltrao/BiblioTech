package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.dao.TelaAvaliacaoDAO;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.ApplicationContext;
import com.mycompany.bibliotech.model.bean.Login;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaAvaliacao extends javax.swing.JFrame {

    public TelaAvaliacao(Avaliacao avaliacao) {
        initComponents();
        setPesquisarValues(avaliacao);

        cboxNomeLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String pesquisar = cboxNomeLivro.getSelectedItem().toString();
                    if (pesquisar != null && !pesquisar.isEmpty()) {
                        TelaAvaliacaoDAO taDAO = new TelaAvaliacaoDAO();
                        Avaliacao pes = taDAO.find(pesquisar);
                        setPesquisarValues(pes);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar o livro." + ex);
                }
            }
        }
        );

        cboxAlfabeto.setForeground(new java.awt.Color(0, 0, 0));
        cboxAlfabeto.addItem("");
        cboxAlfabeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Alfabeto", "A", "B", "C",
            "D", "E", "F", "J", "F", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
        cboxNomeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNomeLivroeActionPerformed(evt);
            }
        });

        listarCategorias();
        String caminhoImagem = "C:\\Users\\jonat\\OneDrive\\Área de Trabalho\\Trabalho Extra\\A3\\BiblioTech\\src\\main\\resources\\imagem\\DomCasmurro.jpeg"; 
        ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
        imagemLivro.setIcon(imagemIcon);

    }

    private void setPesquisarValues(Avaliacao avaliacao) {
        if (avaliacao != null) {
            txtAno.setText(String.valueOf(avaliacao.getTxtAno()));
            txtEditora.setText(avaliacao.getTxtEditora());
            txtIdioma.setText(avaliacao.getTxtIdioma());
            txtIsbn.setText(avaliacao.getTxtIsbn());
            txtNomeAutor.setText(avaliacao.getTxtNomeAutor());
            txtPaginas.setText(String.valueOf(avaliacao.getTxtPaginas()));
            txtNotaMax.setText(avaliacao.getTxtNotaMax());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        cboxNomeLivro = new javax.swing.JComboBox<>();
        cboxAlfabeto = new javax.swing.JComboBox<>();
        cboxCategoriaBusca = new javax.swing.JComboBox<>();
        cboxSubCategoriaBusca = new javax.swing.JComboBox<>();
        txtTituloBusca = new javax.swing.JTextField();
        txtNomeAutor = new javax.swing.JTextField();
        txtEditora = new javax.swing.JTextField();
        txtPaginas = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        txtIdioma = new javax.swing.JTextField();
        txtNotaMax = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAvaliar = new javax.swing.JButton();
        SliderNota = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        imagemLivro = new javax.swing.JLabel();
        txtNota = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        MenuLateral = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        AvaButton1 = new javax.swing.JButton();
        btnEncerrarSessao = new javax.swing.JButton();
        CadLivroButton = new javax.swing.JButton();
        txtVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Avaliacao");

        kGradientPanel1.setkEndColor(new java.awt.Color(19, 18, 18));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        cboxNomeLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxNomeLivro.setForeground(new java.awt.Color(0, 0, 0));
        cboxNomeLivro.setToolTipText("Lista de livro escolhido");
        cboxNomeLivro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxNomeLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxNomeLivro.setEnabled(false);
        cboxNomeLivro.setFocusable(false);
        cboxNomeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNomeLivroeActionPerformed(evt);
            }
        });

        cboxAlfabeto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxAlfabeto.setForeground(new java.awt.Color(0, 0, 0));
        cboxAlfabeto.setToolTipText("Escolha uma letra");
        cboxAlfabeto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxAlfabeto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxAlfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAlfabetoActionPerformed(evt);
            }
        });

        cboxCategoriaBusca.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxCategoriaBusca.setForeground(new java.awt.Color(0, 0, 0));
        cboxCategoriaBusca.setToolTipText("Selecione a Categoria do Livro");
        cboxCategoriaBusca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxCategoriaBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxCategoriaBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaBuscaActionPerformed(evt);
            }
        });

        cboxSubCategoriaBusca.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSubCategoriaBusca.setForeground(new java.awt.Color(0, 0, 0));
        cboxSubCategoriaBusca.setToolTipText("Escolha uma Subcategoria");
        cboxSubCategoriaBusca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cboxSubCategoriaBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtTituloBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTituloBusca.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloBusca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTituloBusca.setToolTipText("Escreva o nome do Livro");
        txtTituloBusca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtTituloBusca.setCaretColor(new java.awt.Color(0, 0, 0));
        txtTituloBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtTituloBusca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTituloBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloBuscaActionPerformed(evt);
            }
        });

        txtNomeAutor.setEditable(false);
        txtNomeAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeAutor.setForeground(new java.awt.Color(0, 0, 0));
        txtNomeAutor.setToolTipText("Nome do autor ");
        txtNomeAutor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtNomeAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtNomeAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAutorActionPerformed(evt);
            }
        });

        txtEditora.setEditable(false);
        txtEditora.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtEditora.setForeground(new java.awt.Color(0, 0, 0));
        txtEditora.setToolTipText("Nome da editora do livro");
        txtEditora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtEditora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPaginas.setEditable(false);
        txtPaginas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPaginas.setForeground(new java.awt.Color(0, 0, 0));
        txtPaginas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPaginas.setToolTipText("Numero de paginas do livro");
        txtPaginas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPaginas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaginasActionPerformed(evt);
            }
        });

        txtAno.setEditable(false);
        txtAno.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAno.setForeground(new java.awt.Color(0, 0, 0));
        txtAno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAno.setToolTipText("Ano de publicação do livro");
        txtAno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtIsbn.setEditable(false);
        txtIsbn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtIsbn.setForeground(new java.awt.Color(0, 0, 0));
        txtIsbn.setToolTipText("Numero de indentificação do livro");
        txtIsbn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtIdioma.setEditable(false);
        txtIdioma.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtIdioma.setForeground(new java.awt.Color(0, 0, 0));
        txtIdioma.setToolTipText("Idioma do livro");
        txtIdioma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtNotaMax.setEditable(false);
        txtNotaMax.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNotaMax.setForeground(new java.awt.Color(0, 0, 0));
        txtNotaMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNotaMax.setToolTipText("Esta é a nota maxima do livro escolhido");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar livro escolhido");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAvaliar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnAvaliar.setForeground(new java.awt.Color(0, 0, 0));
        btnAvaliar.setText("Avaliar");
        btnAvaliar.setToolTipText("inserir nota do livro escolhido");
        btnAvaliar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAvaliar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliarActionPerformed(evt);
            }
        });

        SliderNota.setBackground(new java.awt.Color(27, 25, 25));
        SliderNota.setForeground(new java.awt.Color(0, 0, 0));
        SliderNota.setMaximum(10);
        SliderNota.setPaintLabels(true);
        SliderNota.setPaintTicks(true);
        SliderNota.setToolTipText("Insira a sua nota para o livro escolhido");
        SliderNota.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        SliderNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SliderNota.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderNotaStateChanged(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comentario:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        imagemLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        imagemLivro.setToolTipText("Imagem do livro escolhido");
        imagemLivro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtNota.setBackground(new java.awt.Color(0, 0, 0));
        txtNota.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtNota.setForeground(new java.awt.Color(255, 255, 255));
        txtNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNota.setToolTipText("");
        txtNota.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome do livro:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Busca Letra:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Categoria: ");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Sub-Categoria: ");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Autor:");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Editora:");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Paginas:");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ano:");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ISBN:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Idioma:");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Buscar Nome do Livro:");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTituloBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboxCategoriaBusca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboxSubCategoriaBusca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addComponent(cboxAlfabeto, javax.swing.GroupLayout.Alignment.TRAILING, 0, 93, Short.MAX_VALUE))))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(txtNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboxNomeLivro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(305, 305, 305))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(36, 36, 36)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(SliderNota, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imagemLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(txtNotaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel12))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(imagemLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNotaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SliderNota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(txtTituloBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxCategoriaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxSubCategoriaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(7, 7, 7)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        txtTituloBusca.getAccessibleContext().setAccessibleName("");

        MenuLateral.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkGradientFocus(350);
        kGradientPanel2.setkStartColor(new java.awt.Color(114, 114, 133));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Menu");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        AvaButton1.setBackground(new java.awt.Color(102, 102, 102));
        AvaButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AvaButton1.setForeground(new java.awt.Color(0, 0, 0));
        AvaButton1.setText("Avaliação");
        AvaButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        AvaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvaButton1ActionPerformed(evt);
            }
        });

        btnEncerrarSessao.setBackground(new java.awt.Color(102, 102, 102));
        btnEncerrarSessao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEncerrarSessao.setForeground(new java.awt.Color(0, 0, 0));
        btnEncerrarSessao.setText("Encerrar Sessão");
        btnEncerrarSessao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEncerrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarSessaoActionPerformed(evt);
            }
        });

        CadLivroButton.setBackground(new java.awt.Color(102, 102, 102));
        CadLivroButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CadLivroButton.setForeground(new java.awt.Color(0, 0, 0));
        CadLivroButton.setText("Cadastro de Livros");
        CadLivroButton.setToolTipText("Cadastrar livros não escontrado");
        CadLivroButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CadLivroButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CadLivroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadLivroButtonActionPerformed(evt);
            }
        });

        txtVoltar.setBackground(new java.awt.Color(102, 102, 102));
        txtVoltar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtVoltar.setForeground(new java.awt.Color(0, 0, 0));
        txtVoltar.setText("Inicio");
        txtVoltar.setToolTipText("Ir para o Menui inicial");
        txtVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AvaButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(CadLivroButton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel11)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(CadLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
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
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(MenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1294, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        cboxNomeLivro.setEnabled(true);

        cboxNomeLivro.setMaximumRowCount(5);
        cboxNomeLivro.showPopup();

        String busca = txtTituloBusca.getText();
        String buscaCategorias = cboxCategoriaBusca.getSelectedItem().toString();
        String buscaSubCategorias = cboxSubCategoriaBusca.getSelectedItem().toString();
        String buscaAlfabeto = cboxAlfabeto.getSelectedItem().toString();

        if (!busca.isEmpty() && buscaAlfabeto.isEmpty()) {
            // Busca simples por uma parte do nome
            TelaAvaliacaoDAO.listaFiltrada(cboxNomeLivro, busca);
        } else if (buscaAlfabeto.isEmpty() && !buscaCategorias.isEmpty()) {
            // Busca por categorias
            TelaAvaliacaoDAO.buscaCategorias(cboxNomeLivro, buscaCategorias);
        } else if (buscaAlfabeto.isEmpty() && !buscaSubCategorias.isEmpty()) {
            // Busca por subcategorias
            TelaAvaliacaoDAO.buscaSubCategorias(cboxNomeLivro, buscaSubCategorias);
        } else if (!buscaAlfabeto.isEmpty() && busca.isEmpty()) {
            // Busca em ordem alfabética
            TelaAvaliacaoDAO.listaAlfabeto(cboxNomeLivro, buscaAlfabeto);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha apenas um dos campos!");
            cboxNomeLivro.removeAllItems();
        }

        cboxAlfabeto.setSelectedIndex(0);
        txtTituloBusca.setText("");

    }//GEN-LAST:event_btnBuscarActionPerformed
    private void txtNomeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeLivroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNomeLivroActionPerformed

    private void cboxAlfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAlfabetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxAlfabetoActionPerformed

    private void cboxNomeLivroeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxNomeLivroeActionPerformed


    }//GEN-LAST:event_cboxNomeLivroeActionPerformed

    public void listarCategorias() {
        LivroCategoriaDAO.listarCategorias(cboxCategoriaBusca);
    }

    public void listarSubCategoria(String idCategoria) {
        LivroCategoriaDAO.listarSubCategoria(cboxSubCategoriaBusca, idCategoria);
    }

    private void cboxCategoriaBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaBuscaActionPerformed
        String dados[] = String.valueOf(cboxCategoriaBusca.getSelectedItem()).split(" - ");

        if (!dados[0].equalsIgnoreCase(" ")) {
            cboxSubCategoriaBusca.removeAllItems();
            cboxSubCategoriaBusca.addItem(" ");
            listarSubCategoria(dados[0]);

        } else {
            cboxSubCategoriaBusca.removeAllItems();
            cboxSubCategoriaBusca.addItem(" ");
    }//GEN-LAST:event_cboxCategoriaBuscaActionPerformed
    }

    private void SliderNotaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderNotaStateChanged

        txtNota.setText(String.valueOf(SliderNota.getValue()));

    }//GEN-LAST:event_SliderNotaStateChanged

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
        String pesquisar = cboxNomeLivro.getSelectedItem().toString();
        Login login = ApplicationContext.getLogin();
        Avaliacao pes = new Avaliacao();
        AvaliacaoDAO notaDAO = new AvaliacaoDAO();
        String nota = txtNota.getText();
        notaDAO.rank(pes, pesquisar, login.getNick(), nota);
    }//GEN-LAST:event_btnAvaliarActionPerformed

    private void txtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVoltarActionPerformed
        new TelaPrincipalCliente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtVoltarActionPerformed

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

    private void CadLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadLivroButtonActionPerformed
        new CadastroDeLivros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadLivroButtonActionPerformed

    private void txtTituloBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloBuscaActionPerformed

    private void txtPaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaginasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaginasActionPerformed

    private void txtNomeAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAutorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAvaliacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Avaliacao avaliacao = new Avaliacao();
                new TelaAvaliacao(avaliacao).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AvaButton1;
    private javax.swing.JButton CadLivroButton;
    private javax.swing.JPanel MenuLateral;
    private javax.swing.JSlider SliderNota;
    private javax.swing.JButton btnAvaliar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEncerrarSessao;
    private javax.swing.JComboBox<String> cboxAlfabeto;
    private javax.swing.JComboBox<String> cboxCategoriaBusca;
    private javax.swing.JComboBox<String> cboxNomeLivro;
    private javax.swing.JComboBox<String> cboxSubCategoriaBusca;
    private javax.swing.JLabel imagemLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtNomeAutor;
    private javax.swing.JLabel txtNota;
    private javax.swing.JTextField txtNotaMax;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtTituloBusca;
    private javax.swing.JButton txtVoltar;
    // End of variables declaration//GEN-END:variables
}
