package br.com.fiap.techchallenge.mapper;

import br.com.fiap.techchallenge.dto.UsuarioDTO;
import br.com.fiap.techchallenge.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getLogin(),
                usuario.getEndereco(),
                usuario.getDataUltimaAlteracao()
        );
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setLogin(dto.getLogin());
        usuario.setEndereco(dto.getEndereco());
        usuario.setDataUltimaAlteracao(dto.getDataUltimaAlteracao());
        return usuario;
    }
}
