package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.ClienteRestauranteDTO;
import br.com.fiap.techchallenge.dto.DonoRestauranteDTO;
import br.com.fiap.techchallenge.mapper.ClienteRestauranteMapper;
import br.com.fiap.techchallenge.mapper.DonoRestauranteMapper;
import br.com.fiap.techchallenge.model.ClienteRestaurante;
import br.com.fiap.techchallenge.model.DonoRestaurante;
import br.com.fiap.techchallenge.service.ClienteRestauranteServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente-restaurante")
public class ClienteRestauranteController {

    @Qualifier("clienteRestauranteServiceImpl")
    @Autowired
    private ClienteRestauranteServiceInterface clienteRestauranteService;

    @PostMapping
    public ClienteRestaurante create(@Valid @RequestBody ClienteRestaurante clienteRestaurante) {
        return clienteRestauranteService.save(clienteRestaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteRestauranteDTO> updateClienteRestaurante(@PathVariable Long id, @RequestBody ClienteRestaurante updatedClienteRestaurante) {
        ClienteRestaurante updatedEntity = clienteRestauranteService.updateClienteRestaurante(id, updatedClienteRestaurante);
        if (updatedEntity != null) {
            ClienteRestauranteDTO dto = ClienteRestauranteMapper.toDTO(updatedEntity);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteRestauranteDTO> getById(@PathVariable Long id) {
        ClienteRestaurante clienteRestaurante = clienteRestauranteService.findById(id);
        ClienteRestauranteDTO dto = ClienteRestauranteMapper.toDTO(clienteRestaurante);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/ids")
    public ResponseEntity<?> getAllByOrderByIdAsc() {
        List<ClienteRestaurante> clientesRestaurantes = clienteRestauranteService.findAllByOrderByIdAsc();
        if (clientesRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clientes de restaurantes não cadastrados");
        }
        List<ClienteRestauranteDTO> dtoList = clientesRestaurantes.stream()
                .map(ClienteRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/nome")
    public ResponseEntity<ClienteRestauranteDTO> getByNome(@RequestParam String nome) {
        ClienteRestaurante clienteRestaurante = clienteRestauranteService.findByNome(nome);
        if (clienteRestaurante != null) {
            ClienteRestauranteDTO dto = ClienteRestauranteMapper.toDTO(clienteRestaurante);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/nomes")
    public ResponseEntity<?> getAllByOrderByNomeAsc() {
        List<ClienteRestaurante> clientesRestaurantes = clienteRestauranteService.findAllByOrderByNomeAsc();
        if (clientesRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe nenhum cliente de restaurante cadastrado");
        }
        List<ClienteRestauranteDTO> dtoList = clientesRestaurantes.stream()
                .map(ClienteRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/emails")
    public ResponseEntity<List<ClienteRestauranteDTO>> getAllByOrderByEmailAsc() {
        List<ClienteRestaurante> clientesRestaurantes = clienteRestauranteService.findAllByOrderByEmailAsc();
        if (clientesRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<ClienteRestauranteDTO> dtoList = clientesRestaurantes.stream()
                .map(ClienteRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/email")
    public ResponseEntity<ClienteRestauranteDTO> getByEmail(@RequestParam String email) {
        ClienteRestaurante clienteRestaurante = clienteRestauranteService.findByEmail(email);
        if (clienteRestaurante != null) {
            ClienteRestauranteDTO dto = ClienteRestauranteMapper.toDTO(clienteRestaurante);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<ClienteRestauranteDTO>> getAllByOrderByEnderecoAsc() {
        List<ClienteRestaurante> clientesRestaurantes = clienteRestauranteService.findAllByOrderByEnderecoAsc();
        if (clientesRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<ClienteRestauranteDTO> dtoList = clientesRestaurantes.stream()
                .map(ClienteRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/data-ultima-alteracao")
    public ResponseEntity<List<ClienteRestauranteDTO>> getAllByOrderByDataUltimaAlteracaoAsc() {
        List<ClienteRestaurante> clientesRestaurantes = clienteRestauranteService
                .findAllByOrderByDataUltimaAlteracaoAsc();
        if (clientesRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<ClienteRestauranteDTO> dtoList = clientesRestaurantes.stream()
                .map(ClienteRestauranteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteClienteRestaurante(@PathVariable Long id) {
        Long deletedId = clienteRestauranteService.deleteClienteRestaurante(id);
        return ResponseEntity.ok(deletedId);
    }
}