/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComprovanteDevolucao;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class ConsultaDadosDevolucao {
  /*busca os dados de uma devolução para imprimir no comprovante e retorna um resulado do tipo
    ResultSet*/
    public ResultSet buscarDadosDevolucao(String exemplar) throws SQLException {
        String sql = "select u.nome_completo, d.data_devolucao,  em.data_prevista_devolucao, p.titulo, a.nome_autor, o.nome_usuario \n"
                + "from usuario u \n"
                + "inner join emprestimo em using(cpf)\n"
                + "inner join devolucao d using(id_emprestimo) \n"
                + "inner join operador o using (id_operador),\n"
                + "emprestimo \n"
                + "inner join exemplar e using(id_exemplar) \n"
                + "inner join publicacao p using (id_publicacao) \n"
                + "inner join publicacao_autor pa using(id_publicacao)\n"
                + "inner join autor a using(id_autor)\n"
                + " where e.id_exemplar = '" + exemplar + "';";
        PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = preparedStatement.executeQuery();
        Conexao.getConexao().close();
        return resultado;
    }
}
