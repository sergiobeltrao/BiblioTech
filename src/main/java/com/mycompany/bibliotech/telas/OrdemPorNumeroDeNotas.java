package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.AvaliacaoDAO;
import com.mycompany.bibliotech.dao.ImagemDAO;
import com.mycompany.bibliotech.model.bean.ContagemAvaliacoesLivro;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class OrdemPorNumeroDeNotas extends javax.swing.JFrame {

    public OrdemPorNumeroDeNotas() {
        initComponents();
        selectTabelaAvaliacao();

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

    public void selectTabelaAvaliacao() {
        DefaultTableModel modelo = (DefaultTableModel) tbAvaliacaoNota.getModel();
        modelo.setRowCount(0);

        AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();

        for (ContagemAvaliacoesLivro contagem : avaliacaoDao.numeroDeNotasPorLivro()) {
            modelo.addRow(new Object[]{
                contagem.getNomeLivro(),
                contagem.getQuantidadeAvaliacoes()
            });
        }
    }

    private void exibirImagem(byte[] bytesImagem) {
        try {
            // Converte o array de bytes para uma imagem
            ByteArrayInputStream bis = new ByteArrayInputStream(bytesImagem);
            BufferedImage bImage = ImageIO.read(bis);
            ImageIcon icon = new ImageIcon(bImage);

            // Define a imagem na JLabel
            JImagem.setIcon(icon);
        } catch (IOException e) {
            Logger.getLogger(EdicaoDeLivro.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbAvaliacaoNota = new javax.swing.JTable();
        painelImagem = new javax.swing.JPanel();
        JImagem = new javax.swing.JLabel();
        buscarImagem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbAvaliacaoNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Título", "Quantidade de Notas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbAvaliacaoNota);

        painelImagem.setBackground(new java.awt.Color(255, 255, 255));
        painelImagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        JImagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        buscarImagem.setText("buscar imagem");
        buscarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelImagemLayout = new javax.swing.GroupLayout(painelImagem);
        painelImagem.setLayout(painelImagemLayout);
        painelImagemLayout.setHorizontalGroup(
            painelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImagemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscarImagem)
                .addGap(203, 203, 203))
            .addGroup(painelImagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        painelImagemLayout.setVerticalGroup(
            painelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarImagem)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(painelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(painelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarImagemActionPerformed
        //MinhaImagem minhaImagem = new MinhaImagem();
        ImagemDAO imagemDAO = new ImagemDAO();

        /*
        
        // Capturar o ID da imagem usando JOptionPane.showInputDialog
        String exibir = JOptionPane.showInputDialog("Escolha o ID da imagem:");
        byte[] bytesImagem = imagemDAO.exibirDisplay(exibir);

        if (bytesImagem != null) {
            exibirImagem(bytesImagem);
            minhaImagem.setImagem(bytesImagem);
        } else {
            JOptionPane.showMessageDialog(null, "O ID não tem imagem");
        }
        //configurando o jLabel par receber um icon 
        ImageIcon icon = (ImageIcon) JImagem.getIcon();
        System.out.println("Valor de icon: " + icon);

        if (icon != null) {
            System.out.println("Valor da imagem associada: " + icon.getImage());

            Image imagem = icon.getImage();

            Image reImagem = imagem.getScaledInstance(400, 380, Image.SCALE_SMOOTH);
            // Convertendo a imagem para um array de bytes.
            BufferedImage bufferedImage = new BufferedImage(reImagem.getWidth(null), reImagem.getHeight(null), BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(reImagem, 0, 0, null);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            try {
                ImageIO.write(bufferedImage, "jpg", stream);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Formato nao correspontente");
            }

        }
        */

    }//GEN-LAST:event_buscarImagemActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdemPorNumeroDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdemPorNumeroDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdemPorNumeroDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdemPorNumeroDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdemPorNumeroDeNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JImagem;
    private javax.swing.JButton buscarImagem;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelImagem;
    private javax.swing.JTable tbAvaliacaoNota;
    // End of variables declaration//GEN-END:variables
}
