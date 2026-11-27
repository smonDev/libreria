package com.libreria.libreria.exception;

import com.libreria.libreria.dto.casaEditriceRequest;

public class casaEditriceInvalidNameException extends RuntimeException {
    public casaEditriceInvalidNameException(casaEditriceRequest casaEditriceRequest) {
        super("Errore, inserita casa editrice con nome: " + casaEditriceRequest.getNome() + ". Il campo inserito non è valido!");
    }
}
