package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.TelaAvaliacaoDAO;
import javax.swing.JOptionPane;

public class Teste extends javax.swing.JFrame {

    public Teste() {
        initComponents();
        // Lembre-se de descomentar isso se quiser usar o método "listaTituloDosLivros"
        // listarBusca();
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
        txtNome = new javax.swing.JTextField();
        txtNomeLivro = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtAlfabeto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelBusca.setBackground(new java.awt.Color(255, 255, 255));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite o título do livro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        cboxTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTesteActionPerformed(evt);
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

        txtAlfabeto.setForeground(new java.awt.Color(0, 0, 0));
        txtAlfabeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "J", "F", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome por ordem alfabetica: ");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout painelBuscaLayout = new javax.swing.GroupLayout(painelBusca);
        painelBusca.setLayout(painelBuscaLayout);
        painelBuscaLayout.setHorizontalGroup(
            painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscaLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelBuscaLayout.createSequentialGroup()
                        .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAlfabeto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNomeLivro, javax.swing.GroupLayout.Alignment.LEADING, 0, 350, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(661, Short.MAX_VALUE))
        );
        painelBuscaLayout.setVerticalGroup(
            painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscaLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeLivro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1294, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        // O que faz a mágica acontecer é isso. O restante é no TelaAvaliacaoDAO.
        String busca = txtNome.getText();

        // Aqui eu verifico o tamanho do texto que foi digitado. Se for menor que 1
        // uma mensagem aparerá pedindo para o usuário digitar algo. Eu poderia ter colocado
        // igual a zero (já que menos que 1 é 0) mas vou deixar assim. Acredito que seja
        // bacana limitar o número mínimo de caractéries para fazer uma busca (quem sabe uns
        // três ou quatro). Fica ao seu critério quando for implementar. A mensagem também
        // pode ser melhorada.
        if (busca.length() < 1) {
            JOptionPane.showMessageDialog(null, "Digite algo!");
            txtNomeLivro.removeAllItems(); // Limba a ComboBox se tentar pesquisar sem texto
            // depois de ter pesquisado com.
        } else {
            TelaAvaliacaoDAO.listaFiltrada(txtNomeLivro, busca);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void cboxTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTesteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxTesteActionPerformed

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
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel painelBusca;
    private javax.swing.JComboBox<String> txtAlfabeto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JComboBox<String> txtNomeLivro;
    // End of variables declaration//GEN-END:variables
}
