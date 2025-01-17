package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.dto.UsuarioResumoDTO;
import br.com.fiap.techchallenge.exception.ResourceNotFoundException;
import br.com.fiap.techchallenge.model.Usuario;
import br.com.fiap.techchallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario existingUsuario = optionalUsuario.get();
            if (updatedUsuario.getNome() != null) {
                existingUsuario.setNome(updatedUsuario.getNome());
            }
            if (updatedUsuario.getEmail() != null) {
                existingUsuario.setEmail(updatedUsuario.getEmail());
            }
            if (updatedUsuario.getLogin() != null) {
                existingUsuario.setLogin(updatedUsuario.getLogin());
            }
            if (updatedUsuario.getSenha() != null) {
                existingUsuario.setSenha(updatedUsuario.getSenha());
            }
            if (updatedUsuario.getEndereco() != null) {
                existingUsuario.setEndereco(updatedUsuario.getEndereco());
            }
            existingUsuario.setDataUltimaAlteracao(new Date());
            return usuarioRepository.save(existingUsuario);
        } else {
            throw new ResourceNotFoundException("Usuário com id " + id + " não foi localizado");
        }
    }

    @Override
    public Long deleteUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return id;
        } else {
            throw new ResourceNotFoundException("Usuário com id " + id + " não foi localizado");
        }
    }

    @Override
    public boolean validarLogin(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    @Override
    public boolean alterarSenha(String login, String senhaAntiga, String novaSenha) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario != null && usuario.getSenha().equals(senhaAntiga)) {
            usuario.setSenha(novaSenha);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    @Override
    public List<UsuarioResumoDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioResumoDTO(usuario.getNome(), usuario.getEmail(), usuario.getLogin()))
                .sorted(Comparator.comparing(UsuarioResumoDTO::getNome))
                .collect(Collectors.toList());
    }
}