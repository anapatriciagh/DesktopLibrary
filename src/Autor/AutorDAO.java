/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autor;

import Conexao.Conexao;
import Publicacao.Publicacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Ana PAtrícia
 */
public class AutorDAO {
    //Salva o autor de uma publicação
    public void salvarAutordaPublicacao(Publicacao publicacao) throws SQLException{
        String sql = "insert into autor values (default,?)";
        for(int i = 0; i < publicacao.getAutores().size(); i++){
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, publicacao.getAutores().get(i).getNome());
            ps.executeUpdate();
            Conexao.getConexao().close();
        }
    }
    //Pesquisar autor pelo nome no banco de dados e retorna-o
    public Autor pesquisarAutor(String nome) throws SQLException{
        String sql = "select * from autor where nome_autor = '" + nome + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        Autor autor = new Autor();
        while(resultado.next()){
            autor.setCodigoAutor(resultado.getInt("id_autor"));
            autor.setNome(resultado.getString("nome_autor"));
        }
        Conexao.getConexao().close();
        System.out.println(autor);
        return autor;
    }
}
