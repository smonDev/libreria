package com.libreria.libreria.exception;

public class CopiaNonTrovataException extends RuntimeException {

    public CopiaNonTrovataException(Integer id) {
        super("Errore, copia con id: " + id + " non trovata");
    }
}
