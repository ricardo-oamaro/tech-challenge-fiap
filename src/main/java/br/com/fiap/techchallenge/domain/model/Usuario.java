package br.com.fiap.techchallenge.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Integer id;
    private String usuario;
    private String senha;
    private Pessoa pessoa;

}