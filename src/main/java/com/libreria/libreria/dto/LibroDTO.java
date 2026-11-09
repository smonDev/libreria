package com.libreria.libreria.dto;

import java.time.LocalDate;

public class LibroDTO {

    private Integer id;
    private String titolo;
    private LocalDate anno;
    private GenereDTO genere;

    // Empty Constructor
    public LibroDTO() {
    }

    // Constructor
    public LibroDTO(Integer id, String titolo, LocalDate anno, GenereDTO genere) {
        this.id = id;
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
    }

    // Getters&Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public GenereDTO getGenere() {
        return genere;
    }

    public void setGenere(GenereDTO genere) {
        this.genere = genere;
    }

}
