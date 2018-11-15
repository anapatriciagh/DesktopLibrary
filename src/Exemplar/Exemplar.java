/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplar;

import ComprovanteDevolucao.DadosDevolucao;
import ComprovanteEmprestimo.DadosEmprestimo;
import Emprestimo.Emprestimo;
import Publicacao.Publicacao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Ana PAtrícia
 */
public class Exemplar {
    private String codigoExemplar;
    private String status;
    private Publicacao publicacao;
    private ArrayList <Emprestimo> emprestimos = new ArrayList<>();
    
    private final String livre = "livre";
    private final String emprestado = "emprestado";

    public Exemplar(String codigoExemplar, String status, Publicacao publicacao) {
        this.codigoExemplar = codigoExemplar;
        this.status = status;
        this.publicacao = publicacao;
    }
    public Exemplar(){}

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public ArrayList <Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList <Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Exemplar{" + "codigoExemplar=" + codigoExemplar + ", status=" + status + ", publicacao=" + publicacao + ", emprestimos=" + emprestimos + '}';
    }
    /*O método recebe uma publicacao e chama o método que salva essa publicaco do banco de dados do 
    sistema
    */
 public void salvarExemplarPublicacao(Publicacao publicacao) throws SQLException{
     ExemplarDAO exemplarDAO = new ExemplarDAO();
     exemplarDAO.salvarExemplardaPublicacao(publicacao);
     }
  
    /*Recebe um operador e e chama o método insertExemplar, que insere um exemplar no BD*/
    public void salvarExemplar(Exemplar exemplar) throws SQLException{
        ExemplarDAO exemplarDAO = new ExemplarDAO();
        exemplarDAO.insertExemplar(exemplar);
    }
    /*recebe um emprestimo, pega o exemplar desse emprestimo e chama o método alterarStatusLivre  
    que altera seu status para livre, ao realizar-se uma devolução*/
    public void alterarStatusLivre(Emprestimo emprestimo) throws SQLException, JRException{
        emprestimo.getExemplar().setStatus(livre);
        ExemplarDAO exemplarDAO = new ExemplarDAO();
        exemplarDAO.alterarStatusLivre(emprestimo.getExemplar());
        System.out.println("Exemplar devolvido!");
        JOptionPane.showMessageDialog(null, "Exemplar devolvido!");
        DadosDevolucao dadosDevolucao = new DadosDevolucao();
        dadosDevolucao.VisualizarComprovanteDevolucao(emprestimo.getExemplar().getCodigoExemplar());
    }
    /*recebe um emprestimo, pega o exemplar desse emprestimo e chama o métod alterarStatusEmprestado  
    que altera seu status para Emprestado ao realizar-se um emprestimo*/
    public void alterarStatusEmprestado(Emprestimo emprestimo) throws SQLException, JRException{
        emprestimo.getExemplar().setStatus(emprestado);
        ExemplarDAO exemplarDAO = new ExemplarDAO();
        exemplarDAO.alterarStatusEmprestado(emprestimo.getExemplar());
        JOptionPane.showMessageDialog(null, "Empréstimo Realizado!");
        DadosEmprestimo dadosEmprestimo = new DadosEmprestimo();
        dadosEmprestimo.VisualizarRelatorio(emprestimo.getExemplar().getCodigoExemplar());
    }
}