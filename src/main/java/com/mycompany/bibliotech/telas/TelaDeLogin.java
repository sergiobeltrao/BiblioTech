package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.UsuarioLoginDAO;
import com.mycompany.bibliotech.model.bean.ApplicationContext;
import com.mycompany.bibliotech.model.bean.Login;

import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;

public class TelaDeLogin extends javax.swing.JFrame {

    public TelaDeLogin() {
        initComponents();

        // BUG: ACABA ABRINDO DUAS JANELAS. RESOLVER DEPOIS.
        /*
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);

            }
        });
         */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrar = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        campoUsuario = new javax.swing.JTextField();
        txtLogin = new javax.swing.JLabel();
        txtSenha = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        fundoTelaLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        setBackground(new java.awt.Color(204, 204, 204));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        btnEntrar.setBackground(new java.awt.Color(51, 51, 51));
        btnEntrar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(220, 390, 70, 25);

        campoSenha.setBackground(new java.awt.Color(0, 0, 0));
        campoSenha.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        campoSenha.setForeground(new java.awt.Color(255, 255, 255));
        campoSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        campoSenha.setCaretColor(new java.awt.Color(255, 255, 255));
        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(campoSenha);
        campoSenha.setBounds(110, 330, 300, 35);

        campoUsuario.setBackground(new java.awt.Color(0, 0, 0));
        campoUsuario.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        campoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        campoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoUsuario.setActionCommand("null");
        campoUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        campoUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        campoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoUsuario.setName(""); // NOI18N
        campoUsuario.setOpaque(true);
        campoUsuario.setVerifyInputWhenFocusTarget(false);
        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(campoUsuario);
        campoUsuario.setBounds(110, 270, 300, 35);
        campoUsuario.getAccessibleContext().setAccessibleName("");

        txtLogin.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(255, 255, 255));
        txtLogin.setText("Login:");
        getContentPane().add(txtLogin);
        txtLogin.setBounds(60, 270, 50, 35);

        txtSenha.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(255, 255, 255));
        txtSenha.setText("Senha:");
        getContentPane().add(txtSenha);
        txtSenha.setBounds(60, 330, 50, 35);

        btnSair.setBackground(new java.awt.Color(0, 0, 0));
        btnSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("X");
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(475, 0, 20, 20);

        fundoTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/telalogin.gif"))); // NOI18N
        fundoTelaLogin.setText("telaLogin");
        getContentPane().add(fundoTelaLogin);
        fundoTelaLogin.setBounds(0, 0, 500, 500);

        setSize(new java.awt.Dimension(498, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        UsuarioLoginDAO dao = new UsuarioLoginDAO();
        String userType = dao.checkLogin(campoUsuario.getText(), campoSenha.getText());

        Login lg = new Login();
        lg.setNick(campoUsuario.getText());
        ApplicationContext.setLogin(lg);

        if (userType != null) {
            // Login bem-sucedido
            if (userType.equals("ADMIN")) {
                // O usuário é O administrador
                new TelaPrincipalAdministrador().setVisible(true);
                this.dispose();
            } else if (userType.equals("CLIENTE")) {
                // O usuário é um cliente
                new TelaPrincipalCliente().setVisible(true);
                this.dispose();
            } else if (userType.equals("BIBLIOTECARIO")) {
                // O usuário é um bibliotecario
                new TelaPrincipalBibliotecario().setVisible(true);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esse usuário ou senha é inválido");
        }


    }//GEN-LAST:event_btnEntrarActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Pressionou Enter, executar ação de login
            btnEntrarActionPerformed(null);
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

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
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel fundoTelaLogin;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtSenha;
    // End of variables declaration//GEN-END:variables
}
