package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.ExcluirUserDAO;
import com.mycompany.bibliotech.dao.UsuarioCadastroDAO;
import com.mycompany.bibliotech.model.bean.Usuario;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TelaPrincipalAdministrador extends javax.swing.JFrame {

    public TelaPrincipalAdministrador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLateral = new javax.swing.JPanel();
        txtMenuPrincipal = new javax.swing.JTextField();
        CadUserButton = new javax.swing.JButton();
        CadLivroButton = new javax.swing.JButton();
        btnEncerrarSessao = new javax.swing.JButton();
        avaliacaoButton = new javax.swing.JButton();
        ExcluirUserButton = new javax.swing.JToggleButton();
        edicaoUserButton = new javax.swing.JButton();
        campoCentral = new javax.swing.JPanel();
        txtTemporario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");

        menuLateral.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuLateral.setPreferredSize(new java.awt.Dimension(272, 40));

        txtMenuPrincipal.setEditable(false);
        txtMenuPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtMenuPrincipal.setText("Menu Principal");
        txtMenuPrincipal.setBorder(null);

        CadUserButton.setText("Cadastro de Usuarios");
        CadUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadUserButtonActionPerformed(evt);
            }
        });

        CadLivroButton.setText("Cadastro de Livros");
        CadLivroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadLivroButtonActionPerformed(evt);
            }
        });

        btnEncerrarSessao.setText("Encerrar Sessão");
        btnEncerrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarSessaoActionPerformed(evt);
            }
        });

        avaliacaoButton.setText("Avaliações");
        avaliacaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaliacaoButtonActionPerformed(evt);
            }
        });

        ExcluirUserButton.setText("Excluir Usuarios");
        ExcluirUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirUserButtonActionPerformed(evt);
            }
        });

        edicaoUserButton.setText("Edição de Usuarios");
        edicaoUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edicaoUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CadUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CadLivroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(txtMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avaliacaoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ExcluirUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(edicaoUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CadUserButton)
                .addGap(18, 18, 18)
                .addComponent(CadLivroButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avaliacaoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ExcluirUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edicaoUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEncerrarSessao)
                .addGap(15, 15, 15))
        );

        campoCentral.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTemporario.setEditable(false);
        txtTemporario.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        txtTemporario.setText("AS FUNCIONALIDADES DO PROGRAMA");
        txtTemporario.setBorder(null);
        txtTemporario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemporarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout campoCentralLayout = new javax.swing.GroupLayout(campoCentral);
        campoCentral.setLayout(campoCentralLayout);
        campoCentralLayout.setHorizontalGroup(
            campoCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campoCentralLayout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(txtTemporario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        campoCentralLayout.setVerticalGroup(
            campoCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campoCentralLayout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(txtTemporario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTemporarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemporarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTemporarioActionPerformed

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

    private void avaliacaoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaliacaoButtonActionPerformed
        new TelaAvaliacao().setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_avaliacaoButtonActionPerformed

    private void ExcluirUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirUserButtonActionPerformed

        // Implementação Bruno
        // ExcluirUserDAO ex = new ExcluirUserDAO();
        // ex.mostrarEExcluirUsuario();
        
        // Cria a instância o UsuarioDAO 
        UsuarioCadastroDAO usercadastrodao = new UsuarioCadastroDAO();
        // Cria a combobox
        JComboBox<String> userList = new JComboBox<>();
        // Preenche a lista de usuários cadastrados no banco
        usercadastrodao.preencherListaUsuarios(userList);
        // Exibição da caixa de diálogo para o usuário fazer uma escolha
        int option = JOptionPane.showConfirmDialog(
                null,
                userList,
                "Selecione um usuário para excluir:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Verifica se o usuário clicou em "OK" na caixa de diálogo
        if (option == JOptionPane.OK_OPTION) {
            String selectedUser = userList.getSelectedItem().toString();
            // Confirmação para excluir o usuário
            int confirmOption = JOptionPane.showConfirmDialog(
                    null,
                    "Tem certeza que deseja excluir o usuário " + selectedUser + "?",
                    "Confirmação de exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            // Verifica se o usuário confirmou a exclusão
            if (confirmOption == JOptionPane.YES_OPTION) {
                // Realiza a exclusão do usuário
                usercadastrodao.excluirUsuario(selectedUser);
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            }
        }
    }//GEN-LAST:event_ExcluirUserButtonActionPerformed

    private void edicaoUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edicaoUserButtonActionPerformed

        UsuarioCadastroDAO userdao = new UsuarioCadastroDAO();
        Usuario user = new Usuario();

        String userNome = JOptionPane.showInputDialog(this, "Digite o nome do usuário a ser editado:");

        if (userNome != null && !userNome.isEmpty()) {
            // user.setUserNick(userNome);
            userdao.buscarUsuarioPorNome(user, userNome);

            // Verifique se os dados foram preenchidos em 'user' após a chamada do método

            if (user.getUserId() != 0) {
                // Abre a tela de edição com os dados do usuário
                new EdicaoUsuario().setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite um nome de usuário válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        }

        /*    // Exibir um JOptionPane para obter o nick do usuário
        String nick = JOptionPane.showInputDialog(this, "Digite o nick do usuário a ser excluído:");

        // Verificar se o usuário digitou algo
        if (nick != null && !nick.isEmpty()) {
            // Aqui você pode adicionar a lógica para buscar as informações do usuário no banco de dados
            // Substitua a chamada do método 'buscarUsuarioNoBanco' pela sua própria lógica
            Usuario usuario = buscarUsuarioNoBanco(nick);

            // Verificar se o usuário foi encontrado no banco de dados
            if (usuario != null) {
                // Exibir as informações do usuário em uma nova interface gráfica
                exibirInformacoesDoUsuario(usuario);
            } else {
                // Caso o usuário não seja encontrado, exibir uma mensagem informando
                JOptionPane.showMessageDialog(this, "Usuário não encontrado no banco de dados.");
            }
        } else {
            // Caso o usuário tenha clicado em cancelar ou não digitado nada
            JOptionPane.showMessageDialog(this, "Operação cancelada ou nenhum nick fornecido.");
        } */
        /*String nome = JOptionPane.showInputDialog("Digite o nome da pessoa a ser atualizada");
        UsuarioCadastroDAO userdao = new UsuarioCadastroDAO();
        Usuario use = new Usuario();
        if (userdao.buscarPessoa( User, Fone, End)) {
            // Exibir os detalhes da pessoa atual
            JOptionPane.showMessageDialog(null, "Detalhes da pessoa:\n" + p.toString());

            // Solicitar as informações atualizadas ao usuário
            String novoNome = JOptionPane.showInputDialog("Digite o novo nome (ou deixe em branco para manter o mesmo):");
            String novoFone = JOptionPane.showInputDialog("Digite o novo telefone (ou deixe em branco para manter o mesmo):");
            String novoEmail = JOptionPane.showInputDialog("Digite o novo email (ou deixe em branco para manter o mesmo):");

            // Atualizar os campos, se forem fornecidos
            if (!novoNome.isEmpty()) {
                use.setNome(novoNome);
            }
            if (!novoFone.isEmpty()) {
                use.setFone(novoFone);
            }
            if (!novoEmail.isEmpty()) {
                use.setEmail(novoEmail);
            }

            // Chamar o método de atualização
            if (p.atualizar()) {
                JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar a pessoa.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado");
        }
        }
        }  */
        /*
        // Método de exemplo para buscar o usuário no banco de dados (substitua pela sua própria lógica)
        private Usuario buscarUsuarioNoBanco(String nick) {
            // Adicione sua lógica de busca no banco de dados aqui
            // Este é apenas um exemplo de um objeto de usuário fictício
            // Substitua isso pela sua lógica real de consulta ao banco de dados
            return new Usuario(nick, "Nome do Usuário", "Email do Usuário");
        }

        // Método de exemplo para exibir as informações do usuário em uma nova interface gráfica
        private void exibirInformacoesDoUsuario(Usuario usuario) {
            // Adicione sua lógica para exibir as informações do usuário na nova interface gráfica aqui
            // Este é apenas um exemplo, substitua pela sua própria lógica
            JOptionPane.showMessageDialog(this, "Informações do Usuário:\n\nNick: " + usuario.getNick() +
                "\nNome: " + usuario.getNome() + "\nEmail: " + usuario.getEmail());
        }

        // Classe de exemplo para representar um usuário (substitua pela sua própria classe de usuário)
        private class Usuario {
            private String nick;
            private String nome;
            private String email;

            public Usuario(String nick, String nome, String email) {
                this.nick = nick;
                this.nome = nome;
                this.email = email;
            }

            public String getNick() {
                return nick;
            }

            public String getNome() {
                return nome;
            }

            public String getEmail() {
                return email;
            }
        }
    }//GEN-LAST:event_edicaoUserButtonActionPerformed

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
    private javax.swing.JButton CadLivroButton;
    private javax.swing.JButton CadUserButton;
    private javax.swing.JToggleButton ExcluirUserButton;
    private javax.swing.JButton avaliacaoButton;
    private javax.swing.JButton btnEncerrarSessao;
    private javax.swing.JPanel campoCentral;
    private javax.swing.JButton edicaoUserButton;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JTextField txtMenuPrincipal;
    private javax.swing.JTextField txtTemporario;
    // End of variables declaration//GEN-END:variables
}
