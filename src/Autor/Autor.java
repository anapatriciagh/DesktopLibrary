/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autor;

import Publicacao.Publicacao;
import java.sql.SQLException;


/**
 *
 * @author Ana PAtrícia
 */
public class Autor {
    private int codigoAutor;
    private String nome;

    public Autor(int codigoAutor, String nome) {
        this.codigoAutor = codigoAutor;
        this.nome = nome;
    }
    public Autor(){}
    
    @Override
    public String toString() {
        return "Autor{" + "codigoAutor=" + codigoAutor + ", nome=" + nome + '}';
    }

    public int getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(int codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
    public void salvarAutordaPublicacao(Publicacao publicacao) throws SQLException{
        AutorDAO autorDAO = new AutorDAO();
        autorDAO.salvarAutordaPublicacao(publicacao);
    }
}
