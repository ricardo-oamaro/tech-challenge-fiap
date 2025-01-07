package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.model.DonoRestaurante;
import br.com.fiap.techchallenge.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByLogin(String login);
}