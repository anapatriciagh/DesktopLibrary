/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class Conexao {
    public static  Connection getConexao() throws SQLException {
        
        //nome do usuario do banco
        String usuario = "postgres";
        
        //senha do usuario do banco
        String senha = "administrator";
        
        //ip do banco. para banco no mesmo computador utilize localhost
        String ip = "localhost";
        
        //nome do banco de dados. padrao do postgre eh postgres
        String bd = "biblioteca";
        
        //porta de conexao com o banco de dados. Padrao do postgre eh 5432
        int porta = 5432;
        
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://" + ip + ":" + porta + "/" + bd, usuario, senha);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
        
    }
}
