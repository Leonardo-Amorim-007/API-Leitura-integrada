package com.leonardogabriel.apileituraintegrada.entity;

import jakarta.persistence.*;
import com.leonardogabriel.apileituraintegrada.functions.*;

@Entity
public class Formato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String formato;

    // Método SET
    public void setFormato (String formato) {
        if (formato.isBlank())
            throw new IllegalArgumentException("O campo de formato não pode estar vazio!");
        if (formato.length() > 50)
            throw new IllegalArgumentException("O formato não pode conter mais de 50 caracteres");

        this.formato = formato.toLowerCase();
    }

    // Método GET
    public int getId () {return id;}
    public String getFormato () {return TextFunctions.LetraMaiscula(formato);}

    // Funções da entidade
    public boolean verificar () {
        return formato.isBlank();
    }
}
