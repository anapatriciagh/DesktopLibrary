/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devolucao;

import Conexao.Conexao;
import Exemplar.Exemplar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Ana PAtrícia
 */
public class DevolucaoDAO {
    
    /*O método insere uma devolução no banco de dados*/
    public void insertDevolucao(Devolucao devolucao) throws SQLException, JRException{
        String sql = "insert into devolucao values(current_date, ?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        System.out.println(sql);
        ps.setInt(1, devolucao.getEmprestimo().getCodigoEmprestimo());
        ps.setInt(2, devolucao.getOperador().getCodigoOperador());
        ps.executeUpdate();
        Exemplar exemplar = new Exemplar();
        exemplar.alterarStatusLivre(devolucao.getEmprestimo());
        System.out.println(devolucao.getEmprestimo());
        Conexao.getConexao().close();
    }
}
