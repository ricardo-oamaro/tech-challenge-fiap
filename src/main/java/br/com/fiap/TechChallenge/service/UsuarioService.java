package br.com.fiap.TechChallenge.service;

import br.com.fiap.TechChallenge.model.Pessoa;
import br.com.fiap.TechChallenge.model.Usuario;
import br.com.fiap.TechChallenge.repository.PessoaRepository;
import br.com.fiap.TechChallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    // Criação de um novo usuário
    public Usuario criarUsuario(String nome, String email, String login, String senha, String endereco) {
        // Cria uma nova Pessoa
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(nome);
        novaPessoa.setEmail(email);
        novaPessoa.setLogin(login);
        novaPessoa.setSenha(senha);
        novaPessoa.setEndereco(endereco);

        // Salva a Pessoa no banco de dados
        Pessoa pessoaSalva = pessoaRepository.save(novaPessoa);

        // Cria um novo Usuario associado à Pessoa
        Usuario novoUsuario = new Usuario();
        novoUsuario.setPessoa(pessoaSalva);

        // Salva o Usuario no banco de dados
        return usuarioRepository.save(novoUsuario);
    }

    // Validação do login
    public boolean validarLogin(String login, String senha) {
        return usuarioRepository.findByPessoaLogin(login)
                .map(usuario -> usuario.getPessoa().getSenha().equals(senha))
                .orElse(false);
    }

    // Alteração de senha
    public boolean alterarSenha(String login, String novaSenha) {
        return usuarioRepository.findByPessoaLogin(login).map(usuario -> {
            usuario.getPessoa().setSenha(novaSenha);
            pessoaRepository.save(usuario.getPessoa());
            return true;
        }).orElse(false);
    }
}
