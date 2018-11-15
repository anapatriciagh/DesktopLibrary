/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operador;

import Devolucao.Devolucao;
import Emprestimo.Emprestimo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana PAtrícia
 */
public class Operador {
    private int codigoOperador;
    private String nomeOperador;
    private String senha;
    private ArrayList <Emprestimo> emprestimos = new ArrayList<>();
    private ArrayList<Devolucao> devolucao = new ArrayList<>(); 
    
    //um operador realiza vários emprestimos, por esse motivo o tipo contém um arrayList de emprestimos
    //O mesmo ocorre com as devoluções
    public Operador(int codigoOperador, String nomeOperador, String senha) {
        this.codigoOperador = codigoOperador;
        this.nomeOperador = nomeOperador;
        this.senha = senha;
        
    }
    public  Operador(){}

    public int getCodigoOperador() {
        return codigoOperador;
    }

    public void setCodigoOperador(int codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Devolucao> getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(ArrayList<Devolucao> devolucao) {
        this.devolucao = devolucao;
    }

    public ArrayList <Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList <Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Operador{" + "codigoOperador=" + codigoOperador + ", nomeOperador=" + nomeOperador + ", senha=" + senha + ", emprestimos=" + emprestimos + ", devolucao=" + devolucao + '}';
    }
    
    
   /*O método recebe os dados de um operador e chama o métodos OperadorIsExistis, que verifica se o operador
    já existe, caso o retorno do método for verdadeiro, chama-se o método inserir que envia os dados para
    o banco de dados do sistema*/
    public void salvar(Operador operador) throws SQLException{
        OperadorDAO operadorDAO = new OperadorDAO();
        boolean isExistis = OperadorIsExistis(operador);
            if(isExistis != true){
             operadorDAO.insertOperador(operador);
        }else{}
    }
    /*O método recebe um operador na hora do acesso ao sistema e chama o método 
    validarOperador que verifica se esse usuario existe, caso exista, uma mensagem de boas vindas é exibida e 
    o método retorna verdadeiro, caso não exista o acesso é negado com uma mensagem e o método agora retorna falso*/
    public boolean autenticarOperador(Operador operador) throws SQLException {
        OperadorDAO operadorDAO = new OperadorDAO();
        System.out.println(operador);
        Operador operador1 = operadorDAO.validarOperador(operador);
            if (operador.getNomeOperador().equals(operador1.getNomeOperador()) && operador.getSenha().equals(operador1.getSenha())){
                JOptionPane.showMessageDialog(null, "Bem Vindo " + operador.getNomeOperador());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!");   
            }
            return false;
        }
    /*O metodo recebe um operador e verifica se ele já existe, caso exista, 
    ele não poderá ser cadastrado no sistema
    e uma mensagem com essa informação é mostrada. O método retorna true. 
    Caso o operador ainda não exista no sistema, uma mesnsagem de sucesso o cadastro é mostrada
    e o método retorna false*/
    public boolean OperadorIsExistis(Operador operador) throws SQLException{
        Operador operador1 = new Operador();
        OperadorDAO operadorDAO = new OperadorDAO();
        operador1 = operadorDAO.validarOperador(operador);
        if(operador.getNomeOperador().equals(operador1.getNomeOperador()) && operador.getSenha().equals(operador1.getSenha())){
                System.out.println("Operador já existe!");
                JOptionPane.showMessageDialog(null, "Operador já existe!");
                return true;
           }else{
                System.out.println("Operador cadastrado com sucesso!");
                JOptionPane.showMessageDialog(null, "Operador cadastrado com sucesso!");         
        }
        return false;
    }
    /*O método recebe um operador e chama um método para buscá-lo no bd, retornando o resultado da busca*/
    public Operador buscarOperador(Operador operador) throws SQLException{
        OperadorDAO operadorDAO = new OperadorDAO();
        Operador operador1  = new Operador();
        operador1 = operadorDAO.buscarOperador(operador.getNomeOperador(), operador.getSenha());
        return operador1;  
    }
}
