/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicacao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ana PAtrícia
 */
public class TipoPublicacao {
    private int codigoTipoPublicacao;
    private String descricao;
    private ArrayList<Publicacao> publicacao = new ArrayList<>();

    public TipoPublicacao(int codigoTipoPublicacao, String descricao) {
        this.codigoTipoPublicacao = codigoTipoPublicacao;
        this.descricao = descricao;
    }
    public TipoPublicacao() {}

    public int getCodigoTipoPublicacao() {
        return codigoTipoPublicacao;
    }

    public void setCodigoTipoPublicacao(int codigoTipoPublicacao) {
        this.codigoTipoPublicacao = codigoTipoPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Publicacao> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(ArrayList<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public String toString() {
        return "TipoPublicacao{" + "codigoTipoPublicacao=" + codigoTipoPublicacao + ", descricao=" + descricao + ", publicacao=" + publicacao + '}';
    }
    /*O método recebe um tipo de publicacao e chama o método que seleciona um tipo pela descrição.
    O método retorna um resultado do tipo tipoPublicacao*/
    public TipoPublicacao selecionarTipoPublicacao(Publicacao publicacao) throws SQLException{
        TipoPublicacaoDAO tipoPublicacaoDAO = new TipoPublicacaoDAO();
        TipoPublicacao tipoPublicacao = tipoPublicacaoDAO.selecionarTipoPublicacaoPorNome(publicacao);
        return tipoPublicacao;
    }
}
