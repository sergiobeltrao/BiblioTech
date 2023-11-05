package com.mycompany.bibliotech.model.bean;

import java.util.Date;

public class Usuario {

    private int userId;
    private String userNick;
    private String userSenha;
    private String userType;
    private String userNome;
    private String userSobrenome;
    private String userSexo;
    private String userEmail;
    private Date userDataNasc;
    private String userCpf;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getUserSobrenome() {
        return userSobrenome;
    }

    public void setUserSobrenome(String userSobrenome) {
        this.userSobrenome = userSobrenome;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserSexo() {
        return userSexo;
    }

    public void setUserSexo(String userSexo) {
        this.userSexo = userSexo;
    }

    public Date getUserDataNasc() {
        return userDataNasc;
    }

    public void setUserDataNasc(Date userDataNasc) {
        this.userDataNasc = userDataNasc;
    }

    
}
