package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.exception.ResourceNotFoundException;
import br.com.fiap.techchallenge.model.ClienteRestaurante;
import br.com.fiap.techchallenge.repository.ClienteRestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("clienteRestauranteServiceImpl")
public class ClienteRestauranteServiceImpl implements ClienteRestauranteServiceInterface {

    @Autowired
    private ClienteRestauranteRepository clienteRestauranteRepository;

    @Override
    public ClienteRestaurante save(ClienteRestaurante clienteRestaurante) {
        return clienteRestauranteRepository.save(clienteRestaurante);
    }

    @Override
    public ClienteRestaurante updateClienteRestaurante(Long id, ClienteRestaurante updatedClienteRestaurante) {
        Optional<ClienteRestaurante> optionalClienteRestaurante = clienteRestauranteRepository.findById(id);
        if (optionalClienteRestaurante.isPresent()) {
            ClienteRestaurante existingClienteRestaurante = optionalClienteRestaurante.get();
            if (updatedClienteRestaurante.getNome() != null) {
                existingClienteRestaurante.setNome(updatedClienteRestaurante.getNome());
            }
            if (updatedClienteRestaurante.getEmail() != null) {
                existingClienteRestaurante.setEmail(updatedClienteRestaurante.getEmail());
            }
            if (updatedClienteRestaurante.getLogin() != null) {
                existingClienteRestaurante.setLogin(updatedClienteRestaurante.getLogin());
            }
            if (updatedClienteRestaurante.getSenha() != null) {
                existingClienteRestaurante.setSenha(updatedClienteRestaurante.getSenha());
            }
            if (updatedClienteRestaurante.getEndereco() != null) {
                existingClienteRestaurante.setEndereco(updatedClienteRestaurante.getEndereco());
            }
            existingClienteRestaurante.setDataUltimaAlteracao(new Date());
            return clienteRestauranteRepository.save(existingClienteRestaurante);
        } else {
            throw new ResourceNotFoundException("Cliente do Restaurante com id " + id + " não foi localizado");
        }
    }

    @Override
    public ClienteRestaurante findById(Long id) {
        return clienteRestauranteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Cliente do Restaurante com id " + id + " não foi localizado"));
    }

    @Override
    public List<ClienteRestaurante> findAllByOrderByIdAsc() {
        return clienteRestauranteRepository.findAllByOrderByIdAsc();
    }

    @Override
    public ClienteRestaurante findByNome(String nome) {
        return clienteRestauranteRepository.findByNome(nome);
    }

    @Override
    public List<ClienteRestaurante> findAllByOrderByNomeAsc() {
        return clienteRestauranteRepository.findAllByOrderByNomeAsc();
    }

    @Override
    public List<ClienteRestaurante> findAllByOrderByEmailAsc() {
        return clienteRestauranteRepository.findAllByOrderByEmailAsc();
    }

    @Override
    public ClienteRestaurante findByEmail(String email) {
        return clienteRestauranteRepository.findByEmail(email);
    }

    @Override
    public List<ClienteRestaurante> findAllByOrderByEnderecoAsc() {
        return clienteRestauranteRepository.findAllByOrderByEnderecoAsc();
    }

    @Override
    public List<ClienteRestaurante> findAllByOrderByDataUltimaAlteracaoAsc() {
        return clienteRestauranteRepository.findAllByOrderByDataUltimaAlteracaoAsc();
    }

    @Override
    public Long deleteClienteRestaurante(Long id) {
        if (clienteRestauranteRepository.existsById(id)) {
            clienteRestauranteRepository.deleteById(id);
            return id;
        } else {
            throw new ResourceNotFoundException("Cliente do Restaurante com id " + id + " não foi localizado");
        }
    }
}