package br.com.fiap.TechChallenge.repository;

import br.com.fiap.TechChallenge.model.DonoRestaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonoRestauranteRepository extends JpaRepository<DonoRestaurante, Long> {

    List<DonoRestaurante> findAllByOrderByIdAsc();

    DonoRestaurante findByNome(String nome);

    List<DonoRestaurante> findAllByOrderByNomeAsc();

    DonoRestaurante findByEmail(String email);

    List<DonoRestaurante> findAllByOrderByEmailAsc();

    DonoRestaurante findByEndereco(String endereco);

    List<DonoRestaurante> findAllByOrderByEnderecoAsc();

    List<DonoRestaurante> findAllByOrderByDataUltimaAlteracaoAsc();

}