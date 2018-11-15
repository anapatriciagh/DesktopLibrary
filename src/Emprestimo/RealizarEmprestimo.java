/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprestimo;

import Exemplar.Exemplar;
import Operador.Operador;
import Operador.OperadorDAO;
import Usuario.Usuario;
import Usuario.UsuarioDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Ana PAtrícia
 */
public class RealizarEmprestimo {
    public static void main(String[] args) throws SQLException, JRException {
        Emprestimo emprestimo = new Emprestimo();
        //para realizar o emprestimo  o usuario deverá informar seu nome de usuario e senha
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Ana");
        usuario1.setSenha("ana36");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.selecionarUsuarioporUsuarioeSenha(usuario1.getNomeUsuario(),usuario1.getSenha());
       
        emprestimo.setUsuario(usuario);
        
        Operador operador = new Operador();
        operador.setNomeOperador("ana");
        operador.setSenha("ana");
        OperadorDAO operadorDAO = new OperadorDAO();
        Operador operador1 = new Operador();
        operador1 = operadorDAO.buscarOperador(operador.getNomeOperador(), operador.getSenha());

        emprestimo.setOperador(operador1);
        Exemplar exemplar = new Exemplar();
        exemplar.setCodigoExemplar("1BB");
        emprestimo.setExemplar(exemplar);
        
        emprestimo.setDataEmprestimo(Calendar.getInstance().getTime());
        //operação para se obter a data prevista para devolucao
        //a data prevista recebe a data do emprestimo  e soma à quantidde de dias de emprestimo do usuario
        int diasEmprestimo = emprestimo.returnQuantidadeDiasEmprestimo(usuario.getNomeUsuario(), usuario.getSenha());
        int date = emprestimo.getDataEmprestimo().getDate() + diasEmprestimo;
        
        Date dataPrevista;
        dataPrevista = Calendar.getInstance().getTime();
        dataPrevista.setDate(date);
        
        emprestimo.setDataPrevistaDevolucao(dataPrevista);
        
        emprestimo.salvar(emprestimo);
        
    }
}
