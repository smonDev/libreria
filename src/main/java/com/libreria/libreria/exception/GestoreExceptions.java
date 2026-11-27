package com.libreria.libreria.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Annotazione a cui Spring farà riferimento per gestire tutte le Eccezioni dell'applicazione scritte dentro questa classe
@RestControllerAdvice 
public class GestoreExceptions {

    //Serve per estrarre i messaggi di errore se presenti. Rende tutto più pulito e chiaro.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> gestisciValidation(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining("; ")));
    }

    //Gestore di Eccezioni(prende la classe LibroNonTrovatoException) -- Intercetta l'eccezione e costruisce la risposta HTTP.
    @ExceptionHandler (LibroNonTrovatoException.class) 
    //La classe relativa alle risposte http. Gestisce questa eccezione e restituisce uno status code che codifica l'eccezione come titolo, il body è invece codificato dal messaggio associato a quella eccezione
    public ResponseEntity<String> HandleLibroNonTrovato(LibroNonTrovatoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler (LibroGiaEsistenteException.class)
    public ResponseEntity<String> HandleLibroGiaEsistente(LibroGiaEsistenteException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler (GenereNonTrovatoException.class)
    public ResponseEntity<String> HandleGenereNonTrovato(GenereNonTrovatoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler (GenereGiaEsistenteException.class)
    public ResponseEntity<String> HandleGenereGiaEsistente(GenereGiaEsistenteException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler (GenereInvalidNameException.class)
    public ResponseEntity<String> HandleGenereInvalidName(GenereInvalidNameException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    @ExceptionHandler (AutoreGiaEsistenteException.class)
    public ResponseEntity<String> HandleAutoreGiaEsistente(AutoreGiaEsistenteException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler (AutoreNonTrovatoException.class)
    public ResponseEntity<String> HandleAutoreNonTrovato(AutoreNonTrovatoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler (casaEditriceNonTrovataException.class)
    public ResponseEntity<String> HandleCasaEditriceNonTrovata(casaEditriceNonTrovataException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler (casaEditriceGiaEsistenteException.class)
    public ResponseEntity<String> HandlecasaEditriceGiaEsistente (casaEditriceGiaEsistenteException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler (casaEditriceInvalidNameException.class) 
    public ResponseEntity<String> HandlecasaEditriceInvalidName (casaEditriceInvalidNameException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler (CopiaNonTrovataException.class)
    public ResponseEntity<String> HandleCopiaNonTrovata (CopiaNonTrovataException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}