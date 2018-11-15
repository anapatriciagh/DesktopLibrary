/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devolucao;

import Emprestimo.Emprestimo;
import Exemplar.Exemplar;
import Operador.Operador;
import Operador.OperadorDAO;
import java.sql.SQLException;
import java.util.Calendar;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Ana PAtrícia
 */
public class RealizarDevolucao {
    public static void main(String[] args) throws SQLException, JRException {
        //O operador informa seu nome de usuario e senha para realizar uma devolução
        Devolucao devolucao = new Devolucao();
        Operador operador = new Operador();
        operador.setNomeOperador("ana");
        operador.setSenha("ana");
        //o login é autenticado
        boolean autenticado = operador.autenticarOperador(operador);
        //verifica-se se o login é válido. Se sim o operador logado é salvo como o operador que realizou a devolução 
        if(autenticado){
            OperadorDAO operadorDAO = new OperadorDAO();
            Operador operador1 = operadorDAO.buscarOperador(operador.getNomeOperador(), operador.getSenha());
            devolucao.setOperador(operador1);
        }
        
        //a data da devolução é a mesma do sistema
        
        devolucao.setDataDevolucao(Calendar.getInstance().getTime());
        //informa-se a identificacao do exemplar para se realizar uma devolucao
        Emprestimo emprestimo = new Emprestimo();
        Exemplar exemplar = new Exemplar();
        exemplar.setCodigoExemplar("1EE");
        emprestimo.setExemplar(exemplar);
        //verifica-se se o exemplar existe em um emprestimo
        //se existir o método retorna o emprestimo do exemplar
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1 = emprestimo.emprestimoExemplar(emprestimo);
        if(emprestimo1.getExemplar().equals(emprestimo.getExemplar())){
            exemplar.alterarStatusLivre(emprestimo1);
        }
        System.out.println(emprestimo.getExemplar());
        System.out.println(emprestimo1.getExemplar());
        
        //a devolução recebe o emprestimo
        devolucao.setEmprestimo(emprestimo1);
        //a devolução é salva
        //metodosDevolucao.salvarDevolucao(devolucao);
        devolucao.salvar(devolucao);
        
    }
}
