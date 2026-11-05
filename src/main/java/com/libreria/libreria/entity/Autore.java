package com.libreria.libreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Autori")
public class Autore {

    @Id
    //Faccio la stessa cosa di Genere, perché anche Autore ha l'auto-increment su Workbench
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutore;

    private String nome;
    private String cognome;
    private String nazionalita;

    






}
