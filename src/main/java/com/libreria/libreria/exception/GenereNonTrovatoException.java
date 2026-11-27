package com.libreria.libreria.exception;

public class GenereNonTrovatoException extends RuntimeException {

    // Constructor
    public GenereNonTrovatoException(String nome) {
        super("Genere con nome: " + nome + " non trovato");
    }

     public GenereNonTrovatoException(Integer id) {
        super("Genere con id: " + id + " non trovato");
    }
}
