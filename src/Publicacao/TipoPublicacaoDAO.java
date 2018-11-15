/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicacao;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class TipoPublicacaoDAO {
    /*Seleciona o tipo de uma publicacao. Ao cadastrar um livro deve-se recuperar o nome do tipo de publicacao,
    de modo que esta seja pesquisada por nome para depois ser cadastrado seu identificador de tipo na 
    tabela publicação no banco. O método retorna um tipo de publicacao*/
    public TipoPublicacao selecionarTipoPublicacaoPorNome(Publicacao publicacao) throws SQLException{
        String sql = "select * from tipo_publicacao where descricao ilike '" + publicacao.getTipoPublicacao().getDescricao() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        TipoPublicacao tipoPublicacao = new TipoPublicacao();
        while(resultado.next()){
            tipoPublicacao.setCodigoTipoPublicacao(resultado.getInt("id_tipo_publicacao"));
            tipoPublicacao.setDescricao(resultado.getString("descricao"));
        }
        Conexao.getConexao().close();
        return tipoPublicacao;
    }
}
