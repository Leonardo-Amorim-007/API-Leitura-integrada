package com.leonardogabriel.apileituraintegrada.controller;

import com.leonardogabriel.apileituraintegrada.entity.Obra;
import com.leonardogabriel.apileituraintegrada.enums.StatusLeitura;
import com.leonardogabriel.apileituraintegrada.service.ObraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraController {
    private final ObraService service;

    public ObraController (ObraService service) {
        this.service = service;
    }

    @PostMapping
    public String criarObra (@RequestBody Obra obra) {
        service.salvarObra(obra);
        return "Obra cadastra com sucesso!";
    }

    @GetMapping
    public List<Obra> consultaObras (
            @RequestParam(required=false) String titulo,
            @RequestParam(required=false) Integer idFormato,
            @RequestParam(required=false) StatusLeitura statusLeitura) {
        return service.listarTodasObras(titulo, idFormato, statusLeitura);
    }

    @GetMapping("{id}")
    public Obra consultarObra (@PathVariable Integer id){
        return service.listarObra(id);
    }

    @PutMapping
    public Obra alterarObra (@RequestBody Obra obra) {
        return service.alterarObra(obra);
    }
}
