package br.com.fiap.techchallenge.mapper;

import br.com.fiap.techchallenge.dto.DonoRestauranteDTO;
import br.com.fiap.techchallenge.model.DonoRestaurante;

public class DonoRestauranteMapper {

    public static DonoRestauranteDTO toDTO(DonoRestaurante donoRestaurante) {
        return new DonoRestauranteDTO(
                donoRestaurante.getId(),
                donoRestaurante.getNome(),
                donoRestaurante.getEmail(),
                donoRestaurante.getLogin(),
                donoRestaurante.getEndereco(),
                donoRestaurante.getDataUltimaAlteracao()
        );
    }

    public static DonoRestaurante toEntity(DonoRestauranteDTO dto) {
        DonoRestaurante donoRestaurante = new DonoRestaurante();
        donoRestaurante.setId(dto.getId());
        donoRestaurante.setNome(dto.getNome());
        donoRestaurante.setEmail(dto.getEmail());
        donoRestaurante.setLogin(dto.getLogin());
        donoRestaurante.setEndereco(dto.getEndereco());
        donoRestaurante.setDataUltimaAlteracao(dto.getDataUltimaAlteracao());
        return donoRestaurante;
    }
}