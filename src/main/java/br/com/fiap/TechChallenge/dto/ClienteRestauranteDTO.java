package br.com.fiap.TechChallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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
