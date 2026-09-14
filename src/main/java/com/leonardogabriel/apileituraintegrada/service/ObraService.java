package com.leonardogabriel.apileituraintegrada.service;

import com.leonardogabriel.apileituraintegrada.entity.*;
import com.leonardogabriel.apileituraintegrada.repository.ObraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObraService {
    private final ObraRepository repository;

    public ObraService (ObraRepository repository) {
        this.repository = repository;
    }

    public void salvarObra (Obra obra) {
        repository.save(obra);
    }

    public List<Obra> listarTodasObras () {
        return repository.findAll();
    }
}