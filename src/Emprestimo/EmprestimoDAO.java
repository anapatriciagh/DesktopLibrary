/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprestimo;

import Conexao.Conexao;
import Exemplar.Exemplar;
import Operador.Operador;
import Usuario.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;


/**
 *
 * @author Ana PAtrícia
 */
public class EmprestimoDAO {
    /*Insere um emprestimo no banco de dados*/
    public void insertEmprestimo(Emprestimo emprestimo) throws SQLException, JRException{
        String sql = "insert into emprestimo values (default, current_date,?,?,?,?,current_time)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        System.out.println(sql);
        ps.setDate(1, new java.sql.Date(emprestimo.getDataPrevistaDevolucao().getTime()));
        ps.setInt(2, emprestimo.getOperador().getCodigoOperador());
        ps.setString(3, emprestimo.getExemplar().getCodigoExemplar());
        ps.setString(4, emprestimo.getUsuario().getCpf());
        ps.executeUpdate();
        System.out.println(emprestimo);
        Exemplar exemplar = new Exemplar();
        exemplar.alterarStatusEmprestado(emprestimo);
        
        Conexao.getConexao().close();
    }
    /*Seleciona um emprestimo pelo seu exemplar*/
    public Emprestimo buscarEmprestimoporExemplar(Emprestimo emprestimo) throws SQLException{
        String sql = "select * from emprestimo where id_exemplar = '" + emprestimo.getExemplar().getCodigoExemplar() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = ps.executeQuery();
        Emprestimo emprestimo1 = new Emprestimo();
        while(resultado.next()){
            emprestimo1.setCodigoEmprestimo(resultado.getInt("id_emprestimo"));
            emprestimo1.setDataEmprestimo(resultado.getDate("data_emprestimo"));
            emprestimo1.setHoraEmprestimo(resultado.getTime("hora_emprestimo"));
            emprestimo1.setDataPrevistaDevolucao(resultado.getDate("data_prevista_devolucao"));
            Exemplar exemplar = new Exemplar();
            exemplar.setCodigoExemplar(resultado.getString("id_exemplar"));
            emprestimo1.setExemplar(exemplar);
            Operador operador = new Operador();
            operador.setCodigoOperador(resultado.getInt("id_operador"));
            emprestimo1.setOperador(operador);
            Usuario usuario = new Usuario();
            usuario.setCpf(resultado.getString("cpf"));
            emprestimo1.setUsuario(usuario);
            Conexao.getConexao().close();
        }
        return  emprestimo1;
    }
    /*Seleciona um emprestimo pelo por um exemplar informado*/
     public Emprestimo buscarEmprestimoporExemplar(String exemplar) throws SQLException{
        String sql = "select * from emprestimo where id_exemplar = '" + exemplar + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = ps.executeQuery();
        Emprestimo emprestimo1 = new Emprestimo();
        while(resultado.next()){
            emprestimo1.setCodigoEmprestimo(resultado.getInt("id_emprestimo"));
            emprestimo1.setDataEmprestimo(resultado.getDate("data_emprestimo"));
            emprestimo1.setHoraEmprestimo(resultado.getTime("hora_emprestimo"));
            emprestimo1.setDataPrevistaDevolucao(resultado.getDate("data_prevista_devolucao"));
            Exemplar exemplar1 = new Exemplar();
            exemplar1.setCodigoExemplar(resultado.getString("id_exemplar"));
            emprestimo1.setExemplar(exemplar1);
            Operador operador = new Operador();
            operador.setCodigoOperador(resultado.getInt("id_operador"));
            emprestimo1.setOperador(operador);
            Usuario usuario = new Usuario();
            usuario.setCpf(resultado.getString("cpf"));
            emprestimo1.setUsuario(usuario);
            Conexao.getConexao().close();
        }
        return  emprestimo1;
    }
   
}
