/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operador;

import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class InserirOperador {
    public static void main(String[] args) throws SQLException {
        /*inserindo um operador*/
        Operador operador = new Operador();
        operador.setNomeOperador("franciscaMaria");
        operador.setSenha("francis");//fazer restricao de cadastro de operador igual -- > ok!
        operador.salvar(operador);
    }
}
