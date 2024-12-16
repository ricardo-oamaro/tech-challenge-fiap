package br.com.fiap.techchallenge.infrastructure.services;

import br.com.fiap.techchallenge.domain.model.Pessoa;
import br.com.fiap.techchallenge.domain.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoasService {

    private final PessoaRepository pessoaRepository;

    public PessoasService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public List<Pessoa> findAllPessoas(int page, int size) {
        int offset = (page - 1) * size;
        return this.pessoaRepository.findAll(size, offset);
    }

}
