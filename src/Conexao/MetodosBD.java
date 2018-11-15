/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana PAtrícia
 */
public class MetodosBD {
    public ResultSet executarConsulta(String consulta) {
        Conexao fabrica = new Conexao();
        Connection conexao;
        ResultSet resultado;
        try {
            conexao = fabrica.getConexao();
            Statement stm = (Statement) conexao.createStatement();
            stm.executeQuery(consulta);
            resultado = stm.getResultSet();
            conexao.close();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(MetodosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Executa instrucoes que normalmente nao retornam resultado. Ex: insert e
     * update
     *
     * @param consulta consulta sql a ser executada
     * @return true se a consulta foi bem sucedida e false caso contrario
     */
    public boolean executarInstrucao(String consulta) {
        Conexao fabrica = new Conexao();
        Connection conexao;
        int isExecutado;
        try {
            conexao = fabrica.getConexao();
            Statement stm = (Statement) conexao.createStatement();
            isExecutado = stm.executeUpdate(consulta);
            conexao.close();

            if (isExecutado >= 1) {

                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MetodosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
