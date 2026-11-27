package com.libreria.libreria.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libreria.libreria.dto.LibroDTO;
import com.libreria.libreria.dto.LibroRequest;
import com.libreria.libreria.entity.Autore;
import com.libreria.libreria.entity.Genere;
import com.libreria.libreria.entity.Libro;
import com.libreria.libreria.exception.AutoreNonTrovatoException;
import com.libreria.libreria.exception.LibroGiaEsistenteException;
import com.libreria.libreria.exception.LibroNonTrovatoException;
import com.libreria.libreria.repository.AutoreRepository;
import com.libreria.libreria.repository.GenereRepository;
import com.libreria.libreria.repository.LibroRepository;
import com.libreria.libreria.utility.Mapper;

//Nel Service definisco tutti i metodi -- Service gestisce la logica applicativa e lancia l'eccezione.
@Service
public class LibroService {

    private final AutoreRepository autoreRepository;
    private final GenereRepository genereRepository;
    private final LibroRepository libroRepository;
    private final Mapper mapper;

    // Constructor
    public LibroService(LibroRepository libroRepository, Mapper mapper, GenereRepository genereRepository,
            AutoreRepository autoreRepository) {
        this.libroRepository = libroRepository;
        this.autoreRepository = autoreRepository;
        this.mapper = mapper;
        this.genereRepository = genereRepository;
    }

    public List<LibroDTO> getAllLibri() {
        List<Libro> libriDB = libroRepository.findAll();
        List<LibroDTO> libriDTO = new ArrayList<>();
        // Per ogni Libro di LibriDB che è la mia variabile che fa riferimento al
        // risultato del DataBase
        for (Libro libro : libriDB)
            // Trasformo Libro in LibroDTO con il mapper, e lo aggiungo a Libri
            libriDTO.add(mapper.toLibroDTO(libro));
        return libriDTO;
    }

    public LibroDTO getById(Integer isbn) {
        Libro libro = libroRepository.findById(isbn)
                .orElseThrow(() -> new LibroNonTrovatoException(isbn));
        return (mapper.toLibroDTO(libro));
    }

    public List<LibroDTO> getAllByAnno(Integer anno) {
        // Cerco sulla List perché me ne serve più di uno, altrimenti sarebbe stato solo
        // Libro
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

    public LibroDTO addLibro(LibroRequest libroRequest) {
        // Devo aggiungere un solo Libro, non mi serve List
        // Prima controllo che il libro non sia già esistente, altrimenti lancio
        // l'eccezione:
        if (libroRepository.existsById(libroRequest.getIsbn()))
            throw new LibroGiaEsistenteException(libroRequest);
        // Devo estrarre l'oggetto Genere dall'Optional (scritto in GenereRepository),
        // per farlo, utilizzo orElseGet(). In questo caso, se non trovo il genere, lo
        // creo.
        Genere genere = genereRepository.findByNome(libroRequest.getGenere())
                .orElseGet(() -> genereRepository.save(new Genere(libroRequest.getGenere())));
        List<Autore> autoriDB = autoreRepository.findAllById(libroRequest.getAutori());
        // Controllo sugli autori effettivi nel DB, se sono pari a 0 lancio l'eccezione
        if ((autoriDB.size() == 0))
            throw new AutoreNonTrovatoException("Uno o più autori non sono stati trovati nel DB.");

        Libro libro = new Libro();
        libro.setGenere(genere);
        libro.setAnno(libroRequest.getAnno());
        libro.setAutori(autoriDB);
        libro.setIsbn(libroRequest.getIsbn());
        libro.setTitolo(libroRequest.getTitolo());

        return mapper.toLibroDTO(libroRepository.save(libro));
    }

    // Il metodo torna un Libro invece di void, così posso aggiornare il libro
    // modificato
    public LibroDTO updateLibro(Integer isbn, LibroRequest libroRequest) {
        // Cerco il libro nel DB, tramite id, se non lo trovo, lancio l'eccezione
        Libro libroDaModificare = libroRepository.findById(isbn)
                .orElseThrow(() -> new LibroNonTrovatoException(isbn));
        // Passo poi al genere, ma lo cerco per nome. Se non lo trovo, lo creo:
        Genere GenereDTO = genereRepository.findByNome(libroRequest.getGenere())
                .orElseGet(() -> {
                    return genereRepository.save(new Genere(libroRequest.getGenere()));
                    // Invece che lanciare un'eccezione, salvo prima il genere nel DB e creo
                    // l'oggetto new Genere, e poi mi prendo il titolo che è il parametro che mi
                    // serve da libroRequest.getGenere();
                });
        // Infine cerco autori. Mi servono tutti, quindi utilizzo List:
        List<Autore> autoriDB = autoreRepository.findAllById(libroRequest.getAutori());
        if (autoriDB.size() == 0)
            throw new AutoreNonTrovatoException("Uno o più autori non sono stati trovati nel DB.");
        libroDaModificare.setAnno(libroRequest.getAnno());
        libroDaModificare.setTitolo(libroRequest.getTitolo());
        libroDaModificare.setIsbn(isbn);
        libroDaModificare.setGenere(GenereDTO);
        libroDaModificare.setAutori(autoriDB);
        return mapper.toLibroDTO(libroRepository.save(libroDaModificare));
    }

    public void deleteLibro(Integer isbn) {
        // Cerco nel DB il libro da eliminare, se non lo trovo lancio l'eccezione
        Libro libroDaEliminare = libroRepository.findById(isbn)
                .orElseThrow(() -> new LibroNonTrovatoException(isbn));
        libroRepository.delete(libroDaEliminare);
    }

    public Long getSize() {
        return libroRepository.count();
    }
}
