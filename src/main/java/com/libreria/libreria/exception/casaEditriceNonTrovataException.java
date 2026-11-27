package com.libreria.libreria.exception;

public class casaEditriceNonTrovataException extends RuntimeException {
    
    public casaEditriceNonTrovataException(String nome) {
        super("Errore, casa editrice con nome: " + nome + " non trovata");
    }

    public casaEditriceNonTrovataException(Integer id) {
        super("Errore, casa editrice con nome: " + id + " non trovata");
    }


}
