package com.libreria.libreria.dto.request;

import jakarta.validation.constraints.NotBlank;

public class casaEditriceRequest {

    @NotBlank (message = "Il nome della Casa Editrice non può mancare come campo.")
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
