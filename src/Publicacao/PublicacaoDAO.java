/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicacao;

import Autor.Autor;
import Autor.AutorDAO;
import Conexao.Conexao;
import Exemplar.ExemplarDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class PublicacaoDAO {
    /*insere uma publicacao no banco de dados, bem como seus autores e exemplares, chamando os métodos necessários*/
    public void cadastrarPublicacao(Publicacao publicacao) throws SQLException{
        String sql = "insert into publicacao values (default,?,?,?,?,?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, publicacao.getTituloPublicacao());
        ps.setInt(2, publicacao.getAnoPublicacao());
        ps.setString(3, publicacao.getIsbn());
        ps.setString(4, publicacao.getEditora());
        ps.setString(5, publicacao.getEdicao()); 
        TipoPublicacaoDAO tipoPublicacaoDAO = new TipoPublicacaoDAO();
        publicacao.setTipoPublicacao(tipoPublicacaoDAO.selecionarTipoPublicacaoPorNome(publicacao));
        ps.setInt(6, publicacao.getTipoPublicacao().getCodigoTipoPublicacao());
        ps.executeUpdate();
        Autor autor  = new Autor();
        autor.salvarAutordaPublicacao(publicacao);
        cadastrarAutorPublicacao(publicacao);
        ExemplarDAO exemplarDAO = new ExemplarDAO();
        exemplarDAO.salvarExemplardaPublicacao(publicacao);
        Conexao.getConexao().close();
    }
    /*Cadastra o autor de uma publicação*/
    public  void cadastrarAutorPublicacao(Publicacao publicacao) throws SQLException{
        AutorDAO autorDAO = new AutorDAO();
        String sql = "insert into publicacao_autor values(?,?)";
        for(int i = 0; i < publicacao.getAutores().size(); i++){
            Autor autor = new Autor();
            autor = autorDAO.pesquisarAutor(publicacao.getAutores().get(i).getNome());
            Publicacao publicacao1 = new Publicacao();
            PublicacaoDAO publicacaoDAO = new  PublicacaoDAO();
            publicacao1 = publicacaoDAO.selecionarPublicacaoporISBN(publicacao);
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, autor.getCodigoAutor());
            ps.setInt(2, publicacao1.getCodigoPublicacao());
            ps.executeUpdate();
            Conexao.getConexao().close();
        }
    }
    /*Seleciona um apublicacao pelo titulo e retorna o retultado do tipo publicacao*/
    public Publicacao selecionarPublicacaoporTitulo(Publicacao publicacao) throws SQLException{
        String sql = "select * from publicacao where titulo ilike '" + publicacao.getTituloPublicacao() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        Publicacao publicacao1 = new Publicacao();
        while(resultado.next()){
            publicacao1.setCodigoPublicacao(resultado.getInt("id_publicacao"));
            publicacao1.setTituloPublicacao(resultado.getString("titulo"));
            publicacao1.setAnoPublicacao(resultado.getInt("ano_publicacao"));
            publicacao1.setIsbn(resultado.getString("isbn"));
            publicacao1.setEditora(resultado.getString("editora"));
            publicacao1.setEdicao(resultado.getString("edicao"));
            TipoPublicacao tipoPublicacao = new TipoPublicacao();
            tipoPublicacao.setCodigoTipoPublicacao(resultado.getInt("tipo_publicacao"));
            publicacao1.setTipoPublicacao(tipoPublicacao);
        }
        Conexao.getConexao().close();
        return publicacao1;
    }
    /*Seleciona um apublicacao pelo ISBN e retorna o retultado do tipo publicacao*/
     public Publicacao selecionarPublicacaoporISBN(Publicacao publicacao) throws SQLException{
        String sql = "select * from publicacao where isbn = '" + publicacao.getIsbn() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        Publicacao publicacao1 = new Publicacao();
        while(resultado.next()){
            publicacao1.setCodigoPublicacao(resultado.getInt("id_publicacao"));
            publicacao1.setTituloPublicacao(resultado.getString("titulo"));
            publicacao1.setAnoPublicacao(resultado.getInt("ano_publicacao"));
            publicacao1.setIsbn(resultado.getString("isbn"));
            publicacao1.setEditora(resultado.getString("editora"));
            publicacao1.setEdicao(resultado.getString("edicao"));
            TipoPublicacao tipoPublicacao = new TipoPublicacao();
            tipoPublicacao.setCodigoTipoPublicacao(resultado.getInt("tipo_publicacao"));
            publicacao1.setTipoPublicacao(tipoPublicacao);
        }
        Conexao.getConexao().close();
        return publicacao1;
    }
     
    /*Altera os dados necessários de uma publicacao. O metodo deve receber o nome do novo tipo de publicacao, 
    para buscar seu códico e salvar na tabela publicacao o novo tipo*/
    public void alterarPublicacao(Publicacao publicacao) throws SQLException{
        Publicacao publicacao1 = selecionarPublicacaoporTitulo(publicacao);
        String sql = "update publicacao set titulo = ?, ano_publicacao = ?, isbn = ?, editora = ?, "
                + " edicao = ?, tipo_publicacao = ? where id_publicacao = " + publicacao1.getCodigoPublicacao() + ";";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, publicacao.getTituloPublicacao());
        ps.setInt(2, publicacao.getAnoPublicacao());
        ps.setString(3, publicacao.getIsbn());
        ps.setString(4, publicacao.getEditora());
        ps.setString(5, publicacao.getEdicao()); 
        TipoPublicacao tipoPublicacao = new TipoPublicacao();
        publicacao.setTipoPublicacao(tipoPublicacao.selecionarTipoPublicacao(publicacao));
        ps.setInt(6, publicacao.getTipoPublicacao().getCodigoTipoPublicacao());
        ps.executeUpdate();
        Conexao.getConexao().close();
    }
    /*O método exclui uma publicacao do banco de dados do sistema*/
    public void excluirPublicacao(Publicacao publicacao) throws SQLException{
        String sql = "delete from publicacao where id_publicacao = " + publicacao.getCodigoPublicacao() + ";";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.executeUpdate();
        Conexao.getConexao().close();
    }
}
