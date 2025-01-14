package br.com.fiap.TechChallenge.repository;

import br.com.fiap.TechChallenge.model.ClienteRestaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRestauranteRepository extends JpaRepository<ClienteRestaurante, Long> {

    List<ClienteRestaurante> findAllByOrderByIdAsc();

    ClienteRestaurante findByNome(String nome);

    List<ClienteRestaurante> findAllByOrderByNomeAsc();

    ClienteRestaurante findByEmail(String email);

    List<ClienteRestaurante> findAllByOrderByEmailAsc();

    ClienteRestaurante findByEndereco(String endereco);

    List<ClienteRestaurante> findAllByOrderByEnderecoAsc();

    List<ClienteRestaurante> findAllByOrderByDataUltimaAlteracaoAsc();
}