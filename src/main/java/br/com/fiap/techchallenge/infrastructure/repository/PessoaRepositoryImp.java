package br.com.fiap.techchallenge.infrastructure.repository;

import br.com.fiap.techchallenge.domain.model.Pessoa;
import br.com.fiap.techchallenge.domain.repository.PessoaRepository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryImp implements PessoaRepository {

    private final JdbcClient jdbcClient;

    public PessoaRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoa WHERE id = :id")
                .param("id", id)
                .query(Pessoa.class)
                .optional();

    }

    @Override
    public List<Pessoa> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoa LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Pessoa.class)
                .list();
    }

    @Override
    public Integer save(Pessoa pessoa) {
        return this.jdbcClient
                .sql("INSERT INTO pessoa (nome, data_ultima_alteracao, email, tipo, endereco_id) VALUES (:nome, :data_ultima_alteracao, :email, :tipo, :endereco_id)")
                .param("nome", pessoa.getNome())
                .param("data_ultima_alteracao", pessoa.getDataUltimaAlteracao())
                .param("email", pessoa.getEmail())
                .param("tipo", pessoa.getTipo())
                .param("endereco_id", pessoa.getEndereco())
                .update();
    }

    @Override
    public Integer update(Pessoa pessoa, Long id) {
        return this.jdbcClient
                .sql("UPDATE pessoa SET nome = ?, data_ultima_alteracao = ?, email = ?, tipo = ?, endereco_id = ? WHERE id = ?")
                .params(pessoa.getNome(), pessoa.getDataUltimaAlteracao(), pessoa.getEmail(), pessoa.getTipo(), pessoa.getEndereco(), id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM pessoas WHERE id = :id")
                .param("id", id)
                .update();
    }

}
