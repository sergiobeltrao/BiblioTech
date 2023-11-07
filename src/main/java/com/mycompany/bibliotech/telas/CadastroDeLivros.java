package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.dao.AutorDAO;
import com.mycompany.bibliotech.dao.AvaliacaoDAO;

import com.mycompany.bibliotech.dao.LivroDAO;
import com.mycompany.bibliotech.model.bean.Autor;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.Livro;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CadastroDeLivros extends javax.swing.JFrame {

    public CadastroDeLivros() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbSelect.getModel();
        tbSelect.setRowSorter(new TableRowSorter(modelo));
        listarCategorias();
        listarNacionalidades();
        listarIdiomasDoLivro();
        readJTable();
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) tbSelect.getModel();

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
                l.getQuantidadeLivro(),
                l.getPreco(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSelect = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSelect = new javax.swing.JTable();
        janelaDeAbas = new javax.swing.JTabbedPane();
        cadLivros = new javax.swing.JPanel();
        boxComentarioAvaliacao = new javax.swing.JScrollPane();
        txtComentarioAvaliacao = new javax.swing.JTextArea();
        txtISBN = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtDeBoasVindasLivro = new javax.swing.JTextField();
        txtNumeroDePaginas = new javax.swing.JTextField();
        txtAnoDePublicacao = new javax.swing.JTextField();
        cboxCategoria = new javax.swing.JComboBox<>();
        cboxSubCategoria = new javax.swing.JComboBox<>();
        txtQuantidade = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        cboxAvaliacaoDoLivro = new javax.swing.JComboBox<>();
        txtNomeDaEditora = new javax.swing.JTextField();
        cboxLivroIdioma = new javax.swing.JComboBox<>();
        btnTelaPrinCadLivro = new javax.swing.JButton();
        btnLimparLivro = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnProximaTela = new javax.swing.JButton();
        cadAutor = new javax.swing.JPanel();
        boxBibliografiaAutor = new javax.swing.JScrollPane();
        txtAutorBibliografia = new javax.swing.JTextArea();
        cboxNacionalidadeDoAutor = new javax.swing.JComboBox<>();
        calendarNasciAutor = new com.toedter.calendar.JDateChooser();
        cboxAutorSexo = new javax.swing.JComboBox<>();
        txtNomeDoAutor = new javax.swing.JTextField();
        txtDeBoasVindasAutor = new javax.swing.JTextField();
        btnFinalizarCadastro = new javax.swing.JButton();
        btnLimparAutor = new javax.swing.JButton();
        btnTelaPrinCadAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnSelect.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbSelect.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tbSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "ISBN", "Ano", "Nº de Páginas", "Quantidade", "Categoria", "Preço", "Autor", "Editora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSelect);

        javax.swing.GroupLayout pnSelectLayout = new javax.swing.GroupLayout(pnSelect);
        pnSelect.setLayout(pnSelectLayout);
        pnSelectLayout.setHorizontalGroup(
            pnSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnSelectLayout.setVerticalGroup(
            pnSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );

        janelaDeAbas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        cadLivros.setBackground(new java.awt.Color(255, 255, 255));

        boxComentarioAvaliacao.setBorder(null);

        txtComentarioAvaliacao.setColumns(20);
        txtComentarioAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtComentarioAvaliacao.setLineWrap(true);
        txtComentarioAvaliacao.setRows(5);
        txtComentarioAvaliacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comentário da Avaliação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        boxComentarioAvaliacao.setViewportView(txtComentarioAvaliacao);

        txtISBN.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtISBN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ISBN *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Título *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

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

        txtNumeroDePaginas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNumeroDePaginas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de Páginas *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtAnoDePublicacao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAnoDePublicacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ano de Publicação *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

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

        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtQuantidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPreco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        cboxAvaliacaoDoLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxAvaliacaoDoLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada", "10 - Extraordinário", "9 - Incrível", "8 - Excelente", "7 - Muito Bom", "6 - Bom", "5 - Regular", "4 - Mediano", "3 - Insatisfatório", "2 - Ruim", "1 - Péssimo" }));
        cboxAvaliacaoDoLivro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avaliação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxAvaliacaoDoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAvaliacaoDoLivroActionPerformed(evt);
            }
        });

        txtNomeDaEditora.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeDaEditora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome da Editora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        cboxLivroIdioma.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxLivroIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informado" }));
        cboxLivroIdioma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Idioma *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

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

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEditar.setText("Editar");

        btnDeletar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnDeletar.setText("Deletar");

        btnProximaTela.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnProximaTela.setText("Próxima Tela");
        btnProximaTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaTelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadLivrosLayout = new javax.swing.GroupLayout(cadLivros);
        cadLivros.setLayout(cadLivrosLayout);
        cadLivrosLayout.setHorizontalGroup(
            cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadLivrosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDeBoasVindasLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cadLivrosLayout.createSequentialGroup()
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadLivrosLayout.createSequentialGroup()
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cadLivrosLayout.createSequentialGroup()
                                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cadLivrosLayout.createSequentialGroup()
                                        .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cadLivrosLayout.createSequentialGroup()
                                            .addComponent(btnTelaPrinCadLivro)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnLimparLivro))
                                        .addGroup(cadLivrosLayout.createSequentialGroup()
                                            .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cboxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadLivrosLayout.createSequentialGroup()
                                .addComponent(btnProximaTela)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletar))
                            .addComponent(boxComentarioAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        cadLivrosLayout.setVerticalGroup(
            cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadLivrosLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(txtDeBoasVindasLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadLivrosLayout.createSequentialGroup()
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(boxComentarioAvaliacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnEditar)
                    .addComponent(btnLimparLivro)
                    .addComponent(btnTelaPrinCadLivro)
                    .addComponent(btnProximaTela))
                .addGap(21, 21, 21))
        );

        janelaDeAbas.addTab("Cadastrar Livro", cadLivros);

        cadAutor.setBackground(new java.awt.Color(255, 255, 255));

        boxBibliografiaAutor.setBorder(null);

        txtAutorBibliografia.setColumns(20);
        txtAutorBibliografia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAutorBibliografia.setLineWrap(true);
        txtAutorBibliografia.setRows(5);
        txtAutorBibliografia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bibliografia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        boxBibliografiaAutor.setViewportView(txtAutorBibliografia);

        cboxNacionalidadeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxNacionalidadeDoAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxNacionalidadeDoAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nacionalidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxNacionalidadeDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNacionalidadeDoAutorActionPerformed(evt);
            }
        });

        calendarNasciAutor.setBackground(new java.awt.Color(255, 255, 255));
        calendarNasciAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Nascimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        calendarNasciAutor.setToolTipText("20-12-2000");
        calendarNasciAutor.setDateFormatString("dd/MM/yyyy");
        calendarNasciAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        calendarNasciAutor.setMaxSelectableDate(new java.util.Date(253370779274000L));
        calendarNasciAutor.setMinSelectableDate(new java.util.Date(-62135755126000L));

        cboxAutorSexo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxAutorSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informado", "Masculino", "Feminino" }));
        cboxAutorSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxAutorSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAutorSexoActionPerformed(evt);
            }
        });

        txtNomeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeDoAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        txtDeBoasVindasAutor.setEditable(false);
        txtDeBoasVindasAutor.setBackground(new java.awt.Color(255, 255, 255));
        txtDeBoasVindasAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDeBoasVindasAutor.setText("Bem-vindo ao formulário de cadastro do autor. Os campo com asterisco são de preenchimento obrigatório.");
        txtDeBoasVindasAutor.setBorder(null);
        txtDeBoasVindasAutor.setFocusable(false);

        btnFinalizarCadastro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnFinalizarCadastro.setText("Finalizar Cadastro");
        btnFinalizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCadastroActionPerformed(evt);
            }
        });

        btnLimparAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimparAutor.setText("Limpar");
        btnLimparAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparAutorActionPerformed(evt);
            }
        });

        btnTelaPrinCadAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnTelaPrinCadAutor.setText("Tela Principal");
        btnTelaPrinCadAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaPrinCadAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadAutorLayout = new javax.swing.GroupLayout(cadAutor);
        cadAutor.setLayout(cadAutorLayout);
        cadAutorLayout.setHorizontalGroup(
            cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadAutorLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(cadAutorLayout.createSequentialGroup()
                        .addComponent(btnTelaPrinCadAutor)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizarCadastro))
                    .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadAutorLayout.createSequentialGroup()
                            .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNomeDoAutor)
                                .addComponent(cboxAutorSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(calendarNasciAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxNacionalidadeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(boxBibliografiaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDeBoasVindasAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        cadAutorLayout.setVerticalGroup(
            cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadAutorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtDeBoasVindasAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cadAutorLayout.createSequentialGroup()
                        .addComponent(txtNomeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxAutorSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendarNasciAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxNacionalidadeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boxBibliografiaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarCadastro)
                    .addComponent(btnLimparAutor)
                    .addComponent(btnTelaPrinCadAutor))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        janelaDeAbas.addTab("Cadastrar Autor", cadAutor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(janelaDeAbas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(janelaDeAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCadastroActionPerformed

        Livro lv = new Livro();
        Autor aut = new Autor();
        Avaliacao av = new Avaliacao();

        LivroDAO lvdao = new LivroDAO();
        AutorDAO autdao = new AutorDAO();
        AvaliacaoDAO avdao = new AvaliacaoDAO();

        // Livro
        lv.setTitulo(txtTitulo.getText());
        lv.setIsbn(txtISBN.getText());
        lv.setAnoDePublicacao(Integer.parseInt(txtAnoDePublicacao.getText()));
        lv.setNumeroDePaginas(Integer.parseInt(txtNumeroDePaginas.getText()));
        lv.setQuantidadeLivro(Integer.parseInt(txtQuantidade.getText()));
        lv.setPreco(Double.parseDouble(txtPreco.getText()));
        String idiomaSelecionado = cboxLivroIdioma.getSelectedItem().toString();
        lv.setIdioma(idiomaSelecionado);
        lv.setEditora(txtNomeDaEditora.getText());

        // Autor
        aut.setNome(txtNomeDoAutor.getText());
        aut.setDataDeNascimento(calendarNasciAutor.getDate());
        aut.setBibliografia(txtAutorBibliografia.getText());
        String comboBoxNacionalidadeAutor = cboxNacionalidadeDoAutor.getSelectedItem().toString();
        aut.setNacionalidade(comboBoxNacionalidadeAutor);

        // Opções de sexo do autor
        String valorAutorSexo = cboxAutorSexo.getSelectedItem().toString();
        String valorSelecionado = "OUTRO"; // Padrão

        if (valorAutorSexo.equals("Masculino")) {
            valorSelecionado = "MASC";
        } else if (valorAutorSexo.equals("Feminino")) {
            valorSelecionado = "FEM";
        }

        aut.setSexo(valorSelecionado);

        

        // Pegando os dados das ComboBox de categoria de livro
        String categoriaSelecionada = cboxCategoria.getSelectedItem().toString();
        String subCategoriaSelecionada = cboxSubCategoria.getSelectedItem().toString();
        lv.setCategoria(categoriaSelecionada);
        lv.setSubCategoria(subCategoriaSelecionada);

        // Avaliação do livro
        String notaInseridaPeloUsuario = cboxAvaliacaoDoLivro.getSelectedItem().toString().substring(0, 2);
        av.setAvaliacaoDoUsuario(notaInseridaPeloUsuario);

        av.setComentarioAvaliacao(txtComentarioAvaliacao.getText());

        lvdao.create(lv);
        autdao.create(aut);
        avdao.create(av, txtTitulo.getText());

        // Para que a leitura da tabela seja feita novamente
        // após salvar novas informações
        readJTable();

    }//GEN-LAST:event_btnFinalizarCadastroActionPerformed

    public void listarIdiomasDoLivro() {
        LivroDAO.listaDeIdiomas(cboxLivroIdioma);
    }

    public void listarNacionalidades() {
        AutorDAO.listaDeNacionalidades(cboxNacionalidadeDoAutor);

    }

    public void listarCategorias() {
        LivroCategoriaDAO.listarCategorias(cboxCategoria);
    }

    public void listarSubCategoria(String idCategoria) {
        LivroCategoriaDAO.listarSubCategoria(cboxSubCategoria, idCategoria);
    }

    private void btnTelaPrinCadLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaPrinCadLivroActionPerformed
        new TelaPrincipalAdministrador().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTelaPrinCadLivroActionPerformed

    private void cboxAutorSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAutorSexoActionPerformed

    }//GEN-LAST:event_cboxAutorSexoActionPerformed

    private void btnLimparLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparLivroActionPerformed
        // Limpar os campos já preenchidos e define valor "Não Informado" para todas as JComboBox

        txtTitulo.setText("");
        txtISBN.setText("");
        txtAnoDePublicacao.setText("");
        txtNumeroDePaginas.setText("");
        cboxCategoria.setSelectedItem("Não Informada");
        cboxSubCategoria.setSelectedItem("Não Informada");
        txtQuantidade.setText("");
        txtPreco.setText("");
        cboxLivroIdioma.setSelectedItem("Não Informado");
        txtNomeDaEditora.setText("");
        cboxAvaliacaoDoLivro.setSelectedItem("Não Informada");
        txtComentarioAvaliacao.setText("");

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

    private void btnProximaTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaTelaActionPerformed
        this.janelaDeAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btnProximaTelaActionPerformed

    private void btnLimparAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparAutorActionPerformed
        // Limpar os campos já preenchidos e define valor "Selecione" para todas as JComboBox

        txtNomeDoAutor.setText("");
        cboxAutorSexo.setSelectedItem("Não Informado");
        calendarNasciAutor.setCalendar(null);
        cboxNacionalidadeDoAutor.setSelectedItem("Não Informada");
        txtAutorBibliografia.setText("");

    }//GEN-LAST:event_btnLimparAutorActionPerformed

    private void btnTelaPrinCadAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaPrinCadAutorActionPerformed
        new TelaPrincipalAdministrador().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTelaPrinCadAutorActionPerformed

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
    private javax.swing.JScrollPane boxBibliografiaAutor;
    private javax.swing.JScrollPane boxComentarioAvaliacao;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFinalizarCadastro;
    private javax.swing.JButton btnLimparAutor;
    private javax.swing.JButton btnLimparLivro;
    private javax.swing.JButton btnProximaTela;
    private javax.swing.JButton btnTelaPrinCadAutor;
    private javax.swing.JButton btnTelaPrinCadLivro;
    private javax.swing.JPanel cadAutor;
    private javax.swing.JPanel cadLivros;
    private com.toedter.calendar.JDateChooser calendarNasciAutor;
    private javax.swing.JComboBox<String> cboxAutorSexo;
    private javax.swing.JComboBox<String> cboxAvaliacaoDoLivro;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxLivroIdioma;
    private javax.swing.JComboBox<String> cboxNacionalidadeDoAutor;
    private javax.swing.JComboBox<String> cboxSubCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane janelaDeAbas;
    private javax.swing.JPanel pnSelect;
    private javax.swing.JTable tbSelect;
    private javax.swing.JTextField txtAnoDePublicacao;
    private javax.swing.JTextArea txtAutorBibliografia;
    private javax.swing.JTextArea txtComentarioAvaliacao;
    private javax.swing.JTextField txtDeBoasVindasAutor;
    private javax.swing.JTextField txtDeBoasVindasLivro;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNomeDaEditora;
    private javax.swing.JTextField txtNomeDoAutor;
    private javax.swing.JTextField txtNumeroDePaginas;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
