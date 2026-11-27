package com.libreria.libreria.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CopiaRequest {

    @NotNull (message = "L'ID della copia non può essere vuoto.")
    private Integer fk_isbn;
    @PositiveOrZero (message = "Il numero di copie può essere come minimo 0 o superiore.")
    private Integer num_copie;
    @NotNull (message = "L'ID della Casa Editrice non può essere vuoto.")
    private Integer fk_casaeditrice;

    //EmptyConstructor
    public CopiaRequest() {

    }

    //Constructor
    public CopiaRequest(Integer fk_isbn, Integer num_copie, Integer fk_casaeditrice) {
        //fk_isbn fa riferimento a idLibro, fk_casaeditrice fa riferimento a idCasaEditrice. Quindi negli attributi di CopiaRequest 
        //sono necessari i riferimenti a id di Libro e casaEditrice
        this.fk_isbn = fk_isbn;
        this.num_copie = num_copie;
        this.fk_casaeditrice = fk_casaeditrice;
    }

    //Getters&Setters
    public Integer getFk_isbn() {
        return fk_isbn;
    }

    public void setFk_isbn(Integer fk_isbn) {
        this.fk_isbn = fk_isbn;
    }

    public Integer getNum_copie() {
        return num_copie;
    }

    public void setNum_copie(Integer num_copie) {
        this.num_copie = num_copie;
    }

    public Integer getFk_casaeditrice() {
        return fk_casaeditrice;
    }

    public void setFk_casaeditrice(Integer fk_casaeditrice) {
        this.fk_casaeditrice = fk_casaeditrice;
    }

}