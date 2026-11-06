package com.libreria.libreria.dto;

public class CopiaDTO {

    private Integer id;
    private LibroDTO libro;
    private casaEditriceDTO casaeditrice;
    private Integer num_copie;

    // Empty Constructor
    public CopiaDTO() {
    }

    // Constructor
    public CopiaDTO(Integer id, LibroDTO libro, casaEditriceDTO casaeditrice, Integer num_copie) {

        this.id = id;
        this.libro = libro;
        this.casaeditrice = casaeditrice;
        this.num_copie = num_copie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LibroDTO getLibro() {
        return libro;
    }

    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }

    public casaEditriceDTO getCasaeditrice() {
        return casaeditrice;
    }

    public void setCasaeditrice(casaEditriceDTO casaeditrice) {
        this.casaeditrice = casaeditrice;
    }

    public Integer getNum_copie() {
        return num_copie;
    }

    public void setNum_copie(Integer num_copie) {
        this.num_copie = num_copie;
    }

}
