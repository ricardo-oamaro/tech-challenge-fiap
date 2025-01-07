package br.com.fiap.techchallenge.service;

import br.com.fiap.TechChallenge.exception.ResourceNotFoundException;
import br.com.fiap.TechChallenge.model.DonoRestaurante;
import br.com.fiap.TechChallenge.repository.DonoRestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DonoRestauranteService {

    @Autowired
    private DonoRestauranteRepository donoRestauranteRepository;

    public DonoRestaurante save(DonoRestaurante donoRestaurante) {
        return donoRestauranteRepository.save(donoRestaurante);
    }

    public DonoRestaurante findById(Long id) {
        return donoRestauranteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dono do Restaurante com id " + id + " não foi localizado"));
    }

    public List<DonoRestaurante> findAllByOrderByIdAsc() {
        return donoRestauranteRepository.findAllByOrderByIdAsc();
    }

    public DonoRestaurante updateDonoRestaurante(Long id, DonoRestaurante updatedDonoRestaurante) {
        Optional<DonoRestaurante> optionalDonoRestaurante = donoRestauranteRepository.findById(id);
        if (optionalDonoRestaurante.isPresent()) {
            DonoRestaurante existingDonoRestaurante = optionalDonoRestaurante.get();
            if (updatedDonoRestaurante.getNome() != null) {
                existingDonoRestaurante.setNome(updatedDonoRestaurante.getNome());
            }
            if (updatedDonoRestaurante.getEmail() != null) {
                existingDonoRestaurante.setEmail(updatedDonoRestaurante.getEmail());
            }
            if (updatedDonoRestaurante.getLogin() != null) {
                existingDonoRestaurante.setLogin(updatedDonoRestaurante.getLogin());
            }
            if (updatedDonoRestaurante.getSenha() != null) {
                existingDonoRestaurante.setSenha(updatedDonoRestaurante.getSenha());
            }
            if (updatedDonoRestaurante.getEndereco() != null) {
                existingDonoRestaurante.setEndereco(updatedDonoRestaurante.getEndereco());
            }
            existingDonoRestaurante.setDataUltimaAlteracao(new Date());
            return donoRestauranteRepository.save(existingDonoRestaurante);
        } else {
            throw new ResourceNotFoundException("Dono do Restaurante com id " + id + " não foi localizado");
        }
    }

    public DonoRestaurante findByNome(String nome) {
        return donoRestauranteRepository.findByNome(nome);
    }

    public List<DonoRestaurante> findAllByOrderByNomeAsc() {
        return donoRestauranteRepository.findAllByOrderByNomeAsc();
    }

    public DonoRestaurante findByEmail(String email) {
        return donoRestauranteRepository.findByEmail(email);
    }

    public List<DonoRestaurante> findAllByOrderByEmailAsc() {
        return donoRestauranteRepository.findAllByOrderByEmailAsc();
    }

    public DonoRestaurante findByEndereco(String endereco) {
        return donoRestauranteRepository.findByEndereco(endereco);
    }

    public List<DonoRestaurante> findAllByOrderByEnderecoAsc() {
        return donoRestauranteRepository.findAllByOrderByEnderecoAsc();
    }

    public List<DonoRestaurante> findAllByOrderByDataUltimaAlteracaoAsc() {
        return donoRestauranteRepository.findAllByOrderByDataUltimaAlteracaoAsc();
    }

    public Long deleteDonoRestaurante(Long id) {
        if (donoRestauranteRepository.existsById(id)) {
            donoRestauranteRepository.deleteById(id);
            return id;
        } else {
            throw new ResourceNotFoundException("Dono do Restaurante com id " + id + " não foi localizado");
        }
    }

}
