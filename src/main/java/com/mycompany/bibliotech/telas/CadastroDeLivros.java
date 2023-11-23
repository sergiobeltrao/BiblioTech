package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.dao.AutorDAO;
import com.mycompany.bibliotech.dao.AvaliacaoDAO;
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
        cadLivros = new javax.swing.JPanel();
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
        cadAutor = new javax.swing.JPanel();
        txtDeBoasVindasAutor = new javax.swing.JTextField();
        txtNomeDoAutor = new javax.swing.JTextField();
        cboxAutorSexo = new javax.swing.JComboBox<>();
        cboxNacionalidadeDoAutor = new javax.swing.JComboBox<>();
        boxBibliografiaAutor = new javax.swing.JScrollPane();
        txtAutorBibliografia = new javax.swing.JTextArea();
        btnTelaPrinCadAutor = new javax.swing.JButton();
        btnLimparAutor = new javax.swing.JButton();
        btnProximaAbaAutor = new javax.swing.JButton();
        cadAvaliacao = new javax.swing.JPanel();
        txtDeBoasVindasAvaliacao = new javax.swing.JTextField();
        cboxAvaliacaoDoLivro = new javax.swing.JComboBox<>();
        boxComentarioAvaliacao = new javax.swing.JScrollPane();
        txtComentarioAvaliacao = new javax.swing.JTextArea();
        btnTelaPrinCadAvaliacao = new javax.swing.JButton();
        btnLimparAvaliacao = new javax.swing.JButton();
        btnFinalizarCadastro = new javax.swing.JButton();
        pnSelect = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSelect = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        janelaDeAbas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        cadLivros.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout cadLivrosLayout = new javax.swing.GroupLayout(cadLivros);
        cadLivros.setLayout(cadLivrosLayout);
        cadLivrosLayout.setHorizontalGroup(
            cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadLivrosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDeBoasVindasLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cadLivrosLayout.createSequentialGroup()
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cadLivrosLayout.createSequentialGroup()
                                .addComponent(btnProximaAbaLivro)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarLivro)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletarLivro))
                            .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cadLivrosLayout.createSequentialGroup()
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(cadLivrosLayout.createSequentialGroup()
                                    .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadLivrosLayout.createSequentialGroup()
                                    .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cboxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(cadLivrosLayout.createSequentialGroup()
                                    .addComponent(btnTelaPrinCadLivro)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLimparLivro)))
                            .addGroup(cadLivrosLayout.createSequentialGroup()
                                .addComponent(cboxIsbnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(formatedIsbn)))
                        .addGap(18, 18, 18)
                        .addComponent(boxSinopse)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        cadLivrosLayout.setVerticalGroup(
            cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadLivrosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtDeBoasVindasLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxLivroIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeDaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadLivrosLayout.createSequentialGroup()
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(formatedIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(cboxIsbnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroDePaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnoDePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(boxSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadLivrosLayout.createSequentialGroup()
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimparLivro)
                            .addComponent(btnTelaPrinCadLivro))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadLivrosLayout.createSequentialGroup()
                        .addGroup(cadLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeletarLivro)
                            .addComponent(btnEditarLivro)
                            .addComponent(btnProximaAbaLivro))
                        .addGap(16, 16, 16))))
        );

        janelaDeAbas.addTab("Cadastrar Livro", cadLivros);

        cadAutor.setBackground(new java.awt.Color(255, 255, 255));

        txtDeBoasVindasAutor.setEditable(false);
        txtDeBoasVindasAutor.setBackground(new java.awt.Color(255, 255, 255));
        txtDeBoasVindasAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDeBoasVindasAutor.setText("Bem-vindo ao formulário de cadastro do autor. Os campo com asterisco são de preenchimento obrigatório.");
        txtDeBoasVindasAutor.setBorder(null);
        txtDeBoasVindasAutor.setFocusable(false);

        txtNomeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNomeDoAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N

        cboxAutorSexo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxAutorSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informado", "Masculino", "Feminino" }));
        cboxAutorSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxAutorSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAutorSexoActionPerformed(evt);
            }
        });

        cboxNacionalidadeDoAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxNacionalidadeDoAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxNacionalidadeDoAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nacionalidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxNacionalidadeDoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNacionalidadeDoAutorActionPerformed(evt);
            }
        });

        boxBibliografiaAutor.setBorder(null);

        txtAutorBibliografia.setColumns(20);
        txtAutorBibliografia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAutorBibliografia.setLineWrap(true);
        txtAutorBibliografia.setRows(5);
        txtAutorBibliografia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bibliografia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        boxBibliografiaAutor.setViewportView(txtAutorBibliografia);

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

        javax.swing.GroupLayout cadAutorLayout = new javax.swing.GroupLayout(cadAutor);
        cadAutor.setLayout(cadAutorLayout);
        cadAutorLayout.setHorizontalGroup(
            cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadAutorLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDeBoasVindasAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(cadAutorLayout.createSequentialGroup()
                            .addComponent(btnTelaPrinCadAutor)
                            .addGap(18, 18, 18)
                            .addComponent(btnLimparAutor)
                            .addGap(902, 902, 902)
                            .addComponent(btnProximaAbaAutor))
                        .addGroup(cadAutorLayout.createSequentialGroup()
                            .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNomeDoAutor)
                                .addComponent(cboxAutorSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxNacionalidadeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(boxBibliografiaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        cadAutorLayout.setVerticalGroup(
            cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadAutorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtDeBoasVindasAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadAutorLayout.createSequentialGroup()
                        .addComponent(txtNomeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxAutorSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxNacionalidadeDoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boxBibliografiaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(cadAutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparAutor)
                    .addComponent(btnTelaPrinCadAutor)
                    .addComponent(btnProximaAbaAutor))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        janelaDeAbas.addTab("Cadastrar Autor", cadAutor);

        cadAvaliacao.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout cadAvaliacaoLayout = new javax.swing.GroupLayout(cadAvaliacao);
        cadAvaliacao.setLayout(cadAvaliacaoLayout);
        cadAvaliacaoLayout.setHorizontalGroup(
            cadAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadAvaliacaoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(cadAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cadAvaliacaoLayout.createSequentialGroup()
                        .addComponent(btnTelaPrinCadAvaliacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparAvaliacao)
                        .addGap(875, 875, 875)
                        .addComponent(btnFinalizarCadastro))
                    .addGroup(cadAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadAvaliacaoLayout.createSequentialGroup()
                            .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(boxComentarioAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDeBoasVindasAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        cadAvaliacaoLayout.setVerticalGroup(
            cadAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadAvaliacaoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtDeBoasVindasAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(cadAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxAvaliacaoDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxComentarioAvaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(cadAvaliacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTelaPrinCadAvaliacao)
                    .addComponent(btnLimparAvaliacao)
                    .addComponent(btnFinalizarCadastro))
                .addGap(16, 16, 16))
        );

        janelaDeAbas.addTab("Avaliar Livro", cadAvaliacao);

        pnSelect.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        Livro livro = new Livro();
        Autor autor = new Autor();
        Avaliacao avaliacao = new Avaliacao();
        Login login = ApplicationContext.getLogin();
        ValidadorIsbn validadorIsbn = new ValidadorIsbn();
        LivroDAO livrodao = new LivroDAO();
        AutorDAO autordao = new AutorDAO();
        AvaliacaoDAO avaliacaodao = new AvaliacaoDAO();

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

        // Captura informações preenchidas na aba Autor.
        String autorNome = txtNomeDoAutor.getText();
        String autorSexo = cboxAutorSexo.getSelectedItem().toString();
        String autorNacionalidade = cboxNacionalidadeDoAutor.getSelectedItem().toString();
        String autorBibliografia = txtAutorBibliografia.getText();

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

        if (livrodao.verificaDuplicidadeIsbn(livroNumeroIsbn).equals(livroNumeroIsbn)) {
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

        // Verifica se os campos obrigatórios da aba Autor foram preenchidos corretamente.
        if (autorNome.isBlank()) {
            codigoDoErro = 9;
        }

        // Verifica se os campos obrigatórios da aba Avaliar Livro foram preenchidos corretamente.
        if (avaliarLivroAvaliacao.equals("Não Informada")) {
            codigoDoErro = 10;
        }

        if (avaliarLivroComentario.isBlank()) {
            codigoDoErro = 11;
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
                JOptionPane.showMessageDialog(null, "Informe o nome do autor do livro.");
            case 10 ->
                JOptionPane.showMessageDialog(null, "Selecione uma nota para o livro");
            case 11 ->
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

                autor.setNome(autorNome);
                autor.setNacionalidade(autorNacionalidade);
                autor.setBibliografia(autorBibliografia);

                String valorSelecionado = "OUTRO"; // Valor padrão.

                if (autorSexo.equals("Masculino")) {
                    valorSelecionado = "MASC";
                } else if (autorSexo.equals("Feminino")) {
                    valorSelecionado = "FEM";
                }

                autor.setSexo(valorSelecionado);

                // Avaliação
                avaliacao.setAvaliacaoDoUsuario(avaliarLivroAvaliacao.substring(0, 2));
                avaliacao.setComentarioAvaliacao(avaliarLivroComentario);

                livrodao.create(livro);
                autordao.create(autor);
                avaliacaodao.create(avaliacao, txtTitulo.getText(), login.getNick());

                // Para que a leitura da tabela seja feita novamente
                // após salvar novas informações
                readJTable();
            }
        }
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
        cboxAutorSexo.setSelectedItem("Não Informado");
        cboxNacionalidadeDoAutor.setSelectedItem("Não Informada");
        txtAutorBibliografia.setText("");

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
        // Captura o que está digitado e verifica o comprimento.
        String anoDePublicacao = txtAnoDePublicacao.getText();
        int tamanho = anoDePublicacao.length();

        // Verifica se o que foi digitado é um número. E se o tamanho é maior que 4.
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (tamanho < 4) {
                txtAnoDePublicacao.setEditable(true);
            } else { // Se a quantidade de digitos passar de 4 o campo será desabilitado por 500ms.
                txtAnoDePublicacao.setEditable(false);
                Timer timer = new Timer(500, e -> txtAnoDePublicacao.setEditable(true));
                timer.setRepeats(false);
                timer.start();
            }
        } else { // Permite usar teclas como "Back Space" e "Delete" para corrigir algum erro.
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtAnoDePublicacao.setEditable(true);
            } else {
                txtAnoDePublicacao.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtAnoDePublicacaoKeyPressed

    private void txtNumeroDePaginasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDePaginasKeyPressed
        // Captura o que está digitado e verifica o comprimento.
        String anoDePublicacao = txtNumeroDePaginas.getText();
        int tamanho = anoDePublicacao.length();

        // Verifica se o que foi digitado é um número. E se o tamanho é maior que 4.
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (tamanho < 4) {
                txtNumeroDePaginas.setEditable(true);
            } else { // Se a quantidade de digitos passar de 4 o campo será desabilitado por 500ms.
                txtNumeroDePaginas.setEditable(false);
                Timer timer = new Timer(500, e -> txtNumeroDePaginas.setEditable(true));
                timer.setRepeats(false);
                timer.start();
            }
        } else { // Permite usar teclas como "Back Space" e "Delete" para corrigir algum erro.
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtNumeroDePaginas.setEditable(true);
            } else {
                txtNumeroDePaginas.setEditable(false);
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
    private javax.swing.JScrollPane boxSinopse;
    private javax.swing.JButton btnDeletarLivro;
    private javax.swing.JButton btnEditarLivro;
    private javax.swing.JButton btnFinalizarCadastro;
    private javax.swing.JButton btnLimparAutor;
    private javax.swing.JButton btnLimparAvaliacao;
    private javax.swing.JButton btnLimparLivro;
    private javax.swing.JButton btnProximaAbaAutor;
    private javax.swing.JButton btnProximaAbaLivro;
    private javax.swing.JButton btnTelaPrinCadAutor;
    private javax.swing.JButton btnTelaPrinCadAvaliacao;
    private javax.swing.JButton btnTelaPrinCadLivro;
    private javax.swing.JPanel cadAutor;
    private javax.swing.JPanel cadAvaliacao;
    private javax.swing.JPanel cadLivros;
    private javax.swing.JComboBox<String> cboxAutorSexo;
    private javax.swing.JComboBox<String> cboxAvaliacaoDoLivro;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxIsbnSelect;
    private javax.swing.JComboBox<String> cboxLivroIdioma;
    private javax.swing.JComboBox<String> cboxNacionalidadeDoAutor;
    private javax.swing.JComboBox<String> cboxSubCategoria;
    private javax.swing.JFormattedTextField formatedIsbn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane janelaDeAbas;
    private javax.swing.JPanel pnSelect;
    private javax.swing.JTable tbSelect;
    private javax.swing.JTextField txtAnoDePublicacao;
    private javax.swing.JTextArea txtAutorBibliografia;
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
