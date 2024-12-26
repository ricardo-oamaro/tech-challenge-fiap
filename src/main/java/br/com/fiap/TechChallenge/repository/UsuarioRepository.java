package br.com.fiap.TechChallenge.repository;

import br.com.fiap.TechChallenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByPessoaLogin(String login);
}
