package br.com.fiap.techchallenge.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Pessoa {
    private Integer id;
    private String nome;
    private LocalDateTime dataUltimaAlteracao;
    private String email;
    private Integer tipo;
    private Endereco endereco;

}