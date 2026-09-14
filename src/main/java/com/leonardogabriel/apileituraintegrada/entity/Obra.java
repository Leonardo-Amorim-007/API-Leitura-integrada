package com.leonardogabriel.apileituraintegrada.entity;

import com.leonardogabriel.apileituraintegrada.enums.StatusLeitura;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String autor;

    @Enumerated(EnumType.STRING)
    private StatusLeitura statusLeitura;

    private LocalDate inicioLeitura;
    private LocalDate fimLeitura;

    @ManyToOne
    @JoinColumn(name="id_formato")
    private Formato formato;

    public Obra () {}

    // Métodos SET
    public void setTitulo (String titulo) {
        if (titulo.isBlank())
            throw new IllegalArgumentException("O título não pode estar vazio");
        if (titulo.length() > 150)
            throw new IllegalArgumentException("O título não pode ter mais de 150 caracteres!");

        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor.isBlank())
            throw new IllegalArgumentException("O autor não pode estar vazio!");
        if (autor.length() > 100)
            throw new IllegalArgumentException("O autor não pode ter mais de 100 caracteres!");

        this.autor = autor;
    }

    public void setStatusLeitura (StatusLeitura statusLeitura) {
        this.statusLeitura = statusLeitura;
    }

    public void setInicioLeitura (LocalDate date) {
        if (date.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("A data de início não pode ser posterior a hoje!");

        inicioLeitura = date;
    }

    public void setFimLeitura (LocalDate date) {
        if (inicioLeitura == null)
            throw new IllegalArgumentException("Não pode cadastrar fim de leitra antes da data de início de leitura!");
        if (date.isBefore(inicioLeitura))
            throw new IllegalArgumentException("Não pode cadastrar a data de fim de leitura anterior ao início de leitura!");

        fimLeitura = date;
    }

    public void setFormato (Formato formato) {
        this.formato = formato;
    }

    // Métodos GET
    public int getId () {return id;}

    public String getTitulo () {return titulo;}

    public String getAutor () {return autor;}

    public StatusLeitura getStatusLeitura () {return statusLeitura;}

    public LocalDate getInicioLeitura () {return inicioLeitura;}

    public LocalDate getFimLeitura () {return fimLeitura;}

    public Formato getFormato () {return formato;}
}