package com.libreria.libreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Generi")
public class Genere {

    @Id 
    // Questo è il modo di idGenereentificare la chiave primaria.
    // In questo caso, la chiave primaria è generata direttamente dal DB, è
    // @GeneratedValue che aggiunge l'Auto-Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenere;
    private String nome;

    // Un genere è collegato a molti libri. In questo caso, il "uno" è la classe in
    // cui scrivo questa regola (quindi Genere) e i "molti" è il tipo che ci sarà
    // dentro la lista (quindi Libro). Dovrò creare la lista di libri qui sotto
    // Il mappedBy significa che nella lista di molti libri io ricercherò per genere
    // (mappedBy)
    // mappedBy è utile su Libro perché è l'entity con più collegamenti

    // Empty Constructor
    public Genere() {
    }

    // Constructor
    public Genere(String nome) {
        this.nome = nome;
    }

    // Getters&Setters
    public Integer getidGenere() {
        return idGenere;
    }

    public void setidGenere(Integer idGenere) {
        this.idGenere = idGenere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
