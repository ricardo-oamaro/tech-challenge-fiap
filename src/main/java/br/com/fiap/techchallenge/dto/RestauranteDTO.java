package br.com.fiap.techchallenge.dto;


public record RestauranteDTO (
    Long id,
    String nome,
    String tipoCozinha,
    DonoRestauranteDTO donoRestaurante
){}
