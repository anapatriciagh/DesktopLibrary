/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devolucao;

import Emprestimo.Emprestimo;
import Operador.Operador;
import java.sql.SQLException;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Ana PAtrícia
 */


public class Devolucao {
    private Date dataDevolucao;
    private Emprestimo emprestimo;
    private Operador operador;
    
    

    public Devolucao(Date dataDevolucao, Emprestimo emprestimo, Operador operador) {
        this.dataDevolucao = dataDevolucao;
        this.emprestimo = emprestimo;
        this.operador = operador;
    }
    public  Devolucao (){}
    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public String toString() {
        return "Devolucao{" + "dataDevolucao=" + dataDevolucao + ", emprestimo=" + emprestimo + ", operador=" + operador + '}';
    }
    /*Recebe uma devolucao e chama o método pra salva-la no banco de dados*/
    public void salvar (Devolucao devolucao) throws SQLException, JRException{
        DevolucaoDAO devolucaoDAO = new DevolucaoDAO();
        devolucaoDAO.insertDevolucao(devolucao);
    }
}
