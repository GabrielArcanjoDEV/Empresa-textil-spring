package br.edu.aula.produtos.controller;

import br.edu.aula.produtos.entity.Producao;
import br.edu.aula.produtos.repository.ProducaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/producoes")
public class ProducaoController {

    private final ProducaoRepository repository;

    public ProducaoController(ProducaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producao criar(@RequestBody Producao producao) {
        return repository.save(producao);
    }

    @GetMapping
    public List<Producao> listar() {
        return repository.findAll();
    }
}