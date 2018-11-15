/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Emprestimo.Emprestimo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana PAtrícia
 */
public class Usuario {
    private String cpf;
    private String nomeCompleto;
    private String nomeUsuario;
    private String senha;
    private String matricula;
    private String categoriaUsuario;
    private String cargo;
    private String sexo;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String UF;
    private String telefone;
    private String email;
    private TipoUsuario tipoUsuario;
    private ArrayList <Emprestimo> emprestimos = new ArrayList<>();
   
    public Usuario(){}

    public Usuario(String cpf, String nomeCompleto, String nomeUsuario, String senha, String matricula, String categoriaUsuario, String cargo, String sexo, String logradouro, String bairro, String cidade, String UF, String telefone, String email, TipoUsuario tipoUsuario) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.matricula = matricula;
        this.categoriaUsuario = categoriaUsuario;
        this.cargo = cargo;
        this.sexo = sexo;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
        this.telefone = telefone;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCategoriaUsuario() {
        return categoriaUsuario;
    }

    public void setCategoriaUsuario(String categoriaUsuario) {
        this.categoriaUsuario = categoriaUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList <Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList <Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cpf=" + cpf + ", nomeCompleto=" + nomeCompleto + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", matricula=" + matricula + ", categoriaUsuario=" + categoriaUsuario + ", cargo=" + cargo + ", sexo=" + sexo + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", UF=" + UF + ", telefone=" + telefone + ", email=" + email + ", tipoUsuario=" + tipoUsuario + ", emprestimos=" + emprestimos + '}';
    }
    //O método recebe os dados de um usuario e chama o métodos UsuarioIsExistis, que verifica se o usuario
    //já existe, caso o retorno do método for verdadeiro, chama-se o método inserir que envia os dados para
    //o banco de dados do sistema
     public void salvar(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean isExistis = UsuarioIsExistis(usuario);
        if (isExistis != true) {
            usuarioDAO.cadastrarUsuario(usuario);
        } else {
        }
    }
 //O método recebe um usuario e chama o método alterUsuario que faz a alteração dos dados do usuario no BD
    public void alterar(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.alterarUsuario(usuario);
    }
    //O método verifica se usuario recebido por parâmetro já está cadastrado, caso já esteja
    //ele não poderá ser cadastrado, caso contrário o usuario é cadastrado no BD do sistema
    public boolean UsuarioIsExistis(Usuario usuario) throws SQLException {
        Usuario usuario1 = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuario1 = usuarioDAO.selecionarUsuarioporUsuarioeSenha(usuario.getNomeUsuario(), usuario.getSenha());
        if (usuario1.equals(usuario)) {
            System.out.println("Usuario já existe!");
            JOptionPane.showMessageDialog(null, "Usuário já existe!");
            return true;
        } else if (usuario1 == null) {
            System.out.println("Usuario cadastrado com sucesso!");
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        }
        return false;
    }
    //O método recebe um usuario, valida-o e retorna true caso o usuario e senha informados estejam cadastrados
    public boolean autenticarUsuario(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario1 = usuarioDAO.validarUsuario(usuario);
        if (usuario.getNomeUsuario().equals(usuario1.getNomeUsuario()) && usuario.getSenha().equals(usuario1.getSenha())) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario selecionarUsuario(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario1 = new Usuario();
        usuario1 = usuarioDAO.selecionarUsuarioporUsuarioeSenha(usuario.getNomeUsuario(), usuario.getSenha());
        return usuario1;
    }
}
