package br.com.fiap.techchallenge.infrastructure.repository;

import br.com.fiap.techchallenge.domain.model.Usuario;
import br.com.fiap.techchallenge.domain.repository.UsuarioRepository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {

    private final JdbcClient jdbcClient;

    public UsuarioRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM usuario WHERE id = :id")
                .param("id", id)
                .query(Usuario.class)
                .optional();

    }

    @Override
    public List<Usuario> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM usuario LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Usuario.class)
                .list();
    }

    @Override
    public Integer save(Usuario usuario) {
        return this.jdbcClient
                .sql("INSERT INTO usuario (usuario, senha, pessoa_id) VALUES (:usuario, :senha, :pessoa_id)")
                .param("usuario", usuario.getUsuario())
                .param("senha", usuario.getSenha())
                .param("pessoa_id", usuario.getPessoa().getId())
                .update();
    }

    @Override
    public Integer update(Usuario usuario, Long id) {
        return this.jdbcClient
                .sql("UPDATE usuario SET usuario = ?, senha = ?, pessoa_id WHERE id = ?")
                .params(usuario.getUsuario(), usuario.getSenha(), usuario.getPessoa().getId(), id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM usuario WHERE id = :id")
                .param("id", id)
                .update();
    }

}
