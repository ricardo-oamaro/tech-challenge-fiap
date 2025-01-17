package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}