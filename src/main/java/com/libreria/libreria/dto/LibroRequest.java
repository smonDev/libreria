package com.libreria.libreria.dto;

import java.time.LocalDate;
import java.util.List;

public class LibroRequest {

    private Integer isbn;
    private String titolo;
    private LocalDate anno;
    private String genere;
    private List<Integer> autori;
    

    public LibroRequest (Integer isbn,String titolo,LocalDate anno,String genere,List<Integer> autori) {

        this.isbn = isbn;
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
        this.autori = autori;
    }


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
