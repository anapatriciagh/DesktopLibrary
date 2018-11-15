/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprestimo;


import Exemplar.Exemplar;
import Operador.Operador;
import Usuario.Usuario;
import Usuario.UsuarioDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Ana PAtrícia
 */
public class Emprestimo{
    private int codigoEmprestimo;
    private Date dataEmprestimo;
    private Time horaEmprestimo;
    private Date dataPrevistaDevolucao;
    private Exemplar exemplar;
    private Operador operador;
    private Usuario usuario;
    
    private final int categoriaAluno = 7;
    private final int categoriaProfessor = 15;
    private final int categoriaServidorAdministrativo = 15;

    public Emprestimo(int codigoEmprestimo, Date dataEmprestimo,  Date dataPrevistaDevolucao, Exemplar exemplar, Operador operador, Usuario usuario) {
        this.codigoEmprestimo = codigoEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.exemplar = exemplar;
        this.operador = operador;
        this.usuario = usuario;
    }
    public  Emprestimo(){}

    public int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(int codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "codigoEmprestimo=" + codigoEmprestimo + ", dataEmprestimo=" + dataEmprestimo + ", horaEmprestimo=" + horaEmprestimo + ", dataPrevistaDevolucao=" + dataPrevistaDevolucao + ", exemplar=" + exemplar + ", operador=" + operador + ", usuario=" + usuario + '}';
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Time getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(Time horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }
    
  /*Recebe um emprestimo e chama o método que busca um emprestimo por exemplar*/
  public Emprestimo emprestimoExemplar(Emprestimo emprestimo) throws SQLException{
        Emprestimo emprestimo1 = new Emprestimo();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimo1 = emprestimoDAO.buscarEmprestimoporExemplar(emprestimo);
        return emprestimo1;
    }
  /*Recebe um emprestimo e chama o método que o insere no banco de dados da aplicação*/
  public void salvar(Emprestimo emprestimo) throws SQLException, JRException{
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimoDAO.insertEmprestimo(emprestimo);
    }
  /*REtorna a quantidade de dias de um emprestimo, de acordo com o tipo de usuario do usuario recebido*/
  public int returnQuantidadeDiasEmprestimo(String nomeUsuario, String senha) throws SQLException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario1 = new Usuario();
        usuario1 = usuarioDAO.selecionarUsuarioporUsuarioeSenha(nomeUsuario, senha);
        if(getCategoria(usuario1).equals("aluno")){
            return categoriaAluno;
        }else if(getCategoria(usuario1).equals("professor")){
            return categoriaProfessor;
        }else
            return  categoriaServidorAdministrativo;
    }
  /*recebe um usuario e retorna sua categoria*/
    public String getCategoria(Usuario usuario){
            return usuario.getCategoriaUsuario();
    }
    
}
