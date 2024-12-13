package br.com.fiap.techchallenge.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.fiap.techchallenge.domain.model.Usuario;

public interface UsuarioRepository {

    Optional<Usuario> findById(Long id);

    List<Usuario> findAll(int size, int offset);

    Integer save(Usuario usuario);

    Integer update(Usuario usuario, Long id);

    Integer delete(Long id);

}
