package com.leonardogabriel.apileituraintegrada.service;

import com.leonardogabriel.apileituraintegrada.entity.*;
import com.leonardogabriel.apileituraintegrada.enums.StatusLeitura;
import com.leonardogabriel.apileituraintegrada.repository.ObraRepository;
import com.leonardogabriel.apileituraintegrada.repository.filtro.ObraFiltros;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObraService {
    private final ObraRepository repository;

    public ObraService (ObraRepository repository) {
        this.repository = repository;
    }

    public void salvarObra (Obra obra) {
        if (!obra.verificar())
            throw new IllegalArgumentException("A obra foi informada incorretamente");
        if(repository.existsByTituloAndFormato(obra.getTitulo(), obra.getFormato()))
            throw new IllegalArgumentException("A obra informada já foi cadastrada no sistema!");
        repository.save(obra);
    }

    public List<Obra> listarTodasObras (
            String titulo,
            Integer idFormato,
            StatusLeitura statusLeitura) {

        Specification<Obra> filtro = Specification.unrestricted();

        if (!(titulo ==  null || titulo.isBlank()))
             filtro = filtro.and(ObraFiltros.contemTitulo(titulo));

        if (!(idFormato == null || idFormato <= 0))
            filtro = filtro.and(ObraFiltros.contemFormato(idFormato));

        if (!(statusLeitura == null))
            filtro = filtro.and(ObraFiltros.contemStatusLeitura(statusLeitura));

        return repository.findAll(filtro);
    }

    public Obra listarObra(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido"));
    }

    public Obra alterarObra (Obra novaObra) {
        Obra obra = repository.findById(novaObra.getId()).orElseThrow(() -> new IllegalArgumentException("Id inválido!"));

        if (!novaObra.verificar())
            throw new IllegalArgumentException("Obra inválida!");

        // Verifica se o título e formato são iguais e em caso de mudança verifica se o nome está disponível
        if (!obra.equals(novaObra) && repository.existsByTituloAndFormato(obra.getTitulo(), obra.getFormato()))
            throw new IllegalArgumentException("Obra igual há outra obra cadastrada!");

        obra = novaObra;
        repository.save(obra);
        return obra;
    }
}