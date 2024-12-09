package br.com.fiap.techchallenge.domain.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    private Integer id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String numero;
    private String complemento;

}