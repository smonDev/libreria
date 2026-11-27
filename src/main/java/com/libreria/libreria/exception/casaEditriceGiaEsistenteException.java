package com.libreria.libreria.exception;

import com.libreria.libreria.dto.request.casaEditriceRequest;

public class casaEditriceGiaEsistenteException extends RuntimeException {
    public casaEditriceGiaEsistenteException(casaEditriceRequest casaEditriceRequest) {
        super("Errore, inserita casa editrice con nome: " + casaEditriceRequest.getNome() + "già esistente!");
    }
}
