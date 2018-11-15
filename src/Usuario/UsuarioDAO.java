/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class UsuarioDAO {
    /*O método insere um usuario no banco de dados*/

    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        String sql = "insert into usuario values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getMatricula());
            ps.setString(3, usuario.getNomeCompleto());
            ps.setString(4, usuario.getNomeUsuario());
            ps.setString(5, usuario.getSenha());
            ps.setString(6, usuario.getCategoriaUsuario());
            ps.setString(7, usuario.getCargo());
            ps.setString(8, usuario.getSexo());
            ps.setString(9, usuario.getLogradouro());
            ps.setString(10, usuario.getBairro());
            ps.setString(11, usuario.getCidade());
            ps.setString(12, usuario.getUF());
            ps.setString(13, usuario.getTelefone());
            ps.setString(14, usuario.getEmail());
            TipoUsuario tipoUsuario = new TipoUsuario();
            usuario.setTipoUsuario(tipoUsuario.cadastrarTipoUsuario(usuario));
            ps.setInt(15, usuario.getTipoUsuario().getCodigoTipoUsuario());
            ps.executeUpdate();
            Conexao.getConexao().close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir " + e);
        }
    }

    /*Seleciona um usuario do banco de dados pelo cpf. Retorna o resultado da busca*/
    public Usuario selecionarUsuario(String cpf) throws SQLException {
        String sql = "select * from usuario where cpf = '" + cpf + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        Usuario usuario = new Usuario();
        while (resultado.next()) {
            usuario.setCpf(resultado.getString("cpf"));
            usuario.setMatricula(resultado.getString("matricula"));
            usuario.setNomeCompleto(resultado.getString("nome_completo"));
            usuario.setNomeUsuario(resultado.getString("nome_usuario"));
            usuario.setSenha(resultado.getString("senha"));
            usuario.setCategoriaUsuario(resultado.getString("categoria_usuario"));
            usuario.setCargo(resultado.getString("sexo"));
            usuario.setLogradouro(resultado.getString("logradouro"));
            usuario.setBairro(resultado.getString("bairro"));
            usuario.setCidade(resultado.getString("cidade"));
            usuario.setUF(resultado.getString("uf"));
            usuario.setTelefone(resultado.getString("telefone"));
            usuario.setEmail(resultado.getString("email"));
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setCodigoTipoUsuario(resultado.getInt("tipo_usuario"));
            usuario.setTipoUsuario(tipoUsuario);
            Conexao.getConexao().close();
        }
        return usuario;
    }
    /*Seleciona um usuario do banco de dados por usuario e senha e retorna o resultado*/

    public Usuario selecionarUsuarioporUsuarioeSenha(String nomeUsuario, String senha) throws SQLException {
        String sql = "select * from usuario where nome_usuario = '" + nomeUsuario + "' and senha = '" + senha + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado = ps.executeQuery();
        Usuario usuario1 = new Usuario();
        while (resultado.next()) {
            usuario1.setCpf(resultado.getString("cpf"));
            usuario1.setMatricula(resultado.getString("matricula"));
            usuario1.setNomeCompleto(resultado.getString("nome_completo"));
            usuario1.setNomeUsuario(resultado.getString("nome_usuario"));
            usuario1.setSenha(resultado.getString("senha"));
            usuario1.setCategoriaUsuario(resultado.getString("categoria_usuario"));
            usuario1.setCargo(resultado.getString("sexo"));
            usuario1.setLogradouro(resultado.getString("logradouro"));
            usuario1.setBairro(resultado.getString("bairro"));
            usuario1.setCidade(resultado.getString("cidade"));
            usuario1.setUF(resultado.getString("uf"));
            usuario1.setTelefone(resultado.getString("telefone"));
            usuario1.setEmail(resultado.getString("email"));
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setCodigoTipoUsuario(resultado.getInt("tipo_usuario"));
            usuario1.setTipoUsuario(tipoUsuario);

            Conexao.getConexao().close();
        }
        return usuario1;
    }
    /*Altera no banco de dados os dados desejados pelo usuario*/

    public void alterarUsuario(Usuario usuario) throws SQLException {
        String sql = "update usuario set cpf = ?, matricula = ?, nome_completo = ?, nome_usuario = ?,"
                + "senha = ?, categoria_usuario = ?, cargo = ?, sexo = ?, logradouro = ?, bairro = ?,"
                + "cidade = ?, uf = ?, telefone = ?, email = ?, tipo_usuario = ? where cpf = '" + usuario.getCpf() + "';";
        System.out.println(sql);
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getCpf());
        ps.setString(2, usuario.getMatricula());
        ps.setString(3, usuario.getNomeCompleto());
        ps.setString(4, usuario.getNomeUsuario());
        ps.setString(5, usuario.getSenha());
        ps.setString(6, usuario.getCategoriaUsuario());
        ps.setString(7, usuario.getCargo());
        ps.setString(8, usuario.getSexo());
        ps.setString(9, usuario.getLogradouro());
        ps.setString(10, usuario.getBairro());
        ps.setString(11, usuario.getCidade());
        ps.setString(12, usuario.getUF());
        ps.setString(13, usuario.getTelefone());
        ps.setString(14, usuario.getEmail());
        TipoUsuario tipoUsuario = new TipoUsuario();
        usuario.setTipoUsuario(tipoUsuario.alterarTipoUsuario(usuario));
        ps.setInt(15, usuario.getTipoUsuario().getCodigoTipoUsuario());
        ps.executeUpdate();
        Conexao.getConexao().close();
    }
    /*Exclui um usuario do banco de dados*/

    public void excluirUsuario(Usuario usuario) throws SQLException {
        String sql = "delete from usuario where cpf = " + usuario.getCpf();
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.executeUpdate();
        Conexao.getConexao().close();
    }
    /*Verifica se o usuario e senha informados existem no banco de dados*/

    public Usuario validarUsuario(Usuario usuario) throws SQLException {
        String sql = "select cpf, nome_usuario, senha from usuario where nome_usuario = '" + usuario.getNomeUsuario() + "' and senha = '" + usuario.getSenha() + "';";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet resultado;
        resultado = ps.executeQuery();
        Usuario usuario1 = new Usuario();
        while (resultado.next()) {
            usuario1.setCpf(resultado.getString("cpf"));
            usuario1.setNomeUsuario(resultado.getString("nome_usuario"));
            usuario1.setSenha(resultado.getString("senha"));
        }
        Conexao.getConexao().close();
        return usuario1;
    }
}
