package com.libreria.libreria.exception;

public class AutoreGiaEsistenteException extends RuntimeException {
    public AutoreGiaEsistenteException (String autore) {
        super("Errore, autore con nome " + autore + " già esistente!");
    }
}
