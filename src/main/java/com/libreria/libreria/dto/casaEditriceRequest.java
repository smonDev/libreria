package com.libreria.libreria.dto;

public class casaEditriceRequest {

    private String nome;

    //Empty Constructor
    public casaEditriceRequest() {

    }

    //Constructor 
    public casaEditriceRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     
}
