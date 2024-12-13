package br.com.fiap.techchallenge.infrastructure.repository.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import br.com.fiap.techchallenge.domain.model.Pessoa;

@Service
public class PessoasService {

    public List<Pessoa> findAll() {
       Pessoa pessoa1 = new Pessoa();
       pessoa1.setNome("Alfredo");
       List listaPessoa = new ArrayList<>();
       listaPessoa.add(listaPessoa);
       return listaPessoa;  
    }

}
