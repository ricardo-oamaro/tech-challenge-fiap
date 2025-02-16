package br.com.fiap.techchallenge.mapper;

import br.com.fiap.techchallenge.dto.RestauranteDTO;
import br.com.fiap.techchallenge.model.Restaurante;

public class RestauranteMapper {

    public static RestauranteDTO toDTO(Restaurante restaurante) {
        return new RestauranteDTO(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getTipoCozinha(),
                DonoRestauranteMapper.toDTO(restaurante.getDonoRestaurante())
        );
    }

    public static Restaurante toEntity(RestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setId(dto.id());
        restaurante.setNome(dto.nome());
        restaurante.setTipoCozinha(dto.tipoCozinha());
        restaurante.setDonoRestaurante(DonoRestauranteMapper.toEntity(dto.donoRestaurante()));
        return restaurante;
    }
}
