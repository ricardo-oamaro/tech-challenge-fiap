package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.DonoRestauranteDTO;
import br.com.fiap.techchallenge.mapper.DonoRestauranteMapper;
import br.com.fiap.techchallenge.model.DonoRestaurante;
import br.com.fiap.techchallenge.service.DonoRestauranteServiceInterface;
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
    private DonoRestauranteServiceInterface donoRestauranteService;

    @PostMapping
    public DonoRestaurante create(@Valid @RequestBody DonoRestaurante donoRestaurante) {
        return donoRestauranteService.save(donoRestaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonoRestauranteDTO> updateDonoRestaurante(@PathVariable Long id, @RequestBody DonoRestaurante updatedDonoRestaurante) {
        DonoRestaurante updatedEntity = donoRestauranteService.updateDonoRestaurante(id, updatedDonoRestaurante);
        if (updatedEntity != null) {
            DonoRestauranteDTO dto = DonoRestauranteMapper.toDTO(updatedEntity);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonoRestauranteDTO> getById(@PathVariable Long id) {
        DonoRestaurante donoRestaurante = donoRestauranteService.findById(id);
        DonoRestauranteDTO dto = DonoRestauranteMapper.toDTO(donoRestaurante);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/ids")
    public ResponseEntity<?> getAllByOrderByIdAsc() {
        List<DonoRestaurante> donosRestaurantes = donoRestauranteService.findAllByOrderByIdAsc();
        if (donosRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Donos de restaurantes não cadastrados");
        }
        List<DonoRestauranteDTO> dtoList = donosRestaurantes.stream()
                .map(DonoRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/nome")
    public ResponseEntity<DonoRestauranteDTO> getByNome(@RequestParam String nome) {
        DonoRestaurante donoRestaurante = donoRestauranteService.findByNome(nome);
        if (donoRestaurante != null) {
            DonoRestauranteDTO dto = DonoRestauranteMapper.toDTO(donoRestaurante);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/nomes")
    public ResponseEntity<List<DonoRestauranteDTO>> getAllByOrderByNomeAsc() {
        List<DonoRestaurante> donosRestaurantes = donoRestauranteService.findAllByOrderByNomeAsc();
        if (donosRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<DonoRestauranteDTO> dtoList = donosRestaurantes.stream()
                .map(DonoRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/emails")
    public ResponseEntity<List<DonoRestauranteDTO>> getAllByOrderByEmailAsc() {
        List<DonoRestaurante> donosRestaurantes = donoRestauranteService.findAllByOrderByEmailAsc();
        if (donosRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<DonoRestauranteDTO> dtoList = donosRestaurantes.stream()
                .map(DonoRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/email")
    public ResponseEntity<DonoRestauranteDTO> getByEmail(@RequestParam String email) {
        DonoRestaurante donoRestaurante = donoRestauranteService.findByEmail(email);
        if (donoRestaurante != null) {
            DonoRestauranteDTO dto = DonoRestauranteMapper.toDTO(donoRestaurante);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<DonoRestauranteDTO>> getAllByOrderByEnderecoAsc() {
        List<DonoRestaurante> donosRestaurantes = donoRestauranteService.findAllByOrderByEnderecoAsc();
        if (donosRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<DonoRestauranteDTO> dtoList = donosRestaurantes.stream()
                .map(DonoRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/data-ultima-alteracao")
    public ResponseEntity<List<DonoRestauranteDTO>> getAllByOrderByDataUltimaAlteracaoAsc() {
        List<DonoRestaurante> donosRestaurantes = donoRestauranteService.findAllByOrderByDataUltimaAlteracaoAsc();
        if (donosRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<DonoRestauranteDTO> dtoList = donosRestaurantes.stream()
                .map(DonoRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDonoRestaurante(@PathVariable Long id) {
        Long deletedId = donoRestauranteService.deleteDonoRestaurante(id);
        return ResponseEntity.ok(deletedId);
    }
}