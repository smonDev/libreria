package com.libreria.libreria.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {

    // Subito dopo @Id si specifica l'id come attributo nella classe.
    // Se l'id non è auto-increment, il primo attributo che inserisco fa riferimento
    // all'Id
    @Id
    private Integer isbn;
    private String titolo;
    private Integer anno;

    @ManyToOne
    @JoinColumn(name = "fk_genere")
    private Genere genere;
    // dovrò aggiungere lista copie e libro_autore
    @ManyToMany
    @JoinTable (name = "Libri_Autori", joinColumns = @JoinColumn (name = "fk_isbn"), inverseJoinColumns = @JoinColumn (name = "fk_autore"))
    private List<Autore> autori = new ArrayList<>(); 

    // Empty Constructor
    public Libro() {
    }

    // Constructor
    public Libro(Integer isbn, String titolo, Integer anno, Genere genere) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
    }

    // Getters&Setters

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

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

}