package com.leonardogabriel.apileituraintegrada.repository.filtro;

import com.leonardogabriel.apileituraintegrada.entity.Obra;
import com.leonardogabriel.apileituraintegrada.enums.StatusLeitura;
import org.springframework.data.jpa.domain.Specification;

public class ObraFiltros {
    public static Specification<Obra> contemTitulo (String titulo) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%");
    }

    // Filtro do formato das obras
    public static Specification<Obra> contemFormato (Integer idFormato){
        return (root, query, cb) ->
                cb.equal(root.get("formato").get("id"), idFormato);
    }

    public static Specification<Obra> contemStatusLeitura (StatusLeitura statusLeitura){
        return (root, query, cb) ->
        cb.equal(root.get("statusLeitura"), statusLeitura);
    }
}
