package com.leonardogabriel.apileituraintegrada.controller;

import com.leonardogabriel.apileituraintegrada.entity.Formato;
import com.leonardogabriel.apileituraintegrada.service.FormatoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/formato")
public class FormatoController {
    private final FormatoService service;

    public FormatoController (FormatoService service) {this.service = service;}

    @PostMapping
    public String cadastrarFormato (@RequestBody Formato formato) {
        service.cadastrarFormato(formato);
        return "Formato cadastrado com sucesso!";
    }

    @PutMapping
    public String alterarFormato (@RequestBody Formato formato) {
        service.alterarFormato(formato);
        return "Formato alterado com sucesso!";
    }

    @GetMapping
    public List<Formato> consultarObras () {
        return service.consultarObras();
    }

    @GetMapping("/{id}")
    public Formato consultarObra (@PathVariable Integer id) {
        return service.consultarObra(id);
    }

    @DeleteMapping
    public String deletarFormato (@RequestBody Formato formato) {
        service.deletarFormato(formato);
        return "Formato deletado com sucesso!";
    }
}