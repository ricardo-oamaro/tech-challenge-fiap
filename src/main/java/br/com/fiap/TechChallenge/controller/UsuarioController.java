package br.com.fiap.TechChallenge.controller;

import br.com.fiap.TechChallenge.model.Usuario;
import br.com.fiap.TechChallenge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> criarUsuario(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String login,
            @RequestParam String senha,
            @RequestParam String endereco) {

        Usuario novoUsuario = usuarioService.criarUsuario(nome, email, login, senha, endereco);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> validarLogin(@RequestParam String login, @RequestParam String senha) {
        boolean loginValido = usuarioService.validarLogin(login, senha);
        if (loginValido) {
            return ResponseEntity.ok("Login válido");
        } else {
            return ResponseEntity.status(401).body("Login inválido");
        }
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<String> alterarSenha(@RequestParam String login, @RequestParam String novaSenha) {
        boolean senhaAlterada = usuarioService.alterarSenha(login, novaSenha);
        if (senhaAlterada) {
            return ResponseEntity.ok("Senha alterada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }
    }
}
