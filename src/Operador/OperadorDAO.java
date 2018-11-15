/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operador;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class OperadorDAO {
    /*O método insere no banco de dados os dados informados de um operador no momento do seu cadastro */
    public void insertOperador(Operador operador) throws SQLException{
        String sql = "insert into operador values(default, ?, ?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, operador.getNomeOperador());
        ps.setString(2, operador.getSenha());
        ps.executeUpdate();
        Conexao.getConexao().close();
    }
    /*O método busca o operador pelo usuario e senha informados e retorna-o depoisde uma busca na base de dados 
    do sistema.*/
    public Operador validarOperador(Operador operador) throws SQLException{
        String sql = "select * from operador where nome_usuario = '" + operador.getNomeOperador() + "'and senha = '" + operador.getSenha() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = ps.executeQuery();
        Operador operador1 = new Operador();
        while (resultado.next()){
            operador1.setCodigoOperador(resultado.getInt("id_operador"));
            operador1.setNomeOperador(resultado.getString("nome_usuario"));
            operador1.setSenha(resultado.getString("senha"));
        }
        Conexao.getConexao().close();
        return operador1;
 }
    /*O método busca um operador com parâmetros do tipo string*/
    public Operador buscarOperador(String nomeUsuario, String senha) throws SQLException{
        String sql = "select * from operador where nome_usuario = '" + nomeUsuario + "'and senha = '" + senha + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = ps.executeQuery();
        Operador operador = new Operador();
        while (resultado.next()){
            operador.setCodigoOperador(resultado.getInt("id_operador"));
            operador.setNomeOperador(resultado.getString("nome_usuario"));
            operador.setSenha(resultado.getString("senha"));
        }
        Conexao.getConexao().close();
        return operador;
 }
}
