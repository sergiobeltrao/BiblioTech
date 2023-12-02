package com.mycompany.bibliotech.ferramentas;

import com.mycompany.bibliotech.dao.ImagemDAO;
import com.mycompany.bibliotech.model.bean.Livro;
import com.mycompany.bibliotech.telas.EdicaoDeLivro;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class InserirCapaDosLivros extends javax.swing.JFrame {

    public InserirCapaDosLivros() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnInserirCapas = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jlbCapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnInserirCapas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnInserirCapas.setText("Inserir Capas");
        btnInserirCapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirCapasActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField1.setText("Só clicar em inserir e aguardar 3 segundos");
        jTextField1.setBorder(null);
        jTextField1.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jlbCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnInserirCapas)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInserirCapas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirCapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirCapasActionPerformed
        Livro livro = new Livro();
        ImagemDAO imagemDAO = new ImagemDAO();

        String[] caminhosImagens = {
            "/imagem/capalivro/osegredodasestrelas.jpg",
            "/imagem/capalivro/oalquimista.jpg",
            "/imagem/capalivro/domcasmurro.jpg",
            "/imagem/capalivro/cosmos.jpg",
            "/imagem/capalivro/opequenoprincipe.jpg",
            "/imagem/capalivro/aorigemdasespecies.jpg",
            "/imagem/capalivro/opoderdohabito.jpg",
            "/imagem/capalivro/cemanosdesolidao.jpg",
            "/imagem/capalivro/arevolucaodosbichos.jpg",
            "/imagem/capalivro/ocodigodavinci.jpg",
            "/imagem/capalivro/aartedaguerra.jpg",
            "/imagem/capalivro/osenhordosaneisasociedadedoanel.jpg"
        };

        for (int i = 1; i <= 12; i++) {
            ImageIcon icon = new ImageIcon(getClass().getResource(caminhosImagens[i - 1]));
            Image imagem = icon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
            ImageIcon iconeRedimensionado = new ImageIcon(imagem);
            jlbCapa.setIcon(iconeRedimensionado);

            // Convertendo a imagem para um array de bytes.
            BufferedImage bufferedImage = new BufferedImage(imagem.getWidth(null), imagem.getHeight(null), BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(imagem, 0, 0, null);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            try {
                ImageIO.write(bufferedImage, "jpg", stream);
            } catch (IOException ex) {
                Logger.getLogger(EdicaoDeLivro.class.getName()).log(Level.SEVERE, null, ex);
            }

            byte[] bytesImagem = stream.toByteArray();

            livro.setImagem(bytesImagem);
            livro.setId(i);

            try {
                imagemDAO.alterarImagem(livro);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar imagem: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }

        jlbCapa.setIcon(null);
        JOptionPane.showMessageDialog(null, "Concluído!");
    }//GEN-LAST:event_btnInserirCapasActionPerformed

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
            java.util.logging.Logger.getLogger(InserirCapaDosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirCapaDosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirCapaDosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirCapaDosLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserirCapaDosLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserirCapas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlbCapa;
    // End of variables declaration//GEN-END:variables
}
