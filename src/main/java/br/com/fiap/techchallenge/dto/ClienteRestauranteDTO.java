package br.com.fiap.techchallenge.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRestauranteDTO {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String endereco;
    private Date dataUltimaAlteracao;
}
