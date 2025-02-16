package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.service.RestauranteServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteServiceInterface restauranteService;

}
