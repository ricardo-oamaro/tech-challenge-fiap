package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.RestauranteDTO;
import br.com.fiap.techchallenge.mapper.RestauranteMapper;
import br.com.fiap.techchallenge.model.Restaurante;
import br.com.fiap.techchallenge.service.RestauranteServiceInterface;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteServiceInterface restauranteService;

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> getAll() {
        List<Restaurante> restaurantes = restauranteService.findAll();
        List<RestauranteDTO> dtoList = restaurantes.stream()
                .map(RestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<RestauranteDTO> create(@Valid @RequestBody RestauranteDTO restauranteDTO) {
        Restaurante restaurante = RestauranteMapper.toEntity(restauranteDTO);
        Restaurante savedRestaurante = restauranteService.save(restaurante);
        RestauranteDTO dto = RestauranteMapper.toDTO(savedRestaurante);
        return ResponseEntity.ok(dto);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDTO> update(@PathVariable Long id, @RequestBody RestauranteDTO restauranteDTO) {
        Restaurante restaurante = RestauranteMapper.toEntity(restauranteDTO);
        Restaurante updatedRestaurante = restauranteService.updateRestaurante(id, restaurante);
        RestauranteDTO dto = RestauranteMapper.toDTO(updatedRestaurante);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        Long deletedId = restauranteService.deleteRestaurante(id);
        return ResponseEntity.ok(deletedId);
    }

}
