package com.libreria.libreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Libro {

    //Subito dopo @Id si specifica l'id come attributo nella classe. 
    //Se l'id non è auto-increment, il primo attributo che inserisco fa riferimento all'Id
    @Id 
    private Integer isbn;
    private String titolo;
    private Integer anno;

    //"Molti a uno" - Molti libri possono avere lo stesso genere.
    @ManyToOne
    //La colonna nel database dove viene salvata l'etichetta. 
    //Nella tabella "libro" ci sarà una colonna "id_genere" con dentro il numero del genere
    @JoinColumn(name = "id_genere")
    
    //Ogni libro ha un attributo che è un oggetto Genere, proprio il genre intero
    private Genere genere;

    //Empty Constructor
    public Libro() {

    }

    //Constructor
    public Libro(Integer isbn, String titolo, Integer anno, Genere genere) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
    }

}