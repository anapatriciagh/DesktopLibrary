/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplar;

import Conexao.Conexao;
import Emprestimo.Detalhes;
import Publicacao.Publicacao;
import Publicacao.PublicacaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class ExemplarDAO {
    private final String statusLivre = "livre";
    private final String statusEmprestado = "emprestado";
    /*Insere um exemplar no BD*/
    public void insertExemplar(Exemplar exemplar) throws SQLException{
        String sql = "insert into exemplar values (?,?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, exemplar.getCodigoExemplar());
        ps.setString(2, exemplar.getStatus());
        ps.setInt(3, exemplar.getPublicacao().getCodigoPublicacao());
        ps.executeUpdate();
        Conexao.getConexao().close();
    }
    /*Altera no banco, o status de um exemplar para emprestado ao realizar-se um emprestimo*/
    public void alterarStatusEmprestado(Exemplar exemplar) throws SQLException{
        String sql = "update exemplar set status = '" + statusEmprestado + "' where id_exemplar = '" + exemplar.getCodigoExemplar() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.executeUpdate();
        Conexao.getConexao().close();
    }
    /*Altera no banco, o status de um exemplar para livre  ao realizar-se uma devolução*/
    public void alterarStatusLivre(Exemplar exemplar) throws SQLException{
        String sql = "update exemplar set status = '" + statusLivre + "' where id_exemplar = '" + exemplar.getCodigoExemplar() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.executeUpdate();
        System.out.println(exemplar);
        Conexao.getConexao().close();
    }
    /*Salva um exemplar no banco de dados*/
     public void salvarExemplardaPublicacao(Publicacao publicacao) throws SQLException{
        String sql = "insert into exemplar values (?,?,?)";
        for(int i = 0; i < publicacao.getExemplares().size(); i++){
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, publicacao.getExemplares().get(i).getCodigoExemplar());
            ps.setString(2, statusLivre);
            Publicacao publicacao1 = new Publicacao();
            PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
            publicacao1 = publicacaoDAO.selecionarPublicacaoporISBN(publicacao);
            ps.setInt(3, publicacao1.getCodigoPublicacao());
            ps.executeUpdate();
            Conexao.getConexao().close();
             }
     }
     /*Seleciona um exemplar do banco pelo seu código*/
    public Exemplar selecionarExemplar(Exemplar exemplar) throws SQLException{
        String sql = "select * from exemplar where id_exemplar = '" + exemplar.getCodigoExemplar() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet res;
        res = ps.executeQuery();
        Exemplar exemplar1 = new Exemplar();
        while(res.next()){
            exemplar1.setCodigoExemplar(res.getString("id_exemplar"));
            Publicacao publicacao = new Publicacao();
            publicacao.setCodigoPublicacao(res.getInt("publicacao"));
            exemplar1.setPublicacao(publicacao);
            exemplar1.setStatus(res.getString("status"));
        }
        Conexao.getConexao().close();
        return exemplar1;
    }
    /*Seleciona o status do exemplar pelo código*/
    public Exemplar selecionarStatusExemplar(String exemplar) throws SQLException{
        String sql = "select status from exemplar where id_exemplar = '" + exemplar + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet res;
        res = ps.executeQuery();
        Exemplar exemplar1 = new Exemplar();
        while(res.next()){
            exemplar1.setStatus(res.getString("status"));
        }
        Conexao.getConexao().close();
        return exemplar1;
    }
    /*Detalhes exemplar para mostrar na tela*/
    public Detalhes DetalhesExemplar(Exemplar exemplar) throws SQLException{
        String sql = "select p.titulo, p.ano_publicacao, a.nome_autor, e.status from exemplar e join publicacao p using(id_publicacao) join publicacao_autor pa using(id_publicacao)join autor a using (id_autor) \n" +
        "where e.id_exemplar = '" + exemplar.getCodigoExemplar() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet res;
        res = ps.executeQuery();
        Detalhes detalhes = new Detalhes();
        while(res.next()){
            detalhes.setTituloPublicacao(res.getString("titulo"));
            detalhes.setNome_autor(res.getString("nome_autor"));
            detalhes.setStatusExemplar(res.getString("status"));
            detalhes.setAno_publicacao(res.getInt("ano_publicacao"));
        }
        Conexao.getConexao().close();
        return detalhes;
    }
}