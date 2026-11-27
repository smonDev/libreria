package com.libreria.libreria.exception;

import com.libreria.libreria.dto.request.LibroRequest;

public class LibroGiaEsistenteException extends RuntimeException {

    //Constructor
    public LibroGiaEsistenteException(LibroRequest libroRequest) {
        super("Errore, non è possibile aggiungere questo libro. Esiste già un libro con questo identificativo");
    }
}
