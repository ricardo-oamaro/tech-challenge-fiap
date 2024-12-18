package br.com.fiap.TechChallenge.controller;

import br.com.fiap.TechChallenge.dto.DonoRestauranteDTO;
import br.com.fiap.TechChallenge.model.DonoRestaurante;
import br.com.fiap.TechChallenge.service.DonoRestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dono-restaurante")
public class DonoRestauranteController {

    @Autowired
    private DonoRestauranteService donoRestauranteService;

    @PostMapping
    public DonoRestaurante create(@Valid @RequestBody DonoRestaurante donoRestaurante) {
        return donoRestauranteService.save(donoRestaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonoRestauranteDTO> updateDonoRestaurante(@PathVariable Long id, @RequestBody DonoRestaurante updatedDonoRestaurante) {
        DonoRestaurante updatedEntity = donoRestauranteService.updateDonoRestaurante(id, updatedDonoRestaurante);
        if (updatedEntity != null) {
            DonoRestauranteDTO dto = new DonoRestauranteDTO(
                    updatedEntity.getId(),
                    updatedEntity.getNome(),
                    updatedEntity.getEmail(),
                    updatedEntity.getLogin(),
                    updatedEntity.getEndereco(),
                    updatedEntity.getDataUltimaAlteracao()
            );
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonoRestauranteDTO> getById(@PathVariable Long id) {
        DonoRestaurante donoRestaurante = donoRestauranteService.findById(id);
        DonoRestauranteDTO dto = new DonoRestauranteDTO(
                donoRestaurante.getId(),
                donoRestaurante.getNome(),
                donoRestaurante.getEmail(),
                donoRestaurante.getLogin(),
                donoRestaurante.getEndereco(),
                donoRestaurante.getDataUltimaAlteracao()
        );
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/ids")
    public List<DonoRestaurante> getAllByOrderByIdAsc() {
        return donoRestauranteService.findAllByOrderByIdAsc();
    }

    @GetMapping("/nome/{nome}")
    public DonoRestaurante getByNome(@PathVariable String nome) {
        return donoRestauranteService.findByNome(nome);
    }

    @GetMapping("/nomes")
    public List<DonoRestaurante> getAllByOrderByNomeAsc() {
        return donoRestauranteService.findAllByOrderByNomeAsc();
    }

    @GetMapping("/email/{email}")
    public DonoRestaurante getByEmail(@PathVariable String email) {
        return donoRestauranteService.findByEmail(email);
    }

    @GetMapping("/emails")
    public List<DonoRestaurante> getAllByOrderByEmailAsc() {
        return donoRestauranteService.findAllByOrderByEmailAsc();
    }

    @GetMapping("/endereco/{endereco}")
    public DonoRestaurante getByEndereco(@PathVariable String endereco) {
        return donoRestauranteService.findByEndereco(endereco);
    }

    @GetMapping("/enderecos")
    public List<DonoRestaurante> getAllByOrderByEnderecoAsc() {
        return donoRestauranteService.findAllByOrderByEnderecoAsc();
    }

    @GetMapping("/data-ultima-alteracao")
    public List<DonoRestaurante> getAllByOrderByDataUltimaAlteracaoAsc() {
        return donoRestauranteService.findAllByOrderByDataUltimaAlteracaoAsc();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDonoRestaurante(@PathVariable Long id) {
        Long deletedId = donoRestauranteService.deleteDonoRestaurante(id);
        return ResponseEntity.ok(deletedId);
    }

}
