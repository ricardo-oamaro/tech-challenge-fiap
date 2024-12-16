package br.com.fiap.techchallenge.infrastructure.services;

import br.com.fiap.techchallenge.domain.model.Pessoa;
import br.com.fiap.techchallenge.domain.repository.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    public Pessoa findPessoaById(Long id) {
        return this.pessoaRepository.findById(id).orElse(null);
    }

    public void savePessoa(Pessoa pessoa) {
        var save = this.pessoaRepository.save(pessoa);
        Assert.state(save == 1, "Erro ao salvar pessoa" + pessoa.getNome());
    }

    public void updatePessoa(Pessoa pessoa, Long id) {
        var update = this.pessoaRepository.update(pessoa, id);
        if (update == 0) {
            throw new RuntimeException("Pessoa nao encontrada");
        }
    }

    public void delete(Long id) {
        var delete = this.pessoaRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Pessoa nao encontrada");
        }
    }
}
