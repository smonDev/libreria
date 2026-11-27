package com.libreria.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libreria.libreria.controller.AutoreController;
import com.libreria.libreria.dto.GenereDTO;
import com.libreria.libreria.dto.request.GenereRequest;
import com.libreria.libreria.entity.Genere;
import com.libreria.libreria.exception.GenereGiaEsistenteException;
import com.libreria.libreria.exception.GenereInvalidNameException;
import com.libreria.libreria.exception.GenereNonTrovatoException;
import com.libreria.libreria.repository.GenereRepository;
import com.libreria.libreria.utility.Mapper;

@Service
public class GenereService {

    private final AutoreController autoreController;
    // Per ogni classe Service ho bisogno di implementare sia Repository che Mapper
    private final GenereRepository genereRepository;
    private final Mapper mapper;

    // Constructor
    public GenereService(GenereRepository genereRepository, Mapper mapper, AutoreController autoreController) {
        // Inizializzo i parametri
        this.genereRepository = genereRepository;
        this.mapper = mapper;
        this.autoreController = autoreController;
    }

    // Voglio poter cercare tutti i generi, e creo il metodo getAll()
    // Prendo sempre come riferimento il DTO, non l'Entity
    public List<GenereDTO> getAllGeneri() {
        List<Genere> generiDB = genereRepository.findAll();
        // Inizializzo l'ArrayList
        List<GenereDTO> generiDTO = new ArrayList<>();
        // ciclo for each: per ogni genere del DB
        for (Genere genere : generiDB)
            // Trasformo Genere in GenereDTO con mapper, lo aggiungo poi a Generi
            generiDTO.add(mapper.toGenereDTO(genere));
        return generiDTO;
    }

    public GenereDTO getByNome(String nome) {
        // Cerco il genere nel DB, tramite nome. Se non lo trovo lancio l'eccezione
        Genere genereDaTrovare = genereRepository.findByNome(nome)
                .orElseThrow(() -> new GenereNonTrovatoException(nome));
        return mapper.toGenereDTO(genereDaTrovare);
    }

    public GenereDTO updateByNome(GenereRequest genereRequest, String nomeVecchio) {
        Genere genere = genereRepository.findByNome(nomeVecchio)
                .orElseThrow(() -> new GenereNonTrovatoException(genereRequest.getNome()));
        // Se genere (che fa riferimento al DB) è uguale al genere che invia il client,
        // quindi sono uguali, non aggiorno, e lancio eccezione
        if (genere.getNome().equals(genereRequest.getNome()))
            throw new GenereGiaEsistenteException(genereRequest.getNome());
        // quindi, se non esce dal programma con l'eccezione, significa che i nomi sono
        // diversi e quindi aggiorna genere con nome nuovo
        genere.setNome(genereRequest.getNome());
        return mapper.toGenereDTO(genereRepository.save(genere));
    }

    public GenereDTO addGenere(GenereRequest genereRequest) {
        // Creo un oggetto Genere
        Genere nuovoGenere = new Genere();
        // Controllo che il nome non sia vuoto
        if (genereRequest.getNome() == null) {
            throw new GenereInvalidNameException(genereRequest.getNome());
        } // Controllo anche se il nome creato esiste già nel DB
        if (genereRepository.findByNome(genereRequest.getNome()).isPresent()) {
            throw new GenereGiaEsistenteException(genereRequest.getNome());
        } // Se i controlli vengono superati, imposto il nome al nuovo oggetto
        nuovoGenere.setNome(genereRequest.getNome());
        // Poi lo salvo nel DB e lo converto in GenereDTO
        return mapper.toGenereDTO(genereRepository.save(nuovoGenere));
    }

    public void deleteById(Integer id) {
        if (genereRepository.existsById(id)) {
            genereRepository.deleteById(id);
        } else
            throw new GenereNonTrovatoException(id);
    }
}
