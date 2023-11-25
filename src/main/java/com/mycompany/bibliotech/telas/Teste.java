package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.dao.TelaAvaliacaoDAO;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Teste extends javax.swing.JFrame {

    public Teste(Avaliacao avaliacao) {
        initComponents();
        setPesquisarValues(avaliacao);
        
        // Adicione o novo ActionListener à cboxNomeLivro
    cboxNomeLivro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                String pesquisar = cboxNomeLivro.getSelectedItem().toString();
                if (pesquisar != null && !pesquisar.isEmpty()) {
                    TelaAvaliacaoDAO taDAO = new TelaAvaliacaoDAO();
                    Avaliacao pes = taDAO.find(pesquisar);
                    setPesquisarValues(pes);
                    JOptionPane.showMessageDialog(null, "Item selecionado: " + pesquisar);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar o livro." + ex);
            }
        }
    });


        cboxAlfabeto.setForeground(new java.awt.Color(0, 0, 0));
        cboxAlfabeto.addItem("");
        cboxAlfabeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"", "A", "B", "C", 
            "D", "E", "F", "J", "F", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
         cboxNomeLivro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cboxNomeLivroeActionPerformed(evt);
        }
    });
        // Lembre-se de descomentar isso se quiser usar o método "listaTituloDosLivros"
        // listarBusca();

        listarCategorias();

    }

    private void setPesquisarValues(Avaliacao avaliacao) {
        if (avaliacao != null) {
            txtAno.setText(String.valueOf(avaliacao.getTxtAno()));
            txtEditora.setText(avaliacao.getTxtEditora());
            txtIdioma.setText(avaliacao.getTxtIdioma());
            txtIsbn.setText(avaliacao.getTxtIsbn());
            txtNomeAutor.setText(avaliacao.getTxtNomeAutor());
            txtPaginas.setText(String.valueOf(avaliacao.getTxtPaginas()));
        }

    }

    // Você só precisa disso para listar TODOS os livros (sem usar a busca).
    // Usa o método "listaTituloDosLivros" dentro do TelaAvaliacaoDAO.
    public void listarBusca() {
        //  String busca = txtTeste.getText();
        // TelaAvaliacaoDAO.listaFiltrada(cboxTeste, busca);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBusca = new javax.swing.JPanel();
        txtTituloBusca = new javax.swing.JTextField();
        cboxNomeLivro = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboxAlfabeto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboxCategoriaBusca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboxSubCategoriaBusca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNomeAutor = new javax.swing.JTextField();
        txtEditora = new javax.swing.JTextField();
        txtPaginas = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        txtNumeral1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTituloBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTituloBusca.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite o título do livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        cboxNomeLivro.setEnabled(false);
        cboxNomeLivro.setFocusable(false);
        cboxNomeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNomeLivroeActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome do livro:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        cboxAlfabeto.setForeground(new java.awt.Color(0, 0, 0));
        cboxAlfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAlfabetoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("busca por Letra:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        cboxCategoriaBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaBuscaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Categoria: ");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Sub-Categoria: ");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtNomeAutor.setEditable(false);
        txtNomeAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomeAutor.setForeground(new java.awt.Color(0, 0, 0));

        txtEditora.setEditable(false);
        txtEditora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEditora.setForeground(new java.awt.Color(0, 0, 0));

        txtPaginas.setEditable(false);
        txtPaginas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPaginas.setForeground(new java.awt.Color(0, 0, 0));

        txtAno.setEditable(false);
        txtAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAno.setForeground(new java.awt.Color(0, 0, 0));

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

        txtIsbn.setEditable(false);
        txtIsbn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIsbn.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ISBN:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtIdioma.setEditable(false);
        txtIdioma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdioma.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Idioma:");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSlider2.setMaximum(10);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        txtNumeral1.setBackground(new java.awt.Color(0, 0, 0));
        txtNumeral1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtNumeral1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNumeral1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout painelBuscaLayout = new javax.swing.GroupLayout(painelBusca);
        painelBusca.setLayout(painelBuscaLayout);
        painelBuscaLayout.setHorizontalGroup(
            painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscaLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTituloBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboxCategoriaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(cboxSubCategoriaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addComponent(cboxAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(btnBuscar))
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeral1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(cboxNomeLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(txtNomeAutor)
                        .addGroup(painelBuscaLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(62, 62, 62)
                            .addComponent(jLabel9))
                        .addGroup(painelBuscaLayout.createSequentialGroup()
                            .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(txtAno)))
                        .addGroup(painelBuscaLayout.createSequentialGroup()
                            .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtIdioma))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        painelBuscaLayout.setVerticalGroup(
            painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTituloBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxCategoriaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxSubCategoriaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumeral1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(296, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
       /* Avaliacao pes = new Avaliacao();
        TelaAvaliacaoDAO taDAO = new TelaAvaliacaoDAO();
        // Obtém o item selecionado
        String pesquisar = cboxNomeLivro.getSelectedItem().toString();

        // Verifica se o item selecionado não é nulo ou vazio
        if (pesquisar != null && !pesquisar.isEmpty()) {
            try {
                pes = taDAO.find(pesquisar);
             JOptionPane.showMessageDialog(null, "Item selecionado: " + pesquisar);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar o livro." + ex);
            }
        }*/
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
    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        txtNumeral1.setText(String.valueOf(jSlider2.getValue()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jSlider2StateChanged
        

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
            java.util.logging.Logger.getLogger(Teste.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teste.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teste.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teste.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Avaliacao avaliacao = new Avaliacao();
                new Teste(avaliacao).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboxAlfabeto;
    private javax.swing.JComboBox<String> cboxCategoriaBusca;
    private javax.swing.JComboBox<String> cboxNomeLivro;
    private javax.swing.JComboBox<String> cboxSubCategoriaBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JPanel painelBusca;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtNomeAutor;
    private javax.swing.JLabel txtNumeral1;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtTituloBusca;
    // End of variables declaration//GEN-END:variables
}
