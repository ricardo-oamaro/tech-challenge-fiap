package br.com.fiap.techchallenge.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.fiap.techchallenge.domain.model.Endereco;

public interface EnderecoRepository {

    Optional<Endereco> findById(Long id);

    List<Endereco> findAll(int size, int offset);

    Integer save(Endereco endereco);

    Integer update(Endereco endereco, Long id);

    Integer delete(Long id);

}