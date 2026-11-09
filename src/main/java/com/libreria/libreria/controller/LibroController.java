package com.libreria.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreria.libreria.dto.LibroDTO;
import com.libreria.libreria.service.LibroService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
@RequestMapping ("/libri")
public class LibroController {
    private final LibroService libroService;

    //Constructor Injection (come fare l'AutoWired)
    public LibroController (LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroDTO> getAll() {
        return libroService.getAllLibri();
    }
    
    @GetMapping("/{anno}")
    public List<LibroDTO> getAllByAnnoBefore(@PathVariable Integer anno) {

      return libroService.getAllByAnno(anno);
    
    }
}
