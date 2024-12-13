package br.com.fiap.techchallenge.api.controller;

import java.util.List;
import br.com.fiap.techchallenge.domain.model.Pessoa;
import br.com.fiap.techchallenge.infrastructure.repository.services.PessoasService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoasService pessoasService;

    public PessoaController(PessoasService pessoasService) {
        this.pessoasService = pessoasService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){

        List<Pessoa> all = pessoasService.findAll();
        return ResponseEntity.ok(all);
    }
}
