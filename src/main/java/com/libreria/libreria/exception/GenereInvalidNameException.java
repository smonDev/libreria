package com.libreria.libreria.exception;

public class GenereInvalidNameException extends RuntimeException {

    public GenereInvalidNameException(String nome) {
        super("Errore, Inserito nome: " + nome + ". Il nome non è valido!");
    }
}
