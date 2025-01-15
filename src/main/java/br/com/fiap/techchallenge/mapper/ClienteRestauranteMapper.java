package br.com.fiap.techchallenge.mapper;

import br.com.fiap.techchallenge.dto.ClienteRestauranteDTO;
import br.com.fiap.techchallenge.model.ClienteRestaurante;

public class ClienteRestauranteMapper {

    public static ClienteRestauranteDTO toDTO(ClienteRestaurante clienteRestaurante) {
        return new ClienteRestauranteDTO(
                clienteRestaurante.getId(),
                clienteRestaurante.getNome(),
                clienteRestaurante.getEmail(),
                clienteRestaurante.getLogin(),
                clienteRestaurante.getEndereco(),
                clienteRestaurante.getDataUltimaAlteracao());
    }

    public static ClienteRestaurante toEntity(ClienteRestauranteDTO dto) {
        ClienteRestaurante clienteRestaurante = new ClienteRestaurante();
        clienteRestaurante.setId(dto.getId());
        clienteRestaurante.setNome(dto.getNome());
        clienteRestaurante.setEmail(dto.getEmail());
        clienteRestaurante.setLogin(dto.getLogin());
        clienteRestaurante.setEndereco(dto.getEndereco());
        clienteRestaurante.setDataUltimaAlteracao(dto.getDataUltimaAlteracao());
        return clienteRestaurante;
    }
}