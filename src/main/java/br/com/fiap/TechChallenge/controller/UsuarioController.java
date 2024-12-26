package br.com.fiap.TechChallenge.controller;

import br.com.fiap.TechChallenge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> validarLogin(@RequestParam String usuario, @RequestParam String senha) {
        boolean loginValido = usuarioService.validarLogin(usuario, senha);
        if (loginValido) {
            return ResponseEntity.ok("Login válido");
        } else {
            return ResponseEntity.status(401).body("Login inválido");
        }
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<String> alterarSenha(@RequestParam String usuario, @RequestParam String novaSenha) {
        boolean senhaAlterada = usuarioService.alterarSenha(usuario, novaSenha);
        if (senhaAlterada) {
            return ResponseEntity.ok("Senha alterada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }
    }
}
