package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.model.Restaurante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestauranteServiceInterface {
    Restaurante save(Restaurante restaurante);

    Restaurante updateRestaurante(Long id, Restaurante updatedRestaurante);

    Restaurante findById(Long id);

    Restaurante findByNome(String nome);

    Restaurante findByTipoCozinha(String tipoCozinha);

    List<Restaurante> findAllByOrderByIdAsc();

    List<Restaurante> findAllByOrderByNomeAsc();

    List<Restaurante> findAllByOrderByTipoCozinhaAsc();

    List<Restaurante> findAllByOrderByEnderecoAsc();

    List<Restaurante> findAllByOrderByDonoRestauranteAsc();

    List<Restaurante> findAllByOrderByDataUltimaAlteracaoAsc();

    Long deleteRestaurante(Long id);
}
