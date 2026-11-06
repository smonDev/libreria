package com.libreria.libreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "casa_editrice")
public class casaEditrice {

    @Id
    private Integer id_casaeditrice;
    private String nome;

    // EmptyConstructor
    public casaEditrice() {
    }

    // Constructor
    public casaEditrice(Integer id_casaeditrice, String nome) {
        this.id_casaeditrice = id_casaeditrice;
        this.nome = nome;
    }

    // Getters&Setters

    public Integer getId_casaeditrice() {
        return id_casaeditrice;
    }

    public void setId_casaeditrice(Integer id_casaeditrice) {
        this.id_casaeditrice = id_casaeditrice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }





}
