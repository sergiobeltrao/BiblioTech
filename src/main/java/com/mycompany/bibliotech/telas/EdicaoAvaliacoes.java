package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.ImagemDAO;
import com.mycompany.bibliotech.dao.UsuarioLoginDAO;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class EdicaoAvaliacoes extends javax.swing.JFrame {

    public EdicaoAvaliacoes() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();
        jtbAvaliacoes.setRowSorter(new TableRowSorter(modelo));
        selectTabelaLivro();
        userTxt.setEnabled(false);
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
        jtbAvaliacoes.setDefaultRenderer(Object.class, new EdicaoAvaliacoes.CenterRenderer());
        JTableHeader header = jtbAvaliacoes.getTableHeader();
        header.setDefaultRenderer(new EdicaoAvaliacoes.CenterRenderer());

        // Para evitar que todos os dados sejam duplicados após um insert
        modelo.setNumRows(0);

        AvaliacaoDAO avdao = new AvaliacaoDAO();

        for (Avaliacao a : avdao.avaDosUsuarios()) {
            modelo.addRow(new Object[]{
                a.getUsuario().getUserId(),
                a.getUsuario().getUserNick(),
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

        panDados = new javax.swing.JPanel();
        jlbCapaDoLivro = new javax.swing.JLabel();
        cboxNotaLivro = new javax.swing.JComboBox<>();
        tpnComentarioDoLivro = new javax.swing.JScrollPane();
        txtComentarioLivro = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtTituloLivro = new javax.swing.JTextField();
        userTxt = new javax.swing.JTextField();
        tpnTabelaAvaliacoes = new javax.swing.JScrollPane();
        jtbAvaliacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panDados.setBackground(new java.awt.Color(255, 255, 255));
        panDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlbCapaDoLivro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbCapaDoLivro.setEnabled(false);

        cboxNotaLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxNotaLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada", "10 - Excelente", "9 - Ótimo", "8 - Muito Bom", "7 - Bom", "6 - Satisfatório", "5 - Regular", "4 - Abaixo da Média", "3 - Ruim", "2 - Muito Ruim", "1 - Péssimo", "0 - Inaceitável" }));
        cboxNotaLivro.setEnabled(false);

        txtComentarioLivro.setColumns(20);
        txtComentarioLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtComentarioLivro.setLineWrap(true);
        txtComentarioLivro.setRows(5);
        txtComentarioLivro.setEnabled(false);
        tpnComentarioDoLivro.setViewportView(txtComentarioLivro);

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnSelecionar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtTituloLivro.setEditable(false);
        txtTituloLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTituloLivro.setFocusable(false);

        javax.swing.GroupLayout panDadosLayout = new javax.swing.GroupLayout(panDados);
        panDados.setLayout(panDadosLayout);
        panDadosLayout.setHorizontalGroup(
            panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSelecionar)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTituloLivro)
                    .addComponent(tpnComentarioDoLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(cboxNotaLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jlbCapaDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnDeletar)
                    .addComponent(btnLimpar))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        panDadosLayout.setVerticalGroup(
            panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDadosLayout.createSequentialGroup()
                        .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userTxt)
                            .addComponent(txtTituloLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cboxNotaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSelecionar)
                            .addComponent(tpnComentarioDoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jlbCapaDoLivro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panDadosLayout.createSequentialGroup()
                            .addComponent(btnLimpar)
                            .addGap(18, 18, 18)
                            .addComponent(btnSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeletar))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jtbAvaliacoes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtbAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID do Usuario", "Nick do Usuario", "ID do Livro", "Títlulo", "Nota", "Comentário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpnTabelaAvaliacoes)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpnTabelaAvaliacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        );

        pack();
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

            //String idDoUsuarioString = modelo.getValueAt(linha, 0).toString();
            userTxt.setText(modelo.getValueAt(linha, 1).toString());
            String idDoLivroString = modelo.getValueAt(linha, 2).toString();
            txtTituloLivro.setText(modelo.getValueAt(linha, 3).toString());
            String valorDaNota = modelo.getValueAt(linha, 4).toString();
            txtComentarioLivro.setText(modelo.getValueAt(linha, 5).toString());

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
        userTxt.setText(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();
        int linha = jtbAvaliacoes.getSelectedRow();

        if (cboxNotaLivro.getSelectedItem().toString().equals("Não Informada")) {
            JOptionPane.showMessageDialog(null, "Use o botão selecionar.");
        } else if (linha != -1) {

            DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();

            String valorDaNotaString = modelo.getValueAt(linha, 4).toString();
            double valorDaNotaDouble = Double.parseDouble(valorDaNotaString);
            String comentario = txtComentarioLivro.getText();
            //String userNick = userTxt.getText();
            String idUsuarioString = modelo.getValueAt(linha, 0).toString();
            int idUsuario = Integer.parseInt(idUsuarioString);
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
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário");
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();

        int linha = jtbAvaliacoes.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) jtbAvaliacoes.getModel();
        String idUsuarioString = modelo.getValueAt(linha, 0).toString();
        int idUsuario = Integer.parseInt(idUsuarioString);
        String valorIdLivro = modelo.getValueAt(linha, 2).toString();

        String notaSelecionada = cboxNotaLivro.getSelectedItem().toString();
        String comentarioLivro = txtComentarioLivro.getText();
        //String userNick = userTxt.getText();
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
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(EdicaoAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EdicaoAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EdicaoAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EdicaoAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EdicaoAvaliacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cboxNotaLivro;
    private javax.swing.JLabel jlbCapaDoLivro;
    private javax.swing.JTable jtbAvaliacoes;
    private javax.swing.JPanel panDados;
    private javax.swing.JScrollPane tpnComentarioDoLivro;
    private javax.swing.JScrollPane tpnTabelaAvaliacoes;
    private javax.swing.JTextArea txtComentarioLivro;
    private javax.swing.JTextField txtTituloLivro;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
