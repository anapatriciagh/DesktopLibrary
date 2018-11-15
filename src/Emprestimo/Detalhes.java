/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprestimo;

/**
 *
 * @author Ana PAtrícia
 */
public class Detalhes {
    private String tituloPublicacao;
    private String nome_autor;
    private int ano_publicacao;
    private String statusExemplar;
    

    public String getTituloPublicacao() {
        return tituloPublicacao;
    }

    public void setTituloPublicacao(String tituloPublicacao) {
        this.tituloPublicacao = tituloPublicacao;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getStatusExemplar() {
        return statusExemplar;
    }

    public void setStatusExemplar(String statusExemplar) {
        this.statusExemplar = statusExemplar;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    @Override
    public String toString() {
        return "Título  " + tituloPublicacao + "\nAutor  " + nome_autor + "\nAno  " + ano_publicacao + "\nStatus do Exemplar  " + statusExemplar;
    }
    
}
