package com.libreria.libreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Copie")
public class Copia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //private Integer fk_isbn;
    private Integer num_copie;
    //private Integer fk_casaeditrice;

    @ManyToOne 
    @JoinColumn(name = "fk_isbn")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "fk_casaeditrice")
    private casaEditrice casaeditrice;
    //Empty Constructor
    public Copia() {
    }

    //Constructor 
    public Copia(Integer id, Libro libro, Integer num_copie, casaEditrice casaeditrice) {
        this.id = id;
        this.libro = libro;
        this.num_copie = num_copie;
        this.casaeditrice = casaeditrice;
    }

    //Getters&Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getNum_copie() {
        return num_copie;
    }

    public void setNum_copie(Integer num_copie) {
        this.num_copie = num_copie;
    }

    public casaEditrice getCasaeditrice() {
        return casaeditrice;
    }

    public void setCasaeditrice(casaEditrice casaEditrice) {
        this.casaeditrice = casaeditrice;
    }

}
