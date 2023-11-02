package com.mycompany.bibliotech.model.bean;

public class Avaliacao {

    private int id;
    private String avaliacaoDoUsuario;
    private String avaliacaoTotal;
    private String comentarioAvaliacao;
    private String dataDeAvaliacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvaliacaoDoUsuario() {
        return avaliacaoDoUsuario;
    }

    public void setAvaliacaoDoUsuario(String avaliacaoDoUsuario) {
        this.avaliacaoDoUsuario = avaliacaoDoUsuario;
    }

    public String getAvaliacaoTotal() {
        return avaliacaoTotal;
    }

    public void setAvaliacaoTotal(String avaliacaoTotal) {
        this.avaliacaoTotal = avaliacaoTotal;
    }

    public String getComentarioAvaliacao() {
        return comentarioAvaliacao;
    }

    public void setComentarioAvaliacao(String comentarioAvaliacao) {
        this.comentarioAvaliacao = comentarioAvaliacao;
    }

    public String getDataDeAvaliacao() {
        return dataDeAvaliacao;
    }

    public void setDataDeAvaliacao(String dataDeAvaliacao) {
        this.dataDeAvaliacao = dataDeAvaliacao;
    }

}
