package br.com.fiap.TechChallenge.service;

import br.com.fiap.TechChallenge.model.Usuario;
import br.com.fiap.TechChallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarLogin(String login, String senha) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByPessoaLogin(login);
        return usuarioEncontrado.isPresent() &&
               usuarioEncontrado.get().getPessoa().getSenha().equals(senha);
    }

    public boolean alterarSenha(String login, String novaSenha) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByPessoaLogin(login);
        if (usuarioEncontrado.isPresent()) {
            Usuario user = usuarioEncontrado.get();
            user.getPessoa().setSenha(novaSenha);
            usuarioRepository.save(user);
            return true;
        }
        return false;
    }
}
