package com.libreria.libreria.service;

import com.libreria.libreria.repository.AutoreRepository;
import com.libreria.libreria.repository.GenereRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.libreria.libreria.dto.LibroDTO;
import com.libreria.libreria.entity.Autore;
import com.libreria.libreria.entity.Genere;
import com.libreria.libreria.entity.Libro;
import com.libreria.libreria.repository.LibroRepository;
import com.libreria.libreria.utility.Mapper;

import jakarta.persistence.Id;

//Nel Service definisco tutti i metodi
@Service 
public class LibroService {

    private final AutoreRepository autoreRepository;
    private final GenereRepository genereRepository;
    private final LibroRepository libroRepository;
    private final Mapper mapper;
    
    //Constructor 
    public LibroService (LibroRepository libroRepository, Mapper mapper, GenereRepository genereRepository, AutoreRepository autoreRepository) {
        this.libroRepository = libroRepository;
        this.autoreRepository = autoreRepository;
        this.mapper = mapper;
        this.genereRepository = genereRepository;
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

    public List<LibroDTO> getAllByAnnoBefore(Integer anno) {
        LocalDate year = LocalDate.of(anno, 12, 31);
        List<Libro> libriDB = libroRepository.findAllByAnnoBefore(year);
            List<LibroDTO> libriDTO = new ArrayList<>();
            
            for (Libro libro : libriDB) 
            libriDTO.add(mapper.toLibroDTO(libro));
        return libriDTO;
    }

    public LibroDTO addLibro(String titolo, LocalDate anno, String genere, List<Integer> autori) {          
        //Devo aggiungere un solo Libro, non mi serve List
        Genere newGenere = genereRepository.findByNome(genere).orElseThrow(()->new RuntimeException("Genere con nome: " + genere + "non trovato"));
        List<Autore> autoriDB = autoreRepository.findAllById(autori);
        Libro libro = new Libro(titolo, anno, newGenere, autoriDB);
            return mapper.toLibroDTO(libroRepository.save(libro));
    
    }

    // public void updateLibro(LibroDTO libroDTO, Integer id) {
    //     //L'Id mi serve per trovare quel libro che voglio modificare, quindi cerco findbyID
    //     Libro libroDaModificare = libroRepository.findById(id).orElseThrow(()->new RuntimeException("Libro con id: " + id + "non trovato"));
    //     libroDaModificare.setTitolo(libroDTO.getTitolo());
    //     libroDaModificare.setAnno(libroDTO.getAnno());
    //     List<Genere> generi = genereRepository.findByNome(genere)
    //     libroDaModificare.setGenere(libroDTO.getGenere());
        
    //     }
        

    }


