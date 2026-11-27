package com.libreria.libreria.exception;

public class AutoreNonTrovatoException extends RuntimeException {
    public AutoreNonTrovatoException(Integer id) {
        super("Errore, autore con id " + id + " non esistente");
    }

    public AutoreNonTrovatoException(String messaggio) {
        super(messaggio);
    }
}
