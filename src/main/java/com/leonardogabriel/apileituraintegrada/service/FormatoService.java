package com.leonardogabriel.apileituraintegrada.service;

import com.leonardogabriel.apileituraintegrada.entity.Formato;
import com.leonardogabriel.apileituraintegrada.repository.FormatoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FormatoService {
    private final FormatoRepository repository;

    public FormatoService (FormatoRepository repository) {this.repository = repository;}

    public void cadastrarFormato (Formato formato) {
        if (formato.verificar())
            throw new IllegalArgumentException("O formato foi enviado incorretamente!");
        if (repository.existsByFormato(formato.getFormato()))
            throw new IllegalArgumentException("O Formato já foi cadastrado");
       repository.save(formato);
    }

    public List<Formato> consultarObras () {
        return repository.findAll();
    }

    public Formato consultarObra (Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido!"));
    }

    public void alterarFormato (Formato novoFormato) {
        if (novoFormato.verificar())
            throw new IllegalArgumentException("O formato foi enviado incorretamente");

        Formato formato = repository.findById(novoFormato.getId()).orElseThrow(() -> new IllegalArgumentException("Id inválido!"));
        formato.setFormato(novoFormato.getFormato());

        repository.save(formato);
    }

    public void deletarFormato (Formato formato) {
        Formato formato2 = repository.findById(formato.getId()).orElseThrow(() -> new IllegalArgumentException("Id inválido"));

        if (!formato.getFormato().equalsIgnoreCase(formato2.getFormato()))
            throw new IllegalArgumentException("O formato é inválido para exclusão!");

        repository.delete(formato);
    }
}
