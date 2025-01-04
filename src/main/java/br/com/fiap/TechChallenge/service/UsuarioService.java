package br.com.fiap.TechChallenge.service;

import br.com.fiap.TechChallenge.model.Pessoa;
import br.com.fiap.TechChallenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public boolean alterarSenha(String login, String senhaAntiga, String novaSenha) {
        Pessoa pessoaBusca = pessoaRepository.findByLogin(login);
        if (pessoaBusca != null && pessoaBusca.getSenha().equals(senhaAntiga)) {
            pessoaBusca.setSenha(novaSenha);
            pessoaBusca.setDataUltimaAlteracao(new Date());
            pessoaRepository.save(pessoaBusca);
            return true;
        }
        return false;
    }

    public boolean validarLogin(String login, String senha) {
        Pessoa pessoa = pessoaRepository.findByLogin(login);
        if (pessoa != null && pessoa.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }
}