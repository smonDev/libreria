package com.libreria.libreria.exception;

import com.libreria.libreria.dto.LibroRequest;

public class LibroNonTrovatoException extends RuntimeException {

    //Constructor
    public LibroNonTrovatoException(Integer isbn) {
        super("Libro con isbn: " + isbn + " non trovato");
    }

    public LibroNonTrovatoException(LibroRequest libroRequest, Integer isbn) {
        super("Libro con isbn: " + libroRequest.getIsbn() + " non trovato");
    }

}
