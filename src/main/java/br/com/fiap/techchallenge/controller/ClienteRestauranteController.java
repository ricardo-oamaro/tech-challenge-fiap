package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.ClienteRestauranteDTO;
import br.com.fiap.techchallenge.model.ClienteRestaurante;
import br.com.fiap.techchallenge.service.ClienteRestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente-restaurante")
public class ClienteRestauranteController {

    @Autowired
    private ClienteRestauranteService clienteRestauranteService;

    @PostMapping
    public ClienteRestaurante create(@Valid @RequestBody ClienteRestaurante clienteRestaurante) {
        return clienteRestauranteService.save(clienteRestaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteRestauranteDTO> updateClienteRestaurante(@PathVariable Long id, @RequestBody ClienteRestaurante updatedClienteRestaurante) {
        ClienteRestaurante updatedEntity = clienteRestauranteService.updateClienteRestaurante(id, updatedClienteRestaurante);
        if (updatedEntity != null) {
            ClienteRestauranteDTO dto = new ClienteRestauranteDTO(
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
    public ResponseEntity<ClienteRestauranteDTO> getById(@PathVariable Long id) {
        ClienteRestaurante clienteRestaurante = clienteRestauranteService.findById(id);
        ClienteRestauranteDTO dto = new ClienteRestauranteDTO(
                clienteRestaurante.getId(),
                clienteRestaurante.getNome(),
                clienteRestaurante.getEmail(),
                clienteRestaurante.getLogin(),
                clienteRestaurante.getEndereco(),
                clienteRestaurante.getDataUltimaAlteracao()
        );
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/ids")
    public ResponseEntity<?> getAllByOrderByIdAsc() {
        List<ClienteRestaurante> clientesRestaurantes = clienteRestauranteService.findAllByOrderByIdAsc();
        if (clientesRestaurantes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clientes de restaurantes cadastrados");
        }
        List<ClienteRestauranteDTO> dtoList = clientesRestaurantes.stream()
                .map(cliente -> new ClienteRestauranteDTO(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getLogin(),
                        cliente.getEndereco(),
                        cliente.getDataUltimaAlteracao()
                ))
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/nome/{nome}")
    public ClienteRestaurante getByNome(@PathVariable String nome) {
        return clienteRestauranteService.findByNome(nome);
    }

    @GetMapping("/nomes")
    public List<ClienteRestaurante> getAllByOrderByNomeAsc() {
        return clienteRestauranteService.findAllByOrderByNomeAsc();
    }

    @GetMapping("/email/{email}")
    public ClienteRestaurante getByEmail(@PathVariable String email) {
        ClienteRestaurante byEmail = clienteRestauranteService.findByEmail(email);
        return byEmail;
    }

    @GetMapping("/emails")
    public List<ClienteRestaurante> getAllByOrderByEmailAsc() {
        return clienteRestauranteService.findAllByOrderByEmailAsc();
    }

    @GetMapping("/endereco/{endereco}")
    public ClienteRestaurante getByEndereco(@PathVariable String endereco) {
        ClienteRestaurante byEndereco = clienteRestauranteService.findByEndereco(endereco);
        return byEndereco;
    }

    @GetMapping("/enderecos")
    public List<ClienteRestaurante> getAllByOrderByEnderecoAsc() {
        return clienteRestauranteService.findAllByOrderByEnderecoAsc();
    }

    @GetMapping("/data-ultima-alteracao")
    public List<ClienteRestaurante> getAllByOrderByDataUltimaAlteracaoAsc() {
        return clienteRestauranteService.findAllByOrderByDataUltimaAlteracaoAsc();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteClienteRestaurante(@PathVariable Long id) {
        Long deletedId = clienteRestauranteService.deleteClienteRestaurante(id);
        return ResponseEntity.ok(deletedId);
    }

}
