package br.com.fiap.techchallenge.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

     //http://localhost:8080/pessoas?page=1&size=10
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size

    ) {
        var pessoas = this.pessoasService.findAllPessoas(page, size);
        return ResponseEntity.ok(pessoas);

    }

    // http://localhost:8080/pessoas/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findPessoa(
            @PathVariable("id") Long id) {
        var pessoas = this.pessoasService.findPessoaById(id);
        return ResponseEntity.ok(Optional.ofNullable(pessoas));
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(
            @RequestBody Pessoa pessoa) {
        this.pessoasService.savePessoa(pessoa);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable("id") Long id,
            @RequestBody Pessoa pessoa) {
        this.pessoasService.updatePessoa(pessoa, id);
        return ResponseEntity.noContent().build();

    }

        @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(
            @PathVariable("id") Long id

    ) {
        this.pessoasService.delete(id);
        return ResponseEntity.ok().build();
    }
}
