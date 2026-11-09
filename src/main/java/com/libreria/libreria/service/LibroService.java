package com.libreria.libreria.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.libreria.libreria.dto.LibroDTO;
import com.libreria.libreria.entity.Libro;
import com.libreria.libreria.repository.LibroRepository;
import com.libreria.libreria.utility.Mapper;

//Nel Service definisco tutti i metodi
@Service 
public class LibroService {

    private final LibroRepository libroRepository;
    private final Mapper mapper;
    
    public LibroService (LibroRepository libroRepository, Mapper mapper) {
        this.libroRepository = libroRepository;
        this.mapper = mapper;
    }
    
    public List<LibroDTO> getAllLibri() {
        List<Libro> libriDB = libroRepository.findAll();
        List<LibroDTO> libriDTO = new ArrayList<>();
        //Per ogni Libro di LibriDB che è la mia variabile che fa riferimento al risultato del DataBase
        for(Libro libro : libriDB)
            //Trasformo Libro in LibroDTO con il mapper, e lo aggiungo a Libri
            libriDTO.add(mapper.toLibroDTO(libro));
        return libriDTO;
    }

    public List<LibroDTO> getAllByAnno(Integer anno) {
        //Cerco sulla List perché me ne serve più di uno, altrimenti sarebbe stato solo Libro
        List<Libro> libriDB = libroRepository.findAllByAnno(anno);
        List<LibroDTO> libriDTO = new ArrayList<>();
        for (Libro libro : libriDB) 
            libriDTO.add(mapper.toLibroDTO(libro));
        return libriDTO;
    }
}
