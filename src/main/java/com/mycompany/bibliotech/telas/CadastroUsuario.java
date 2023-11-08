package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.model.bean.Usuario;
import com.mycompany.bibliotech.dao.UsuarioCadastroDAO;
import com.mycompany.bibliotech.dao.EnderecoDAO;
import com.mycompany.bibliotech.model.bean.Endereco;
import com.mycompany.bibliotech.dao.TelefoneDAO;
import com.mycompany.bibliotech.model.bean.Telefone;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

public class CadastroUsuario extends javax.swing.JFrame {

    public CadastroUsuario() {
        initComponents();
        listarCategorias1();
        listarCategorias2();
    }

    public void setBairroTxt(JTextField bairroTxt) {
        this.bairroTxt = bairroTxt;
    }

    public void setCargoBox(JComboBox<String> cargoBox) {
        this.cargoBox = cargoBox;
    }

    public void setCepTxt(JTextField cepTxt) {
        this.cepTxt = cepTxt;
    }

    public void setCidadeTxt(JTextField cidadeTxt) {
        this.cidadeTxt = cidadeTxt;
    }

    public void setCpfTxt(JTextField cpfTxt) {
        this.cpfTxt = cpfTxt;
    }

    public void setDataNascChooser(JDateChooser dataNascChooser) {
        this.dataNascChooser = dataNascChooser;
    }

    public void setEmailTxt(JTextField emailTxt) {
        this.emailTxt = emailTxt;
    }

    public void setEndTxt(JTextField endTxt) {
        this.endTxt = endTxt;
    }

    public void setEnterButton(JButton enterButton) {
        this.enterButton = enterButton;
    }

    public void setFoneTxt(JTextField foneTxt) {
        this.foneTxt = (JFormattedTextField) foneTxt;
    }

    public void setjCalendar1(JCalendar jCalendar1) {
        this.jCalendar1 = jCalendar1;
    }

