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

        panTeste = new javax.swing.JPanel();
        txtTeste = new javax.swing.JTextField();
        cboxTeste = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panTeste.setBackground(new java.awt.Color(255, 255, 255));

        txtTeste.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite o título do livro"));
        txtTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTesteActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panTesteLayout = new javax.swing.GroupLayout(panTeste);
        panTeste.setLayout(panTesteLayout);
        panTesteLayout.setHorizontalGroup(
            panTesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTesteLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(panTesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar)
                    .addComponent(cboxTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );
        panTesteLayout.setVerticalGroup(
            panTesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTesteLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboxTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        // O que faz a mágica acontecer é isso. O restante é no TelaAvaliacaoDAO.
        String busca = txtTeste.getText();

        // Aqui eu verifico o tamanho do texto que foi digitado. Se for menor que 1
        // uma mensagem aparerá pedindo para o usuário digitar algo. Eu poderia ter colocado
        // igual a zero (já que menos que 1 é 0) mas vou deixar assim. Acredito que seja
        // bacana limitar o número mínimo de caractéries para fazer uma busca (quem sabe uns
        // três ou quatro). Fica ao seu critério quando for implementar. A mensagem também
        // pode ser melhorada.
        if (busca.length() < 1) {
            JOptionPane.showMessageDialog(null, "Digite algo!");
            cboxTeste.removeAllItems(); // Limba a ComboBox se tentar pesquisar sem texto
            // depois de ter pesquisado com.
        } else {
            TelaAvaliacaoDAO.listaFiltrada(cboxTeste, busca);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTesteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTesteActionPerformed

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
    private javax.swing.JComboBox<String> cboxTeste;
    private javax.swing.JPanel panTeste;
    private javax.swing.JTextField txtTeste;
    // End of variables declaration//GEN-END:variables
}
