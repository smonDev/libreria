package com.libreria.libreria.dto;

public class AutoreRequest {

    private String nome;
    private String cognome;
    private String nazionalita;

    //EmptyConstructor
    public AutoreRequest() {

    }

    //Constructor
    public AutoreRequest(String nome, String cognome, String nazionalita) {

        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
    }

    //Getters&Setters
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

}