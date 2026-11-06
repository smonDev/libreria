package com.libreria.libreria.entity;

import java.util.ArrayList;
import java.util.List;

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
    private Integer idAutore;
    private String nome;
    private String cognome;
    private String nazionalita;

    @ManyToMany
    @JoinTable(name = "Libri_Autori", joinColumns = @JoinColumn(name = "fk_autore"), inverseJoinColumns = @JoinColumn(name = "fk_isbn"))
    private List<Libro> libri = new ArrayList<>();

    //Empty Constructor
    public Autore() {
    }

    //Constructor
    public Autore(Integer idAutore,String nome, String cognome, String nazionalita, List<Libro> libri) {
        this.idAutore = idAutore;
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
        this.libri = libri;
    }

    //Getters&Setters
    public Integer getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Integer idAutore) {
        this.idAutore = idAutore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

}
