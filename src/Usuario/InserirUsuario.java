/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.sql.SQLException;

/**
 *
 * @author Ana PAtrícia
 */
public class InserirUsuario {
    public static void main(String[] args) throws SQLException {
        
        Usuario usuario = new Usuario();
        usuario.setCpf("299.222.222-77");
        usuario.setMatricula("000000");
        usuario.setNomeCompleto("João Batista");
        usuario.setNomeUsuario("joao");
        usuario.setSenha("joao");
        usuario.setCategoriaUsuario("Servidor Administrativo");
        usuario.setCargo("Servidor Administrativo");
        usuario.setSexo("masculino");
        usuario.setLogradouro("Av. 23 de Maio");
        usuario.setBairro("Santa Efigênia");
        usuario.setCidade("São Paulo");
        usuario.setUF("SP");
        usuario.setTelefone("(11)8134-5678");
        usuario.setEmail("joao@gmail.com");
        
        usuario.salvar(usuario);
        //metodosUsuario.alterar(usuario);
    }
}
