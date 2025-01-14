package br.com.fiap.TechChallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
