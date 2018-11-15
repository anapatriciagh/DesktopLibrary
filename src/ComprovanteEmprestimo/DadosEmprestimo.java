/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComprovanteEmprestimo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ana PAtrícia
 */
public class DadosEmprestimo {

    private String nomeUsuario;
    private Date dataEmprestimo;
    private String horaEmprestimo;
    private Date dataPrevistaDevolucao;
    private String publicacao;
    private String nomeAutor;
    private String nomeOperador;

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(String horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    @Override
    public String toString() {
        return "\nUsuario  " + nomeUsuario + "\nData do Empréstimo  " + dataEmprestimo + "\nHora do Empréstimo  " + horaEmprestimo + "\nData Prevista para Devolucao  " + dataPrevistaDevolucao + "\nPublicacao  " + publicacao + "\nAutor  " + nomeAutor + "\nOperador  " + nomeOperador;
    }

    public void VisualizarRelatorio(String exemplar) throws SQLException, JRException {
        ConsultaDadosEmprestimo dadosEmprestimo = new ConsultaDadosEmprestimo();
        ResultSet resultSet = dadosEmprestimo.BuscarDadosEmprestimo(exemplar);
        JRResultSetDataSource jRResultSetDataSource = new JRResultSetDataSource(resultSet);
        HashMap parameterMap = new HashMap();
        parameterMap.put("exemplar", exemplar);
        String file = "D:/BIBLIOTECA/BibliotecaCad03_01_2015/src/ComprovanteEmprestimo/ComprovanteEmprestimo.jasper";
        JasperPrint jasperPrint;
        jasperPrint = JasperFillManager.fillReport(file, parameterMap, jRResultSetDataSource);
        JasperViewer.viewReport(jasperPrint, false);
    }
}
