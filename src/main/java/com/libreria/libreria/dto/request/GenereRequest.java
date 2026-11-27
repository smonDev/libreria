package com.libreria.libreria.dto.request;

import jakarta.validation.constraints.NotBlank;

public class GenereRequest {

    @NotBlank (message = "Il nome del genere non può mancare come campo.")
    private String nome;

    //Empty Constructor
    //Con il costruttore vuoto Jackson (che Spring utilizza normalmente per convertire il JSON in oggetti Java)
    //può creare l'oggetto e valorizzarne i campi tramite i setter.
    public GenereRequest() {

    }

    //Constructor
    public GenereRequest (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    





}
