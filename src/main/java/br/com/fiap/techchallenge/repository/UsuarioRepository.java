package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByOrderByIdAsc();

    Usuario findByNome(String nome);

    List<Usuario> findAllByOrderByNomeAsc();

    Usuario findByEmail(String email);

    List<Usuario> findAllByOrderByEmailAsc();

    Usuario findByEndereco(String endereco);

    List<Usuario> findAllByOrderByEnderecoAsc();

    List<Usuario> findAllByOrderByDataUltimaAlteracaoAsc();

}
