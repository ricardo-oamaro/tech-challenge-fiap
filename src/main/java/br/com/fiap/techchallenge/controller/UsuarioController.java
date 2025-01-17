package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.UsuarioResumoDTO;
import br.com.fiap.techchallenge.model.DonoRestaurante;
import br.com.fiap.techchallenge.model.Usuario;
import br.com.fiap.techchallenge.service.UsuarioServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceInterface usuarioServiceInterface;

    @PostMapping
    public Usuario create(@Valid @RequestBody Usuario usuario) {
        return usuarioServiceInterface.save(usuario);
    }

    @PostMapping("/validar-login")
    public ResponseEntity<String> validarLogin(@RequestParam String login, @RequestParam String senha) {
        boolean loginValido = usuarioServiceInterface.validarLogin(login, senha);
        if (loginValido) {
            return ResponseEntity.ok("Login válido");
        } else {
            return ResponseEntity.status(401).body("Login inválido");
        }
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<String> alterarSenha(@RequestParam String login,@RequestParam String senhaAntiga, @RequestParam String novaSenha) {
        boolean senhaAlterada = usuarioServiceInterface.alterarSenha(login, senhaAntiga,novaSenha);
        if (senhaAlterada) {
            return ResponseEntity.ok("Senha alterada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Usuário/Senha inválidos");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUsuario(@PathVariable Long id) {
        Long deletedId = usuarioServiceInterface.deleteUsuario(id);
        return ResponseEntity.ok(deletedId);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        List<UsuarioResumoDTO> usuarios = usuarioServiceInterface.listarUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(404).body("Nenhum usuário encontrado");
        }
        return ResponseEntity.ok(usuarios);
    }
}
