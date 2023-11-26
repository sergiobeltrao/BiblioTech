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
    private int txtPaginas;
    private int txtAno;
    private String txtEditora;
    private String txtComentario;
    private String txtIdioma;
    private String txtIsbn;
    private String txtNomeLivro;
    private String  txtNotaMax;

    public String getTxtNomeLivro() {
        return txtNomeLivro;
    }

    public void setTxtNomeLivro(String txtNomeLivro) {
        this.txtNomeLivro = txtNomeLivro;
    }

    public String getTxtNotaMax() {
        return txtNotaMax;
    }

    public void setTxtNotaMax(String txtNotaMax) {
        this.txtNotaMax = txtNotaMax;
    }

    public Avaliacao(String txtNomeLivro) {
        this.txtNomeLivro = txtNomeLivro;
    }

    public String getTxtIdioma() {
        return txtIdioma;
    }

    public void setTxtIdioma(String txtIdioma) {
        this.txtIdioma = txtIdioma;
    }

    public String getTxtIsbn() {
        return txtIsbn;
    }

    public void setTxtIsbn(String txtIsbn) {
        this.txtIsbn = txtIsbn;
    }

    public Avaliacao(String txtIdioma, String txtIsbn) {
        this.txtIdioma = txtIdioma;
        this.txtIsbn = txtIsbn;
    }

    public Avaliacao() {
    }

    public Avaliacao(int livroAvaliado, String avaliacaoDoUsuario, String avaliacaoTotal, String comentarioAvaliacao, String dataDeAvaliacao, String usuarioQueAvaliou, String txtBuscaCad, String txtBuscaAlfa, String txtBuscaLivro, String txtNomeAutor, int txtPaginas, int txtAno, String txtEditora, String txtComentario) {
        this.livroAvaliado = livroAvaliado;
        this.avaliacaoDoUsuario = avaliacaoDoUsuario;
        this.avaliacaoTotal = avaliacaoTotal;
        this.comentarioAvaliacao = comentarioAvaliacao;
        this.dataDeAvaliacao = dataDeAvaliacao;
        this.usuarioQueAvaliou = usuarioQueAvaliou;
        this.txtBuscaCad = txtBuscaCad;
        this.txtBuscaAlfa = txtBuscaAlfa;
        this.txtBuscaLivro = txtBuscaLivro;
        this.txtNomeAutor = txtNomeAutor;
        this.txtPaginas = txtPaginas;
        this.txtAno = txtAno;
        this.txtEditora = txtEditora;
        this.txtComentario = txtComentario;
    }

     
    
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

    public int getTxtPaginas() {
        return txtPaginas;
    }

    public void setTxtPaginas(int txtPaginas) {
        this.txtPaginas = txtPaginas;
    }

    public int getTxtAno() {
        return txtAno;
    }

    public void setTxtAno(int txtAno) {
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
