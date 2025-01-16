package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.exception.ResourceNotFoundException;
import br.com.fiap.techchallenge.model.Usuario;
import br.com.fiap.techchallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com id " + id + " não foi localizado"));
    }

    @Override
    public List<Usuario> findAllByOrderByIdAsc() {
        return usuarioRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Usuario findByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    @Override
    public List<Usuario> findAllByOrderByNomeAsc() {
        return usuarioRepository.findAllByOrderByNomeAsc();
    }

    @Override
    public List<Usuario> findAllByOrderByEmailAsc() {
        return usuarioRepository.findAllByOrderByEmailAsc();
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> findAllByOrderByEnderecoAsc() {
        return usuarioRepository.findAllByOrderByEnderecoAsc();
    }

    @Override
    public List<Usuario> findAllByOrderByDataUltimaAlteracaoAsc() {
        return usuarioRepository.findAllByOrderByDataUltimaAlteracaoAsc();
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
}