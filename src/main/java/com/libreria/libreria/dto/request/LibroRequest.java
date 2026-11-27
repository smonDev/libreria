package com.libreria.libreria.dto.request;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LibroRequest {
    //Validation
    @NotNull (message = "L'ISBN del libro non può essere vuoto.")
    private Integer isbn;
    @NotBlank (message = "Il titolo non può mancare come campo.")
    private String titolo;
    private LocalDate anno;
    @NotBlank (message = "Il genere non può mancare come campo.")
    private String genere;
    @NotEmpty (message = "La lista degli autori non può mancare come campo.")
    private List<Integer> autori;
    
    //Empty Constructor
    public LibroRequest() {
        
    }

    //Constructor
    public LibroRequest (Integer isbn,String titolo,LocalDate anno,String genere,List<Integer> autori) {

        this.isbn = isbn;
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
        this.autori = autori;
    }

    //Getters&Setters
    public Integer getIsbn() {
        return isbn;
    }


    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }


    public String getTitolo() {
        return titolo;
    }


    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }


    public LocalDate getAnno() {
        return anno;
    }


    public void setAnno(LocalDate anno) {
        this.anno = anno;
    }


    public String getGenere() {
        return genere;
    }


    public void setGenere(String genere) {
        this.genere = genere;
    }


    public List<Integer> getAutori() {
        return autori;
    }


    public void setAutori(List<Integer> autori) {
        this.autori = autori;
    }

    
}
