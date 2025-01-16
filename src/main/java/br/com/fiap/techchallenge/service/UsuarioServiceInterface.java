package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.model.DonoRestaurante;
import br.com.fiap.techchallenge.model.Usuario;

import java.util.List;

public interface UsuarioServiceInterface {

    Usuario save(Usuario usuario);

    Usuario updateUsuario(Long id, Usuario updatedUsuario);

    Usuario findById(Long id);

    Usuario findByNome(String nome);

    Usuario findByEmail(String email);

    List<Usuario> findAllByOrderByIdAsc();

    List<Usuario> findAllByOrderByNomeAsc();

    List<Usuario> findAllByOrderByEmailAsc();

    List<Usuario> findAllByOrderByEnderecoAsc();

    List<Usuario> findAllByOrderByDataUltimaAlteracaoAsc();

    Long deleteUsuario(Long id);

}
