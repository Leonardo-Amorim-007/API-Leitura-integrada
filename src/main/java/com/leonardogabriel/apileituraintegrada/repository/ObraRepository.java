package com.leonardogabriel.apileituraintegrada.repository;

import com.leonardogabriel.apileituraintegrada.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Integer>, JpaSpecificationExecutor<Obra> {
    boolean existsByTituloAndFormato(String titulo, Formato formato);
}
