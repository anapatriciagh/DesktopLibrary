/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComprovanteDevolucao;

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
public class DadosDevolucao {
    private Date  dataDevolucao;
    private String nomeUsuario;
    private String nomeAutor;
    private String publicacao;
    private String nomeOperador;

    public DadosDevolucao(Date dataDevolucao, String nomeUsuario, String nomeAutor, String publicacao, String nomeOperador) {
        this.dataDevolucao = dataDevolucao;
        this.nomeUsuario = nomeUsuario;
        this.nomeAutor = nomeAutor;
        this.publicacao = publicacao;
        this.nomeOperador = nomeOperador;
    }
    public DadosDevolucao(){}

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    @Override
    public String toString() {
        return "DadosDevolucao{" + "dataDevolucao=" + dataDevolucao + ", nomeUsuario=" + nomeUsuario + ", nomeAutor=" + nomeAutor + ", publicacao=" + publicacao + ", nomeOperador=" + nomeOperador + '}';
    }
     /*recebe um exemplar, busca os dados da devolução pelo exemplar com o método buscarDadosDevolucao que 
     retorna um ResultSet, envia o exemplar informado para parâmetro do relatório, e manda imprimir o relatório
     chamando o método que recebe o diretório do relatório, o parâmetro e o resultado da busca*/

    public void VisualizarComprovanteDevolucao(String exemplar) throws SQLException, JRException {
        ConsultaDadosDevolucao dadosDevolucao = new ConsultaDadosDevolucao();
        ResultSet resultSet = dadosDevolucao.buscarDadosDevolucao(exemplar);
        JRResultSetDataSource jRResultSetDataSource = new JRResultSetDataSource(resultSet);
        HashMap parameterMap = new HashMap();
        parameterMap.put("exemplar", exemplar);
        String file = "D:/BIBLIOTECA/BibliotecaCad03_01_2015/src/ComprovanteDevolucao/ComprovanteDevolucao.jasper";
        JasperPrint jasperPrint;
        jasperPrint = JasperFillManager.fillReport(file, parameterMap, jRResultSetDataSource);
        JasperViewer.viewReport(jasperPrint, false);

    }
}
