package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.model.Restaurante;
import br.com.fiap.techchallenge.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements  RestauranteServiceInterface {

    private final RestauranteRepository restauranteRepository;

    @Override
    public Restaurante save(Restaurante restaurante) {
        return null;
    }

    @Override
    public Restaurante updateRestaurante(Long id, Restaurante updatedRestaurante) {
        return null;
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
        return null;
    }
}
