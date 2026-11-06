package com.libreria.libreria.entity;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JoinRowSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Autori")
public class Autore {

    @Id
    // Faccio la stessa cosa di Genere, perché anche Autore ha l'auto-increment su
    // Workbench
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutore;

    private String nome;
    private String cognome;
    private String nazionalita;

    @ManyToMany 
    @JoinTable (name = "Libri_Autori", joinColumns = @JoinColumn (name = "fk_autore"), inverseJoinColumns = @JoinColumn (name = "fk_isbn"))
    private List<Libro> libri = new ArrayList<>();


    // Empty Constructor
    public Autore() {
    }

    // Constructor

}
