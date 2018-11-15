/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicacao;

import Autor.Autor;
import Exemplar.Exemplar;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ana PAtrícia
 */
public class Publicacao {
    private int codigoPublicacao;
    private String tituloPublicacao;
    private int anoPublicacao;
    private String editora;
    private String isbn;
    private String edicao;
    private TipoPublicacao tipoPublicacao;
    private ArrayList<Autor> autores = new ArrayList<>();
    private ArrayList<Exemplar> exemplares = new ArrayList<>();

    public Publicacao(int codigoPublicacao, String tituloPublicacao, int anoPublicacao, String editora, String isbn, String edicao, TipoPublicacao tipoPublicacao) {
        this.codigoPublicacao = codigoPublicacao;
        this.tituloPublicacao = tituloPublicacao;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.isbn = isbn;
        this.edicao = edicao;
        this.tipoPublicacao = tipoPublicacao;
    }
    public Publicacao(){}

    public int getCodigoPublicacao() {
        return codigoPublicacao;
    }

    public void setCodigoPublicacao(int codigoPublicacao) {
        this.codigoPublicacao = codigoPublicacao;
    }

    public String getTituloPublicacao() {
        return tituloPublicacao;
    }

    public void setTituloPublicacao(String tituloPublicacao) {
        this.tituloPublicacao = tituloPublicacao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public TipoPublicacao getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(TipoPublicacao tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return "Publicacao{" + "codigoPublicacao=" + codigoPublicacao + ", tituloPublicacao=" + tituloPublicacao + ", anoPublicacao=" + anoPublicacao + ", editora=" + editora + ", isbn=" + isbn + ", edicao=" + edicao + ", tipoPublicacao=" + tipoPublicacao + ", autores=" + autores + ", exemplares=" + exemplares + '}';
    }
  /*Recebe um uma publicacao e chama o método que a cadastra no banco de dados do sistema*/
    public void salvar(Publicacao publicacao) throws SQLException{
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
        publicacaoDAO.cadastrarPublicacao(publicacao);
    }
    /*Recebe um uma publicacao e chama o método que altera os dados necessários no banco de dados do sistema*/
     public void alterar(Publicacao publicacao) throws SQLException{
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
        publicacaoDAO.alterarPublicacao(publicacao);
    }
}
