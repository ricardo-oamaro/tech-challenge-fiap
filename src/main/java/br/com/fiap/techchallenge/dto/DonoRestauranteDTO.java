package br.com.fiap.techchallenge.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonoRestauranteDTO {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String endereco;
    private Date dataUltimaAlteracao;
}
