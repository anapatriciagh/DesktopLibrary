/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComprovanteEmprestimo;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class ConsultaDadosEmprestimo {
 /*busca os dados de um emprestimo para imprimir no comprovante e retorna um resulado do tipo
    ResultSet*/
    public ResultSet BuscarDadosEmprestimo(String exemplar) throws SQLException {
        String sql = "select \n"
                + "em.data_emprestimo,\n"
                + "em.hora_emprestimo, \n"
                + "em.data_prevista_devolucao, \n"
                + "o.nome_usuario, \n"
                + "u.nome_completo, \n"
                + "p.titulo, \n"
                + "a.nome_autor \n"
                + "from usuario u \n"
                + "inner join emprestimo  em using(cpf) \n"
                + "inner join exemplar e using(id_exemplar) \n"
                + "inner join publicacao p using (id_publicacao)\n"
                + " inner join publicacao_autor pa using(id_publicacao)\n"
                + "inner join autor a using (id_autor), \n"
                + "emprestimo \n"
                + "inner join operador o using (id_operador) \n"
                + "where e.id_exemplar = '" + exemplar + "';";

        PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = preparedStatement.executeQuery();
        Conexao.getConexao().close();
        return resultado;
    }

    public DadosEmprestimo DetalhesEmprestimo(String exemplar) throws SQLException {
        String sql = "select \n"
                + "em.data_emprestimo,\n"
                + "em.hora_emprestimo, \n"
                + "em.data_prevista_devolucao, \n"
                + "o.nome_usuario, \n"
                + "u.nome_completo, \n"
                + "p.titulo, \n"
                + "a.nome_autor \n"
                + "from usuario u \n"
                + "inner join emprestimo  em using(cpf) \n"
                + "inner join exemplar e using(id_exemplar) \n"
                + "inner join publicacao p using (id_publicacao)\n"
                + " inner join publicacao_autor pa using(id_publicacao)\n"
                + "inner join autor a using (id_autor), \n"
                + "emprestimo \n"
                + "inner join operador o using (id_operador) \n"
                + "where e.id_exemplar = '" + exemplar + "';";

        PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = preparedStatement.executeQuery();
        DadosEmprestimo dadosEmprestimo = new DadosEmprestimo();
        while (resultado.next()) {
            dadosEmprestimo.setDataEmprestimo(resultado.getDate("data_emprestimo"));
            dadosEmprestimo.setDataPrevistaDevolucao(resultado.getDate("data_prevista_devolucao"));
            dadosEmprestimo.setHoraEmprestimo(resultado.getString("hora_emprestimo"));
            dadosEmprestimo.setNomeAutor(resultado.getString("nome_autor"));
            dadosEmprestimo.setNomeOperador(resultado.getString("nome_usuario"));
            dadosEmprestimo.setNomeUsuario(resultado.getString("nome_completo"));
            dadosEmprestimo.setPublicacao(resultado.getString("titulo"));
        }
        Conexao.getConexao().close();
        return dadosEmprestimo;
    }
}
