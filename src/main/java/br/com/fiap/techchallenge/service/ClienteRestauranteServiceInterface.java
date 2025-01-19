package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.model.ClienteRestaurante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteRestauranteServiceInterface {

    ClienteRestaurante save(ClienteRestaurante clienteRestaurante);

    ClienteRestaurante updateClienteRestaurante(Long id, ClienteRestaurante updatedClienteRestaurante);

    ClienteRestaurante findById(Long id);

    ClienteRestaurante findByNome(String nome);

    ClienteRestaurante findByEmail(String email);

    List<ClienteRestaurante> findAllByOrderByIdAsc();

    List<ClienteRestaurante> findAllByOrderByNomeAsc();

    List<ClienteRestaurante> findAllByOrderByEmailAsc();

    List<ClienteRestaurante> findAllByOrderByEnderecoAsc();

    List<ClienteRestaurante> findAllByOrderByDataUltimaAlteracaoAsc();

    Long deleteClienteRestaurante(Long id);
}