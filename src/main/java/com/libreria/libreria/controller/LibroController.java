package com.libreria.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.libreria.libreria.dto.LibroDTO;
import com.libreria.libreria.dto.LibroRequest;
import com.libreria.libreria.service.LibroService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




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
    //Controllo sulle varie annotazioni 
    //Strutture sulle quali scrivere i dati (json, body, pathvariable entity)
    public List<LibroDTO> getAllByAnnoBefore(@PathVariable Integer anno) {
      return libroService.getAllByAnnoBefore(anno);
    }

    @PostMapping
    public LibroDTO addLibro(@RequestParam Integer isbn, @RequestParam String titolo, @RequestParam LocalDate anno,@RequestParam String genere, @RequestParam List<Integer> autori) {
        return libroService.addLibro(isbn, titolo, anno, genere, autori);
        
    }
    
    @PutMapping
    public LibroDTO updateLibro(@RequestBody LibroRequest libroRequest) {
        return libroService.addLibro(libroRequest);
        
    }
}