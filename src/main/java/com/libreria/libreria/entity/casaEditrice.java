package com.libreria.libreria.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "casa_editrice")
public class casaEditrice {

    @Id
    private Integer id_casaeditrice;
    private String nome;

    @OneToMany (mappedBy = "casaEditrice")
    private Set <Copia> copie = new HashSet<>();

    //EmptyConstructor
    public casaEditrice() {
    }

    //Constructor
    public casaEditrice(Integer id_casaeditrice, String nome) {
        this.id_casaeditrice = id_casaeditrice;
        this.nome = nome;
    }

    //Getters&Setters

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

    public Set<Copia> getCopie() {
        return copie;
    }

    public void setCopie(Set<Copia> copie) {
        this.copie = copie;
    }
    
}
