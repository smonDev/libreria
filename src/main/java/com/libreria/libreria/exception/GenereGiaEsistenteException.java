package com.libreria.libreria.exception;

public class GenereGiaEsistenteException extends RuntimeException {

    public GenereGiaEsistenteException(String nome) {
        super("Errore, inserito genere con nome: " + nome + " già esistente");
    }

}