    public void setjCalendar2(JCalendar jCalendar2) {
        this.jCalendar2 = jCalendar2;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public void setjFrame1(JFrame jFrame1) {
        this.jFrame1 = jFrame1;
    }

    public void setjFrame2(JFrame jFrame2) {
        this.jFrame2 = jFrame2;
    }

    public void setNickTxt(JTextField nickTxt) {
        this.nickTxt = nickTxt;
    }

    public void setNomeTxt(JTextField nomeTxt) {
        this.nomeTxt = nomeTxt;
    }

    public void setResenhaTxt(JPasswordField resenhaTxt) {
        this.resenhaTxt = resenhaTxt;
    }

    public void setSenhaTxt(JPasswordField senhaTxt) {
        this.senhaTxt = senhaTxt;
    }

    public void setSexoBox(JComboBox<String> sexoBox) {
        this.sexoBox = sexoBox;
    }

    public void setSobrenomeTxt(JTextField sobrenomeTxt) {
        this.sobrenomeTxt = sobrenomeTxt;
    }

    public void setUfTxt(JTextField ufTxt) {
        this.ufTxt = ufTxt;
    }

    public JTextField getBairroTxt() {
        return bairroTxt;
    }

    public JComboBox<String> getCargoBox() {
        return cargoBox;
    }

    public JTextField getCepTxt() {
        return cepTxt;
    }

    public JTextField getCidadeTxt() {
        return cidadeTxt;
    }

    public JTextField getCpfTxt() {
        return cpfTxt;
    }

    public JDateChooser getDataNascChooser() {
        return dataNascChooser;
    }

    public JTextField getEmailTxt() {
        return emailTxt;
    }

    public JTextField getEndTxt() {
        return endTxt;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public JFormattedTextField getFoneTxt() {
        return foneTxt;
    }

    public JCalendar getjCalendar1() {
        return jCalendar1;
    }

    public JCalendar getjCalendar2() {
        return jCalendar2;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public JFrame getjFrame1() {
        return jFrame1;
    }

    public JFrame getjFrame2() {
        return jFrame2;
    }

    public JTextField getNickTxt() {
        return nickTxt;
    }

    public JTextField getNomeTxt() {
        return nomeTxt;
    }

    public JPasswordField getResenhaTxt() {
        return resenhaTxt;
    }

    public JPasswordField getSenhaTxt() {
        return senhaTxt;
    }

    public JComboBox<String> getSexoBox() {
        return sexoBox;
    }

    public JTextField getSobrenomeTxt() {
        return sobrenomeTxt;
    }

    public JTextField getUfTxt() {
        return ufTxt;
    }

    public JTextField getCompTxt() {
        return compTxt;
    }

    public void setCompTxt(JTextField compTxt) {
        this.compTxt = compTxt;
    }

    public JTextField getNumTxt() {
        return numTxt;
    }

    public void setNumTxt(JTextField numTxt) {
        this.numTxt = numTxt;
    }

    public JTextField getPaisTxt() {
        return paisTxt;
    }

    public void setPaisTxt(JTextField paisTxt) {
        this.paisTxt = paisTxt;
    }

    public JComboBox<String> getTelefoneTipoBox() {
        return telefoneTipoBox;
    }

    public void setTelefoneTipoBox(JComboBox<String> telefoneTipoBox) {
        this.telefoneTipoBox = telefoneTipoBox;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        campoCentral = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cboxCategoria2 = new javax.swing.JComboBox<>();
        cboxSubCategoria2 = new javax.swing.JComboBox<>();
        cboxCategoria1 = new javax.swing.JComboBox<>();
        cboxSubCategoria1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        endTxt = new javax.swing.JTextField();
        ufTxt = new javax.swing.JTextField();
        bairroTxt = new javax.swing.JTextField();
        cidadeTxt = new javax.swing.JTextField();
        cepTxt = new javax.swing.JTextField();
        paisTxt = new javax.swing.JTextField();
        numTxt = new javax.swing.JTextField();
        compTxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        senhaTxt = new javax.swing.JPasswordField();
        cpfTxt = new javax.swing.JTextField();
        sexoBox = new javax.swing.JComboBox<>();
        sobrenomeTxt = new javax.swing.JTextField();
        enterButton = new javax.swing.JButton();
        nickTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        nomeTxt = new javax.swing.JTextField();
        cargoBox = new javax.swing.JComboBox<>();
        dataNascChooser = new com.toedter.calendar.JDateChooser();
        resenhaTxt = new javax.swing.JPasswordField();
        telefoneTipoBox = new javax.swing.JComboBox<>();
        foneTxt = new javax.swing.JFormattedTextField();
        menuLateral = new javax.swing.JPanel();
        txtMenuPrincipal = new javax.swing.JTextField();
        CadUserButton = new javax.swing.JButton();
        CadLivroButton = new javax.swing.JButton();
        btnEncerrarSessao = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campoCentral.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboxCategoria2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxCategoria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxCategoria2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria 2 *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoria2ActionPerformed(evt);
            }
        });

        cboxSubCategoria2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSubCategoria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxSubCategoria2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sub-categoria 2 *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxSubCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSubCategoria2ActionPerformed(evt);
            }
        });

        cboxCategoria1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxCategoria1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria 1 *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoria1ActionPerformed(evt);
            }
        });

        cboxSubCategoria1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSubCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxSubCategoria1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sub-categoria 1 *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxSubCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSubCategoria1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboxCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxSubCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboxCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxSubCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxSubCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxSubCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(514, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tipos de livro favorito", jPanel2);

        endTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        endTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        endTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTxtActionPerformed(evt);
            }
        });

        ufTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ufTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        ufTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufTxtActionPerformed(evt);
            }
        });

        bairroTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bairroTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bairro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        bairroTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroTxtActionPerformed(evt);
            }
        });

        cidadeTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cidadeTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        cidadeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeTxtActionPerformed(evt);
            }
        });

        cepTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cepTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CEP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        cepTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepTxtActionPerformed(evt);
            }
        });

        paisTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paisTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "País", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        paisTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisTxtActionPerformed(evt);
            }
        });

        numTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        numTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numTxtActionPerformed(evt);
            }
        });

        compTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        compTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complemento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        compTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cepTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paisTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cidadeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ufTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(numTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cepTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paisTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ufTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(392, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro endereço", jPanel3);

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        senhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        senhaTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        senhaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaTxtActionPerformed(evt);
            }
        });

        cpfTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cpfTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        cpfTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfTxtActionPerformed(evt);
            }
        });

        sexoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASC", "FEM", "OUTRO" }));
        sexoBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));
        sexoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoBoxActionPerformed(evt);
            }
        });

        sobrenomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sobrenomeTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sobrenome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        sobrenomeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobrenomeTxtActionPerformed(evt);
            }
        });

        enterButton.setText("Cadastrar");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        nickTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nickTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nickname", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        nickTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickTxtActionPerformed(evt);
            }
        });

        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        nomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomeTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        nomeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTxtActionPerformed(evt);
            }
        });

        cargoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "BIBLIOTECARIO", "CLIENTE" }));
        cargoBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        cargoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargoBoxActionPerformed(evt);
            }
        });

        dataNascChooser.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Nascimento"));
        dataNascChooser.setToolTipText("2004-08-07");
        dataNascChooser.setDateFormatString("yyyy-MM-dd");

        resenhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resenhaTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Re-Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        resenhaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resenhaTxtActionPerformed(evt);
            }
        });

        telefoneTipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "COMERCIAL", "CELULAR" }));
        telefoneTipoBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de número"));
        telefoneTipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTipoBoxActionPerformed(evt);
            }
        });

        foneTxt.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));
        try {
            foneTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        foneTxt.setText("(  )      -    ");
        foneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foneTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(telefoneTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(foneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 332, Short.MAX_VALUE)
                                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resenhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sobrenomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sexoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nickTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataNascChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sobrenomeTxt)
                    .addComponent(sexoBox, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nickTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(telefoneTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resenhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );

        jTabbedPane1.addTab("Cadastro usuario", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout campoCentralLayout = new javax.swing.GroupLayout(campoCentral);
        campoCentral.setLayout(campoCentralLayout);
        campoCentralLayout.setHorizontalGroup(
            campoCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campoCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(580, Short.MAX_VALUE))
        );
        campoCentralLayout.setVerticalGroup(
            campoCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(campoCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );

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
                        .addComponent(btnEncerrarSessao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 557, Short.MAX_VALUE)
                .addComponent(btnEncerrarSessao)
                .addGap(15, 15, 15))
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
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed

        Usuario user = new Usuario();
        Endereco end = new Endereco();
        Telefone tel = new Telefone();
        UsuarioCadastroDAO dao = new UsuarioCadastroDAO();
        EnderecoDAO enddao = new EnderecoDAO();
        TelefoneDAO fonedao = new TelefoneDAO();

        user.setUserNick(nickTxt.getText());
        user.setUserSenha(new String(senhaTxt.getPassword()));
        
        String valorUserCargo = cargoBox.getSelectedItem().toString();
        String valorSelecionado = "CLIENTE";

        if (valorUserCargo.equals("ADMIN")) {
            valorSelecionado = "ADMIN";
        } else if (valorUserCargo.equals("BIBLIOTECARIO")) {
            valorSelecionado = "BIBLIOTECARIO";
        } else {
            valorSelecionado = "CLIENTE";
        }

        user.setUserType(valorSelecionado);
        
        user.setUserNome(nomeTxt.getText());
        user.setUserSobrenome(sobrenomeTxt.getText());
        user.setUserDataNasc(dataNascChooser.getDate());
        user.setUserEmail(emailTxt.getText());
        
        String valorUserSexo = sexoBox.getSelectedItem().toString();
        String valorSelecionad = "OUTRO";

        if (valorUserSexo.equals("MASC")) {
            valorSelecionad = "MASC";
        } else if (valorUserSexo.equals("FEM")) {
            valorSelecionad = "FEM";
        } else {
            valorSelecionad = "OUTRO";
        }
        user.setUserSexo(valorSelecionad);

        String valorTipo = telefoneTipoBox.getSelectedItem().toString();
        String valorSelecionada = "CELULAR";

        if (valorTipo.equals("CELULAR")) {
            valorSelecionada = "CELULAR";
        } else if (valorTipo.equals("COMERCIAL")) {
            valorSelecionada = "COMERCIAL";
        } else {
            valorSelecionada = "RESIDENCIAL";
        }
        tel.setTipo(valorSelecionada);
        tel.setTelefone(foneTxt.getText());
        
        end.setCep(cepTxt.getText());
        end.setPais(paisTxt.getText());
        end.setRua(endTxt.getText());
        end.setUf(ufTxt.getText());
        end.setComp(compTxt.getText());
        end.setCidade(cidadeTxt.getText());
        
        String text = numTxt.getText();
        int numb = 0;
        try {
                    numb = Integer.parseInt(text);
                    } catch (NumberFormatException e) {
            }
        end.setNum(numb);
        end.setBairro(bairroTxt.getText());
        user.setUserType(valorSelecionado);
        user.setUserCpf(cpfTxt.getText());
        
        dao.cadastrarUsuario(user);
        enddao.cadastrarEndereco(end, nickTxt.getText(), cepTxt.getText(), numb);
        fonedao.cadastrarTelefone(tel, nickTxt.getText(), foneTxt.getText(), telefoneTipoBox.getSelectedItem().toString());
        

    }//GEN-LAST:event_enterButtonActionPerformed

    private void nickTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickTxtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_nickTxtActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void nomeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTxtActionPerformed

    private void cargoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cargoBoxActionPerformed

    private void resenhaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resenhaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resenhaTxtActionPerformed

    private void senhaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaTxtActionPerformed

    private void cpfTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfTxtActionPerformed

    private void sexoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoBoxActionPerformed

    private void sobrenomeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobrenomeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sobrenomeTxtActionPerformed

    private void CadUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadUserButtonActionPerformed
        new CadastroUsuario().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadUserButtonActionPerformed

    private void CadLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadLivroButtonActionPerformed
        new CadastroDeLivros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadLivroButtonActionPerformed

    private void btnEncerrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarSessaoActionPerformed
        // TODO add your handling code here:
        new TelaDeLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEncerrarSessaoActionPerformed

    private void endTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endTxtActionPerformed

    private void ufTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ufTxtActionPerformed

    private void bairroTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroTxtActionPerformed

    private void cidadeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeTxtActionPerformed

    private void cepTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cepTxtActionPerformed

    private void cboxCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoria2ActionPerformed
        // Executar após o clique final na ComboBox
        String dados[] = String.valueOf(cboxCategoria2.getSelectedItem()).split(" - ");
        if (!dados[0].equalsIgnoreCase("Não Informada")) {
            cboxSubCategoria2.removeAllItems();
            cboxSubCategoria2.addItem("Não Informada");
            listarSubCategoria2(dados[0]);

        } else {
            cboxSubCategoria2.removeAllItems();
            cboxSubCategoria2.addItem("Não Informada");
        }
    }//GEN-LAST:event_cboxCategoria2ActionPerformed

    private void cboxSubCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSubCategoria2ActionPerformed

    }//GEN-LAST:event_cboxSubCategoria2ActionPerformed

    private void cboxCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoria1ActionPerformed
        // TODO add your handling code here:
                String dados[] = String.valueOf(cboxCategoria1.getSelectedItem()).split(" - ");
        if (!dados[0].equalsIgnoreCase("Não Informada")) {
            cboxSubCategoria1.removeAllItems();
            cboxSubCategoria1.addItem("Não Informada");
            listarSubCategoria1(dados[0]);

        } else {
            cboxSubCategoria1.removeAllItems();
            cboxSubCategoria1.addItem("Não Informada");
        }
    }//GEN-LAST:event_cboxCategoria1ActionPerformed

    private void cboxSubCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSubCategoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxSubCategoria1ActionPerformed

    private void paisTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paisTxtActionPerformed

    private void numTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numTxtActionPerformed

    private void compTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compTxtActionPerformed

    private void telefoneTipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTipoBoxActionPerformed

    }//GEN-LAST:event_telefoneTipoBoxActionPerformed

    private void foneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foneTxtActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_foneTxtActionPerformed

    
        public void listarCategorias1() {
        LivroCategoriaDAO.listarCategorias(cboxCategoria1);
    }

    public void listarSubCategoria1(String idCategoria) {
        LivroCategoriaDAO.listarSubCategoria(cboxSubCategoria1, idCategoria);
    }
    
        public void listarCategorias2() {
        LivroCategoriaDAO.listarCategorias(cboxCategoria2);
    }

    public void listarSubCategoria2(String idCategoria) {
        LivroCategoriaDAO.listarSubCategoria(cboxSubCategoria2, idCategoria);
    }
    
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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadLivroButton;
    private javax.swing.JButton CadUserButton;
    private javax.swing.JTextField bairroTxt;
    private javax.swing.JButton btnEncerrarSessao;
    private javax.swing.JPanel campoCentral;
    private javax.swing.JComboBox<String> cargoBox;
    private javax.swing.JComboBox<String> cboxCategoria1;
    private javax.swing.JComboBox<String> cboxCategoria2;
    private javax.swing.JComboBox<String> cboxSubCategoria1;
    private javax.swing.JComboBox<String> cboxSubCategoria2;
    private javax.swing.JTextField cepTxt;
    private javax.swing.JTextField cidadeTxt;
    private javax.swing.JTextField compTxt;
    private javax.swing.JTextField cpfTxt;
    private com.toedter.calendar.JDateChooser dataNascChooser;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField endTxt;
    private javax.swing.JButton enterButton;
    private javax.swing.JFormattedTextField foneTxt;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JTextField nickTxt;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField numTxt;
    private javax.swing.JTextField paisTxt;
    private javax.swing.JPasswordField resenhaTxt;
    private javax.swing.JPasswordField senhaTxt;
    private javax.swing.JComboBox<String> sexoBox;
    private javax.swing.JTextField sobrenomeTxt;
    private javax.swing.JComboBox<String> telefoneTipoBox;
    private javax.swing.JTextField txtMenuPrincipal;
    private javax.swing.JTextField ufTxt;
    // End of variables declaration//GEN-END:variables
}
