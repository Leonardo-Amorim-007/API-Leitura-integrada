package com.leonardogabriel.apileituraintegrada.functions;

public class TextFunctions {
    public static String LetraMaiscula (String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
