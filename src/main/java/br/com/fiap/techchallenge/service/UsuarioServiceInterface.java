package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.UsuarioResumoDTO;
import br.com.fiap.techchallenge.model.Usuario;

import java.util.List;

public interface UsuarioServiceInterface {

    Usuario save(Usuario usuario);

    Usuario updateUsuario(Long id, Usuario updatedUsuario);

    Long deleteUsuario(Long id);

    boolean validarLogin(String login, String senha);

    boolean alterarSenha(String login, String senhaAntiga, String novaSenha);

    List<UsuarioResumoDTO> listarUsuarios();
}