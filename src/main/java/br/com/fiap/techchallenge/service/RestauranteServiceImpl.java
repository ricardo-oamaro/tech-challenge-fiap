package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.exception.ResourceNotFoundException;
import br.com.fiap.techchallenge.model.Restaurante;
import br.com.fiap.techchallenge.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements  RestauranteServiceInterface {

    private final RestauranteRepository restauranteRepository;

    @Override
    public Restaurante save(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante updateRestaurante(Long id, Restaurante updatedRestaurante) {
        Optional<Restaurante> optionalRestaurante = restauranteRepository.findById(id);
        if (optionalRestaurante.isPresent()) {
            Restaurante existingRestaurante = optionalRestaurante.get();
            if (updatedRestaurante.getNome() != null) {
                existingRestaurante.setNome(updatedRestaurante.getNome());
            }
            if (updatedRestaurante.getEndereco() != null) {
                existingRestaurante.setEndereco(updatedRestaurante.getEndereco());
            }
            if (updatedRestaurante.getTipoCozinha() != null) {
                existingRestaurante.setTipoCozinha(updatedRestaurante.getTipoCozinha());
            }
            if (updatedRestaurante.getDonoRestaurante() != null) {
                existingRestaurante.setDonoRestaurante(updatedRestaurante.getDonoRestaurante());
            }
            return restauranteRepository.save(existingRestaurante);
        } else {
            return null;
        }
    }

    @Override
    public Restaurante findById(Long id) {
        return null;
    }

    @Override
    public Restaurante findByNome(String nome) {
        return null;
    }

    @Override
    public Restaurante findByTipoCozinha(String tipoCozinha) {
        return null;
    }

    @Override
    public List<Restaurante> findAllByOrderByIdAsc() {
        return null;
    }

    @Override
    public List<Restaurante> findAllByOrderByNomeAsc() {
        return null;
    }

    @Override
    public List<Restaurante> findAllByOrderByTipoCozinhaAsc() {
        return null;
    }

    @Override
    public List<Restaurante> findAllByOrderByEnderecoAsc() {
        return null;
    }

    @Override
    public List<Restaurante> findAllByOrderByDonoRestauranteAsc() {
        return null;
    }

    @Override
    public List<Restaurante> findAllByOrderByDataUltimaAlteracaoAsc() {
        return null;
    }

    @Override
    public Long deleteRestaurante(Long id) {
        if (restauranteRepository.existsById(id)) {
            restauranteRepository.deleteById(id);
            return id;
        } else {
            throw new ResourceNotFoundException("Restaurante com id " + id + " não foi localizado");
        }
    }

    @Override
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }
}
