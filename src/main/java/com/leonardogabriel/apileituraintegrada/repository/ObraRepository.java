package com.leonardogabriel.apileituraintegrada.repository;

import com.leonardogabriel.apileituraintegrada.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Integer> {
    boolean existsByTituloAndFormato(String titulo, Formato formato);
}
