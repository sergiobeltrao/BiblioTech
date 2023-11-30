package com.mycompany.bibliotech.telas;

import com.mycompany.bibliotech.dao.LivroCategoriaDAO;
import com.mycompany.bibliotech.model.bean.Usuario;
import com.mycompany.bibliotech.dao.UsuarioCadastroDAO;
import com.mycompany.bibliotech.dao.EnderecoDAO;
import com.mycompany.bibliotech.model.bean.Endereco;
import com.mycompany.bibliotech.dao.TelefoneDAO;
import com.mycompany.bibliotech.model.bean.Telefone;
import com.mycompany.bibliotech.dao.FavoritosDAO;
import com.mycompany.bibliotech.model.bean.Favoritos;
import com.mycompany.bibliotech.dao.CpfDAO;
import com.mycompany.bibliotech.dao.ExcluirUserDAO;
import com.mycompany.bibliotech.model.bean.Avaliacao;
import com.mycompany.bibliotech.model.bean.Hash;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.text.MaskFormatter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void setCidadeTxt(JTextField cidadeTxt) {
        this.cidadeTxt = cidadeTxt;
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

    public JTextField getCidadeTxt() {
        return cidadeTxt;
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

    public JFormattedTextField getCepTxt() {
        return cepTxt;
    }

    public void setCepTxt(JFormattedTextField cepTxt) {
        this.cepTxt = cepTxt;
    }

    public JFormattedTextField getCpfTxt() {
        return cpfTxt;
    }

    public void setCpfTxt(JFormattedTextField cpfTxt) {
        this.cpfTxt = cpfTxt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cadastroUsuario = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        ProxCadEndButton = new javax.swing.JButton();
        avisoLabel = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        sobrenomeTxt = new javax.swing.JTextField();
        nickTxt = new javax.swing.JTextField();
        dataNascChooser = new com.toedter.calendar.JDateChooser();
        cpfTxt = new javax.swing.JFormattedTextField();
        foneTxt = new javax.swing.JFormattedTextField();
        telefoneTipoBox = new javax.swing.JComboBox<>();
        sexoBox = new javax.swing.JComboBox<>();
        emailTxt = new javax.swing.JTextField();
        cargoBox = new javax.swing.JComboBox<>();
        senhaTxt = new javax.swing.JPasswordField();
        resenhaTxt = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        endTxt = new javax.swing.JTextField();
        ufTxt = new javax.swing.JTextField();
        bairroTxt = new javax.swing.JTextField();
        cidadeTxt = new javax.swing.JTextField();
        paisTxt = new javax.swing.JTextField();
        numTxt = new javax.swing.JTextField();
        compTxt = new javax.swing.JTextField();
        ProxCadLivButton = new javax.swing.JButton();
        cepTxt = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        cboxCategoria2 = new javax.swing.JComboBox<>();
        cboxSubCategoria2 = new javax.swing.JComboBox<>();
        cboxCategoria1 = new javax.swing.JComboBox<>();
        cboxSubCategoria1 = new javax.swing.JComboBox<>();
        enterButton = new javax.swing.JButton();
        LimparButton = new javax.swing.JButton();
        MenuPainel = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        menu = new javax.swing.JLabel();
        edicaoUserButton1 = new javax.swing.JButton();
        CadLivroButton1 = new javax.swing.JButton();
        AvaButton1 = new javax.swing.JButton();
        ExcluirUserButton1 = new javax.swing.JToggleButton();
        btnEncerrarSessao1 = new javax.swing.JButton();
        btnEdicaoDeLivro = new javax.swing.JButton();
        txtMenu = new javax.swing.JButton();

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
        setTitle("Cadastrar Usuarios");

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setkGradientFocus(350);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        ProxCadEndButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ProxCadEndButton.setForeground(new java.awt.Color(0, 0, 0));
        ProxCadEndButton.setText("Próxima ");
        ProxCadEndButton.setToolTipText("ir para proxima aba");
        ProxCadEndButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProxCadEndButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProxCadEndButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProxCadEndButtonActionPerformed(evt);
            }
        });

        avisoLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        avisoLabel.setForeground(new java.awt.Color(0, 0, 0));
        avisoLabel.setText("Itens preenchidos com * são obrigatórios!!");

        nomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomeTxt.setForeground(new java.awt.Color(0, 0, 0));
        nomeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeTxt.setToolTipText("insira o nome do usuario");
        nomeTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nomeTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nomeTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nomeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTxtActionPerformed(evt);
            }
        });

        sobrenomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        sobrenomeTxt.setForeground(new java.awt.Color(0, 0, 0));
        sobrenomeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sobrenomeTxt.setToolTipText("insira sobrenome completo");
        sobrenomeTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        sobrenomeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobrenomeTxtActionPerformed(evt);
            }
        });

        nickTxt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        nickTxt.setForeground(new java.awt.Color(0, 0, 0));
        nickTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nickTxt.setToolTipText("escolha o nick name");
        nickTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nickTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickTxtActionPerformed(evt);
            }
        });

        dataNascChooser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        dataNascChooser.setForeground(new java.awt.Color(0, 0, 0));
        dataNascChooser.setToolTipText("2004-08-07");
        dataNascChooser.setDateFormatString("yyyy-MM-dd");

        cpfTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cpfTxt.setForeground(new java.awt.Color(0, 0, 0));
        try {
            cpfTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpfTxt.setToolTipText("Digite o CPF:");
        cpfTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfTxtActionPerformed(evt);
            }
        });

        foneTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        foneTxt.setForeground(new java.awt.Color(0, 0, 0));
        try {
            foneTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        foneTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        foneTxt.setToolTipText("insira numero do seu telefone.");
        foneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foneTxtActionPerformed(evt);
            }
        });

        telefoneTipoBox.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        telefoneTipoBox.setForeground(new java.awt.Color(0, 0, 0));
        telefoneTipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESIDENCIAL", "COMERCIAL", "CELULAR" }));
        telefoneTipoBox.setToolTipText("Escolhao tipo de telefone.");
        telefoneTipoBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        telefoneTipoBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        telefoneTipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTipoBoxActionPerformed(evt);
            }
        });

        sexoBox.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        sexoBox.setForeground(new java.awt.Color(0, 0, 0));
        sexoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASC", "FEM", "OUTRO" }));
        sexoBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        sexoBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sexoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoBoxActionPerformed(evt);
            }
        });

        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(0, 0, 0));
        emailTxt.setToolTipText("Insira o email");
        emailTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        cargoBox.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cargoBox.setForeground(new java.awt.Color(0, 0, 0));
        cargoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "CLIENTE" }));
        cargoBox.setToolTipText("escolha o tipo de usuario");
        cargoBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cargoBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargoBoxActionPerformed(evt);
            }
        });

        senhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        senhaTxt.setForeground(new java.awt.Color(0, 0, 0));
        senhaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        senhaTxt.setToolTipText("Escolha uma senha unica para o usuario");
        senhaTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        senhaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaTxtActionPerformed(evt);
            }
        });

        resenhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        resenhaTxt.setForeground(new java.awt.Color(0, 0, 0));
        resenhaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resenhaTxt.setToolTipText("escolha a mesma senha");
        resenhaTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        resenhaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resenhaTxtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Re-escreva a senha:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Sobrenome:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nick Name:");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Numero telefone:");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Qual o tipo:");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Digite CPF:");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Email:");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Data de nascimento:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Escolha o tipo de usuario:");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Sexo:");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Senha:");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avisoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cpfTxt)
                        .addComponent(nickTxt)
                        .addComponent(nomeTxt)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(senhaTxt)
                        .addComponent(jLabel12)
                        .addComponent(cargoBox, 0, 236, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataNascChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(foneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(sobrenomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                            .addComponent(resenhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProxCadEndButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avisoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sobrenomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel10)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cargoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resenhaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProxCadEndButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cadastroUsuario.addTab("Cadastro usuario", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

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

        ProxCadLivButton.setText("Próxima Aba");
        ProxCadLivButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProxCadLivButtonActionPerformed(evt);
            }
        });

        cepTxt.setBorder(javax.swing.BorderFactory.createTitledBorder("CEP"));
        try {
            cepTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(bairroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(ProxCadLivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(497, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paisTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addComponent(ProxCadLivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        cadastroUsuario.addTab("Cadastro endereço", jPanel3);

        cboxCategoria2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxCategoria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxCategoria2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria 2 ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoria2ActionPerformed(evt);
            }
        });

        cboxSubCategoria2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSubCategoria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxSubCategoria2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sub-categoria 2 ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxSubCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSubCategoria2ActionPerformed(evt);
            }
        });

        cboxCategoria1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxCategoria1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria 1 ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoria1ActionPerformed(evt);
            }
        });

        cboxSubCategoria1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboxSubCategoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Informada" }));
        cboxSubCategoria1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sub-categoria 1 ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        cboxSubCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSubCategoria1ActionPerformed(evt);
            }
        });

        enterButton.setText("Cadastrar");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        LimparButton.setText("Limpar");
        LimparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparButtonActionPerformed(evt);
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
                        .addComponent(cboxSubCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LimparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(485, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LimparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(524, Short.MAX_VALUE))
        );

        cadastroUsuario.addTab("Tipos de livro favorito", jPanel2);

        MenuPainel.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel2.setkGradientFocus(350);
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        menu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menu.setForeground(new java.awt.Color(0, 0, 0));
        menu.setText("Menu");
        menu.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        menu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));

        edicaoUserButton1.setBackground(new java.awt.Color(102, 102, 102));
        edicaoUserButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        edicaoUserButton1.setText("Edição de Usuario");
        edicaoUserButton1.setToolTipText("Editar usuario existente");
        edicaoUserButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        edicaoUserButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edicaoUserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edicaoUserButton1ActionPerformed(evt);
            }
        });

        CadLivroButton1.setBackground(new java.awt.Color(102, 102, 102));
        CadLivroButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CadLivroButton1.setText("Cadastro de Livro");
        CadLivroButton1.setToolTipText("Cadastrar novos livros");
        CadLivroButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CadLivroButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CadLivroButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadLivroButton1ActionPerformed(evt);
            }
        });

        AvaButton1.setBackground(new java.awt.Color(102, 102, 102));
        AvaButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AvaButton1.setText("Avaliação");
        AvaButton1.setToolTipText("Inserir Avaliação de livro");
        AvaButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        AvaButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AvaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvaButton1ActionPerformed(evt);
            }
        });

        ExcluirUserButton1.setBackground(new java.awt.Color(102, 102, 102));
        ExcluirUserButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ExcluirUserButton1.setText("Excluir Usuarios");
        ExcluirUserButton1.setToolTipText("Excluir usuarios inativos");
        ExcluirUserButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ExcluirUserButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExcluirUserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirUserButton1ActionPerformed(evt);
            }
        });

        btnEncerrarSessao1.setBackground(new java.awt.Color(102, 102, 102));
        btnEncerrarSessao1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEncerrarSessao1.setText("Encerrar Sessão");
        btnEncerrarSessao1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEncerrarSessao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarSessao1ActionPerformed(evt);
            }
        });

        btnEdicaoDeLivro.setBackground(new java.awt.Color(102, 102, 102));
        btnEdicaoDeLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEdicaoDeLivro.setText("Edição de Livro");
        btnEdicaoDeLivro.setToolTipText("Edição de livros existentes");
        btnEdicaoDeLivro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEdicaoDeLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdicaoDeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdicaoDeLivroActionPerformed(evt);
            }
        });

        txtMenu.setBackground(new java.awt.Color(102, 102, 102));
        txtMenu.setText("Inicio");
        txtMenu.setToolTipText("Ir para o Inicio");
        txtMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(menu))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CadLivroButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ExcluirUserButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEncerrarSessao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEdicaoDeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edicaoUserButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu)
                .addGap(21, 21, 21)
                .addComponent(txtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(edicaoUserButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(CadLivroButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnEdicaoDeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(AvaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ExcluirUserButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEncerrarSessao1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout MenuPainelLayout = new javax.swing.GroupLayout(MenuPainel);
        MenuPainel.setLayout(MenuPainelLayout);
        MenuPainelLayout.setHorizontalGroup(
            MenuPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MenuPainelLayout.setVerticalGroup(
            MenuPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
            .addComponent(MenuPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1294, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed

        Usuario user = new Usuario();
        Endereco end = new Endereco();
        Favoritos fav = new Favoritos();
        Telefone tel = new Telefone();
        UsuarioCadastroDAO dao = new UsuarioCadastroDAO();
        EnderecoDAO enddao = new EnderecoDAO();
        FavoritosDAO favdao = new FavoritosDAO();
        TelefoneDAO fonedao = new TelefoneDAO();
        String cpf = cpfTxt.getText();
        CpfDAO cpfdao = new CpfDAO(cpf);

        //Informações usuario
        Hash hash = new Hash();

        String senhaDigitada = senhaTxt.getText();
        String hashDaSenha = "";

        try {
            hashDaSenha = hash.geradorDeHash(senhaDigitada);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        Hash rehash = new Hash();

        String resenhaDigitada = resenhaTxt.getText();
        String rehashDaSenha = "";

        try {
            rehashDaSenha = rehash.geradorDeHash(resenhaDigitada);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!hashDaSenha.equals(rehashDaSenha)) {
            JOptionPane.showMessageDialog(this, "A senha e a re-senha não coincidem. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Não prossegue com o cadastro se as senhas não coincidirem
        }

        user.setUserNick(nickTxt.getText());
        user.setUserSenha(new String(hashDaSenha));

        String valorUserCargo = cargoBox.getSelectedItem().toString();
        String valorSelecionado = "CLIENTE";

        if (valorUserCargo.equals("ADMIN")) {
            valorSelecionado = "ADMIN";
        } else {
            valorSelecionado = "CLIENTE";
        }

        user.setUserType(valorSelecionado);

        user.setUserNome(nomeTxt.getText());
        user.setUserSobrenome(sobrenomeTxt.getText());
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

        // Informações telefone
        tel.setTipo(valorSelecionada);
        tel.setTelefone(foneTxt.getText());

        // Informações endereço
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

        // Informações favoritos
        String categoriaSelecionada = cboxCategoria1.getSelectedItem().toString();
        String subCategoriaSelecionada = cboxSubCategoria1.getSelectedItem().toString();
        fav.setFavCategoria1(categoriaSelecionada);
        fav.setFavSub1(subCategoriaSelecionada);
        String categoriaSelecionad = cboxCategoria2.getSelectedItem().toString();
        String subCategoriaSelecionad = cboxSubCategoria2.getSelectedItem().toString();
        fav.setFavCategoria2(categoriaSelecionad);
        fav.setFavSub2(subCategoriaSelecionad);

        // Obtém a data de nascimento do JDateChooser
        java.util.Date dataNascimentoUtil = dataNascChooser.getDate();

        //Verificadores de data e CPF:
        // Verifica se a data de nascimento é válida
        if (dataNascimentoUtil != null) {
            // Converte LocalDate para Date
            LocalDate localDateNascimento = dataNascimentoUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date dateNascimento = java.sql.Date.valueOf(localDateNascimento);

            LocalDate currentDate = LocalDate.now();

            if (localDateNascimento.isAfter(currentDate)) {
                JOptionPane.showMessageDialog(rootPane, "Data de nascimento não pode ser no futuro!");
                return; // Não prossegue com o cadastro se a data de nascimento for no futuro
            }

            user.setUserDataNasc(dateNascimento);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma data de nascimento válida!");
            return; // Não prossegue com o cadastro se a data de nascimento não foi selecionada
        }

        //Validador de CPF
        if (cpfdao.isCPF()) {
            user.setUserCpf(cpfTxt.getText());
        } else {
            JOptionPane.showMessageDialog(rootPane, "CPF inválido!!");
            return;
        }

        //Metodos de cadastro
        dao.cadastrarUsuario(user);
        enddao.cadastrarEndereco(end, nickTxt.getText(), cepTxt.getText(), numb);
        fonedao.cadastrarTelefone(tel, nickTxt.getText(), foneTxt.getText(), telefoneTipoBox.getSelectedItem().toString());
        favdao.favCreate(fav, nickTxt.getText());


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

    private void sexoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoBoxActionPerformed

    private void sobrenomeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobrenomeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sobrenomeTxtActionPerformed

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

    private void ProxCadEndButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProxCadEndButtonActionPerformed
        this.cadastroUsuario.setSelectedIndex(1);
    }//GEN-LAST:event_ProxCadEndButtonActionPerformed

    private void ProxCadLivButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProxCadLivButtonActionPerformed
        this.cadastroUsuario.setSelectedIndex(2);
    }//GEN-LAST:event_ProxCadLivButtonActionPerformed

    private void LimparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparButtonActionPerformed
        new CadastroUsuario().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LimparButtonActionPerformed

    private void cpfTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfTxtActionPerformed

    private void txtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMenuActionPerformed
        new TelaPrincipalAdministrador().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtMenuActionPerformed

    private void edicaoUserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edicaoUserButton1ActionPerformed

        UsuarioCadastroDAO userdao = new UsuarioCadastroDAO();
        Usuario user = new Usuario();
        Endereco endereco = new Endereco();
        Favoritos favoritos = new Favoritos();
        Telefone telefone = new Telefone();

        // Solicita o nome do usuário ao usuário
        String userNome = JOptionPane.showInputDialog(this, "Digite o nick do usuário a ser editado:", "Edição de Usuario", JOptionPane.QUESTION_MESSAGE);

        // Verifica se o usuário inseriu um nome
        if (userNome != null && !userNome.isEmpty()) {
            // Obtém o usuário com base no nome fornecido
            user = userdao.obterUsuarioPorNome(userNome);

            // Verifica se o usuário foi encontrado
            if (user.getUserId() != 0) {
                // Criar um JPanel personalizado com um JPasswordField
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Senha:");
                JPasswordField passwordField = new JPasswordField(10);
                panel.add(label);
                panel.add(passwordField);

                // Exibir o JOptionPane com o JPanel personalizado
                int result = JOptionPane.showOptionDialog(null, panel, "Digite a senha",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                // Verificar a resposta do JOptionPane
                if (result == JOptionPane.OK_OPTION) {
                    // Obtém a senha do usuário
                    char[] senhaDigitada = passwordField.getPassword();

                    // Verifica se a senha digitada coincide com a senha do banco
                    String senhaDoBanco = userdao.obterSenhaPorNome(userNome);
                    Hash rehash = new Hash();

                    try {
                        String senhaDigitadaHash = rehash.geradorDeHash(new String(senhaDigitada));
                        if (senhaDoBanco != null && senhaDoBanco.equals(senhaDigitadaHash)) {
                            // Abre a tela de edição com os dados do usuário
                            EdicaoUsuario edicaoUsuarioFrame = new EdicaoUsuario(user, endereco, telefone, favoritos);
                            edicaoUsuarioFrame.setVisible(true);
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NoSuchAlgorithmException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite um nome de usuário válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_edicaoUserButton1ActionPerformed

    private void CadLivroButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadLivroButton1ActionPerformed
        new CadastroDeLivros().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CadLivroButton1ActionPerformed

    private void AvaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvaButton1ActionPerformed
        Avaliacao avaliacao = new Avaliacao();
        new TelaAvaliacao(avaliacao).setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_AvaButton1ActionPerformed

    private void ExcluirUserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirUserButton1ActionPerformed

        ExcluirUserDAO ex = new ExcluirUserDAO();
        ex.mostrarEExcluirUsuario();
    }//GEN-LAST:event_ExcluirUserButton1ActionPerformed

    private void btnEncerrarSessao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarSessao1ActionPerformed
        // TODO add your handling code here:
        new TelaDeLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEncerrarSessao1ActionPerformed

    private void btnEdicaoDeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdicaoDeLivroActionPerformed
        new EdicaoDeLivro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEdicaoDeLivroActionPerformed

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
    private javax.swing.JButton AvaButton1;
    private javax.swing.JButton CadLivroButton1;
    private javax.swing.JToggleButton ExcluirUserButton1;
    private javax.swing.JButton LimparButton;
    private javax.swing.JPanel MenuPainel;
    private javax.swing.JButton ProxCadEndButton;
    private javax.swing.JButton ProxCadLivButton;
    private javax.swing.JLabel avisoLabel;
    private javax.swing.JTextField bairroTxt;
    private javax.swing.JButton btnEdicaoDeLivro;
    private javax.swing.JButton btnEncerrarSessao1;
    private javax.swing.JTabbedPane cadastroUsuario;
    private javax.swing.JComboBox<String> cargoBox;
    private javax.swing.JComboBox<String> cboxCategoria1;
    private javax.swing.JComboBox<String> cboxCategoria2;
    private javax.swing.JComboBox<String> cboxSubCategoria1;
    private javax.swing.JComboBox<String> cboxSubCategoria2;
    private javax.swing.JFormattedTextField cepTxt;
    private javax.swing.JTextField cidadeTxt;
    private javax.swing.JTextField compTxt;
    private javax.swing.JFormattedTextField cpfTxt;
    private com.toedter.calendar.JDateChooser dataNascChooser;
    private javax.swing.JButton edicaoUserButton1;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField endTxt;
    private javax.swing.JButton enterButton;
    private javax.swing.JFormattedTextField foneTxt;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel menu;
    private javax.swing.JTextField nickTxt;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField numTxt;
    private javax.swing.JTextField paisTxt;
    private javax.swing.JPasswordField resenhaTxt;
    private javax.swing.JPasswordField senhaTxt;
    private javax.swing.JComboBox<String> sexoBox;
    private javax.swing.JTextField sobrenomeTxt;
    private javax.swing.JComboBox<String> telefoneTipoBox;
    private javax.swing.JButton txtMenu;
    private javax.swing.JTextField ufTxt;
    // End of variables declaration//GEN-END:variables
}
