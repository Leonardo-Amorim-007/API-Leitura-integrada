package com.leonardogabriel.apileituraintegrada.repository;

import com.leonardogabriel.apileituraintegrada.entity.Formato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatoRepository extends JpaRepository<Formato, Integer> {
    boolean existsByFormato (String formato);
}
