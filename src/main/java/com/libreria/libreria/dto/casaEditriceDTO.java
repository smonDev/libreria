package com.libreria.libreria.dto;

public class casaEditriceDTO {

    private Integer id;
    private String nome;

    // EmptyConstructor
    public casaEditriceDTO() {
    }

    // Constructor
    public casaEditriceDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Getters&Setters
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

}
