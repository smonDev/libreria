package com.libreria.libreria.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "Generi")
public class Genere {

    @Id 
    //Questo è il modo di identificare la chiave primaria. 
    //In questo caso, la chiave primaria è generata direttamente dal DB, è @GeneratedValue che aggiunge l'Auto-Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String nome;

    //Un genere è collegato a molti libri. In questo caso, il "uno" è la classe in cui scrivo questa regola (quindi Genere) e i "molti" è il tipo che ci sarà dentro la lista (quindi Libro). Dovrò creare la lista di libri qui sotto

    //Il mappedBy significa che nella lista di molti libri io ricercherò per genere (mappedBy)
    //mappedBy è utile su Libro perché è l'entity con più collegamenti 
   @OneToMany (mappedBy = "genere")
    private List<Libro> libri = new ArrayList<>();
    
    //Empty Constructor
    public Genere() {
    }

    //Constructor 
    public Genere(String nome) {
        this.nome = nome;
    }

    //Getters&Setters

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }
}
