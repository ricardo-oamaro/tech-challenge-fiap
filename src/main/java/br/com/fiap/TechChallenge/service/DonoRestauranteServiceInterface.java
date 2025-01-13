package br.com.fiap.TechChallenge.service;

import br.com.fiap.TechChallenge.model.DonoRestaurante;
import java.util.List;

public interface DonoRestauranteServiceInterface {

    DonoRestaurante save(DonoRestaurante donoRestaurante);

    DonoRestaurante updateDonoRestaurante(Long id, DonoRestaurante updatedDonoRestaurante);

    DonoRestaurante findById(Long id);

    List<DonoRestaurante> findAllByOrderByIdAsc();

    DonoRestaurante findByNome(String nome);

    List<DonoRestaurante> findAllByOrderByNomeAsc();

    List<DonoRestaurante> findAllByOrderByEmailAsc();

    DonoRestaurante findByEmail(String email);

    List<DonoRestaurante> findAllByOrderByEnderecoAsc();

    List<DonoRestaurante> findAllByOrderByDataUltimaAlteracaoAsc();

    Long deleteDonoRestaurante(Long id);
}
