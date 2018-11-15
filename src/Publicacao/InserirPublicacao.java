/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicacao;

import Autor.Autor;
import Exemplar.Exemplar;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class InserirPublicacao {
    public static void main(String[] args) throws SQLException {
        //inserindo uma publicacao
        Publicacao publicacao = new Publicacao();
        publicacao.setTituloPublicacao("Senhora");
        publicacao.setAnoPublicacao(1870);
        publicacao.setIsbn("000-11-44333-00-5");
        publicacao.setEdicao("5ª");
        publicacao.setEditora("arqueiro");
        TipoPublicacao tipoPublicacao = new TipoPublicacao();
        tipoPublicacao.setDescricao("livro");
        publicacao.setTipoPublicacao(tipoPublicacao);
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        publicacao.getAutores().add(autor);
        Exemplar exemplar = new Exemplar();
        exemplar.setCodigoExemplar("1FF");
        publicacao.getExemplares().add(exemplar);
        System.out.println(publicacao);
        publicacao.salvar(publicacao);
        //metodosPublicacao.alterar(publicacao);
    }
}
