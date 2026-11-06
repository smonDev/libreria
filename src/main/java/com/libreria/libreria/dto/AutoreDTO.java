package com.libreria.libreria.dto;

import java.time.LocalDate;

public class AutoreDTO {

    private Integer id;
    private String nome;
    private String cognome;
    private LocalDate anno;
    private String nazionalita;

    // Empty Constructor
    public AutoreDTO() {
    }

    // Constructor
    public AutoreDTO(Integer id, String nome, String cognome, LocalDate anno, String nazionalita) {

        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.anno = anno;
        this.nazionalita = nazionalita;
    }

    // Getters&Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getAnno() {
        return anno;
    }

    public void setAnno(LocalDate anno) {
        this.anno = anno;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

}
