package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.model.DonoRestaurante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonoRestauranteServiceInterface {

    DonoRestaurante save(DonoRestaurante donoRestaurante);

    DonoRestaurante updateDonoRestaurante(Long id, DonoRestaurante updatedDonoRestaurante);

    DonoRestaurante findById(Long id);

    DonoRestaurante findByNome(String nome);

    DonoRestaurante findByEmail(String email);

    List<DonoRestaurante> findAllByOrderByIdAsc();

    List<DonoRestaurante> findAllByOrderByNomeAsc();

    List<DonoRestaurante> findAllByOrderByEmailAsc();

    List<DonoRestaurante> findAllByOrderByEnderecoAsc();

    List<DonoRestaurante> findAllByOrderByDataUltimaAlteracaoAsc();

    Long deleteDonoRestaurante(Long id);
}