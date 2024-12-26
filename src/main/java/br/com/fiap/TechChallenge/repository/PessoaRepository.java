package br.com.fiap.TechChallenge.repository;

import br.com.fiap.TechChallenge.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
