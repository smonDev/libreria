package com.libreria.libreria.service;

import com.libreria.libreria.controller.AutoreController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.libreria.libreria.dto.CopiaDTO;
import com.libreria.libreria.dto.CopiaRequest;
import com.libreria.libreria.entity.Copia;
import com.libreria.libreria.entity.Libro;
import com.libreria.libreria.entity.casaEditrice;
import com.libreria.libreria.repository.CopiaRepository;
import com.libreria.libreria.repository.LibroRepository;
import com.libreria.libreria.repository.casaEditriceRepository;
import com.libreria.libreria.utility.Mapper;

@Service
public class CopiaService {

    private final CopiaRepository copiaRepository;
    private final LibroRepository libroRepository;
    private final casaEditriceRepository casaEditriceRepository;
    private final Mapper mapper;

    // Constructor Injection
    public CopiaService(CopiaRepository copiaRepository, LibroRepository libroRepository,
            casaEditriceRepository casaEditriceRepository, AutoreController autoreController, Mapper mapper) {
        this.copiaRepository = copiaRepository;
        this.libroRepository = libroRepository;
        this.casaEditriceRepository = casaEditriceRepository;
        this.mapper = mapper;
    }

    public CopiaDTO addCopia(CopiaRequest copiaRequest) {
        // Devo recuperare un libro dal DB, quindi tramite Repository
        // Lo cerco tramite id, e richiamo il getId da copiaRequest, riferendomi al
        // metodo findById presente in Repository
        Libro libroDaRecuperare = libroRepository.findById(copiaRequest.getFk_isbn())
                // Se non lo trovo lancio l'eccezione con messaggio
                .orElseThrow(() -> new RuntimeException("Libro con id: " + copiaRequest.getFk_isbn() + "non trovato"));
        // Lo stesso con casaEditrice:
        casaEditrice cEditriceDaRecuperare = casaEditriceRepository.findById(copiaRequest.getFk_casaeditrice())
                .orElseThrow(() -> new RuntimeException(
                        "Casa editrice con id: " + copiaRequest.getFk_casaeditrice() + "non trovata"));
        Copia copia = new Copia();
        // Settare l'ID non serve perché nella Entity Copia il valore id è
        // auto-increment, l'ID viene assegnato quando JPA esegue l'inserimento nel
        // database. In questo caso non è necessario impostarlo manualmente
        copia.setNum_copie(copiaRequest.getNum_copie());
        copia.setLibro(libroDaRecuperare);
        copia.setCasaeditrice(cEditriceDaRecuperare);
        // Converto tramite mapper copia in CopiaDTO (come ritorno del tipo dichiarato
        // del metodo)
        // Il metodo save() di Spring Data JPA salva la nuova Copia nel database e
        // restituisce un oggetto Copia
        return mapper.toCopiaDTO(copiaRepository.save(copia));
    }

    public CopiaDTO updateCopiaById(CopiaRequest copiaRequest, Integer id) {
        Copia copia = copiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Errore, copia con id: " + id + "non trovata"));
        copia.setNum_copie(copiaRequest.getNum_copie());
        return mapper.toCopiaDTO(copiaRepository.save(copia));
    }

    public List<CopiaDTO> getAllCopie() {
        // Prendo le copie dal db tramite repository e le inserisco dentro una lista
        List<Copia> copieDB = copiaRepository.findAll();
        // Ogni oggetto Copia che devo convertire in CopiaDTO lo inserisco in
        // quest'altra lista di tipo CopiaDTO dopo la conversione con il mapper
        List<CopiaDTO> copieDTO = new ArrayList<>();
        // Per ogni Oggetto di tipo Copia chiamato copia di copieDB, fai la conversione
        // da tipo Copia a CopiaDTO e aggiungi l'elemento convertito alla lista copieDTO
        for (Copia copia : copieDB) {
            copieDTO.add(mapper.toCopiaDTO(copia));
        }
        return copieDTO;
    }

    public CopiaDTO getById(Integer id) {
        // Cerco la copia nel database tramite copiaRepo, se non la trovo, lancio
        // un'eccezione
        Copia copia = copiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Copia con id: " + id + " non trovata"));
        // Se invece la trovo, restituisco la copia, convertita in CopiaDTO
        return mapper.toCopiaDTO(copia);
    }

    public void deleteById(Integer id) {
        // Molto simile a getById(), SOLAMENTE CHE ELIMINA invece di cercare. Il ritorno può essere void
        Copia copiaDaEliminare = copiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Copia con id: " + id + " non trovata"));
        copiaRepository.delete(copiaDaEliminare);
    }
}
