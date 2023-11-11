package com.mycompany.bibliotech.model.bean;

public class Avaliacao {

    private int id;
    private int livroAvaliado;
    private String avaliacaoDoUsuario;
    private String avaliacaoTotal;
    private String comentarioAvaliacao;
    private String dataDeAvaliacao;
    private String usuarioQueAvaliou;
    private String txtBuscaCad;
    private String txtBuscaAlfa;
    private String txtBuscaLivro;
    private String txtNomeAutor;
    private String txtPaginas;
    private String txtAno;
    private String txtEditora;
    private String txtComentario;

    public String getTxtBuscaCad() {
        return txtBuscaCad;
    }

    public void setTxtBuscaCad(String txtBuscaCad) {
        this.txtBuscaCad = txtBuscaCad;
    }

    public String getTxtBuscaAlfa() {
        return txtBuscaAlfa;
    }

    public void setTxtBuscaAlfa(String txtBuscaAlfa) {
        this.txtBuscaAlfa = txtBuscaAlfa;
    }

    public String getTxtBuscaLivro() {
        return txtBuscaLivro;
    }

    public void setTxtBuscaLivro(String txtBuscaLivro) {
        this.txtBuscaLivro = txtBuscaLivro;
    }

    public String getTxtNomeAutor() {
        return txtNomeAutor;
    }

    public void setTxtNomeAutor(String txtNomeAutor) {
        this.txtNomeAutor = txtNomeAutor;
    }

    public String getTxtPaginas() {
        return txtPaginas;
    }

    public void setTxtPaginas(String txtPaginas) {
        this.txtPaginas = txtPaginas;
    }

    public String getTxtAno() {
        return txtAno;
    }

    public void setTxtAno(String txtAno) {
        this.txtAno = txtAno;
    }

    public String getTxtEditora() {
        return txtEditora;
    }

    public void setTxtEditora(String txtEditora) {
        this.txtEditora = txtEditora;
    }

    public String getTxtComentario() {
        return txtComentario;
    }

    public void setTxtComentario(String txtComentario) {
        this.txtComentario = txtComentario;
    }
          
    public int getLivroAvaliado() {
        return livroAvaliado;
    }

    public void setLivroAvaliado(int livroAvaliado) {
        this.livroAvaliado = livroAvaliado;
    }

    public String getUsuarioQueAvaliou() {
        return usuarioQueAvaliou;
    }

    public void setUsuarioQueAvaliou(String usuarioQueAvaliou) {
        this.usuarioQueAvaliou = usuarioQueAvaliou;
    }

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
