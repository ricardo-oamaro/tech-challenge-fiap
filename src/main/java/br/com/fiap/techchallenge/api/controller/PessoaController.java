package br.com.fiap.techchallenge.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techchallenge.domain.model.Pessoa;
import br.com.fiap.techchallenge.infrastructure.services.PessoasService;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoasService pessoasService;

    public PessoaController(PessoasService pessoasService) {
        this.pessoasService = pessoasService;
    }

    /**
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size

    ) {
        var pessoas = this.pessoasService.findAllPessoas(page, size);
        return ResponseEntity.ok(pessoas);

    }
}
