/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.ArrayList;

/**
 *
 * @author Ana PAtrícia
 */
public class TipoUsuario {
   private int codigoTipoUsuario;
   private int qtdDiasEmprestimo;
   private int qtdPublicacoes;
   private String Descricao;
   private ArrayList<Usuario> usuarios = new ArrayList<>();  
   
   public TipoUsuario(){}

    public TipoUsuario(int codigoTipoUsuario, int qtdDiasEmprestimo, int qtdPublicacoes, String Descricao) {
        this.codigoTipoUsuario = codigoTipoUsuario;
        this.qtdDiasEmprestimo = qtdDiasEmprestimo;
        this.qtdPublicacoes = qtdPublicacoes;
        this.Descricao = Descricao;
    }

    public int getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }
    public void setCodigoTipoUsuario(int codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }
    public int getQtdDiasEmprestimo() {
        return qtdDiasEmprestimo;
    }

    public void setQtdDiasEmprestimo(int qtdDiasEmprestimo) {
        this.qtdDiasEmprestimo = qtdDiasEmprestimo;
    }

    public int getQtdPublicacoes() {
        return qtdPublicacoes;
    }

    public void setQtdPublicacoes(int qtdPublicacoes) {
        this.qtdPublicacoes = qtdPublicacoes;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public ArrayList<Usuario> getUsuario() {
        return usuarios;
    }

    public void setUsuario(ArrayList<Usuario> usuario) {
        this.usuarios = usuario;
    }
    @Override
    public String toString() {
        return "TipoUsuario{" + "codigoTipoUsuario=" + codigoTipoUsuario + ", qtdDiasEmprestimo=" + qtdDiasEmprestimo + ", qtdPublicacoes=" + qtdPublicacoes + ", Descricao=" + Descricao + ", usuario=" + usuarios + '}';
    }
    /*Recebe um usuario e cadastra seu tipo, de acordo com sua categoria*/
    public TipoUsuario cadastrarTipoUsuario(Usuario usuario) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        if (usuario.getCategoriaUsuario().equals("Aluno")) {
            tipoUsuario.setCodigoTipoUsuario(1);
        } else if (usuario.getCategoriaUsuario().equals("Professor")) {
            tipoUsuario.setCodigoTipoUsuario(2);
        } else {
            tipoUsuario.setCodigoTipoUsuario(3);
        }
        return tipoUsuario;
    }
    /*Recebe um usuario e chama o método cadastrarTipoUsuario, para cadastrar o novo tipo do usuario*/
    public TipoUsuario alterarTipoUsuario(Usuario usuario) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario = tipoUsuario.cadastrarTipoUsuario(usuario);
        return tipoUsuario;
    }
}
