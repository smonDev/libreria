package com.libreria.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libreria.libreria.dto.AutoreDTO;
import com.libreria.libreria.dto.request.AutoreRequest;
import com.libreria.libreria.entity.Autore;
import com.libreria.libreria.exception.AutoreGiaEsistenteException;
import com.libreria.libreria.exception.AutoreNonTrovatoException;
import com.libreria.libreria.repository.AutoreRepository;
import com.libreria.libreria.repository.CopiaRepository;
import com.libreria.libreria.utility.Mapper;


@Service
public class AutoreService {

    private final CopiaRepository copiaRepository;
    private final AutoreRepository autoreRepository;
    private final Mapper mapper;

    // Constructor Injection
    public AutoreService(AutoreRepository autoreRepository, Mapper mapper, CopiaRepository copiaRepository) {
        this.autoreRepository = autoreRepository;
        this.mapper = mapper;
        this.copiaRepository = copiaRepository;
    }

    public AutoreDTO addAutore(AutoreRequest autoreRequest) {
        // Creo un nuovo oggetto Autore
        Autore autoreDaSalvare = new Autore();
        // Con i parametri di autoreRequest che dovrà contenere
        autoreDaSalvare.setNome(autoreRequest.getNome());
        autoreDaSalvare.setCognome(autoreRequest.getCognome());
        // Lo controllo nel database, tramite metodo creato appositamente per evitare
        // doppioni
        Boolean nuovoAutore = autoreRepository.existsByNomeAndCognome(autoreRequest.getNome(),
                autoreRequest.getCognome());
        // Se il controllo torna false, e quindi quei parametri non sono già presenti
        // nel DB creo l'oggetto nuovoAutore nel db e lo converto con il mapper in
        // autoreDTO
        if (nuovoAutore == false) {
            autoreRepository.save(autoreDaSalvare);
            return mapper.toAutoreDTO(autoreDaSalvare);
        } else
            throw new AutoreGiaEsistenteException(autoreRequest.getNome() + " " + autoreRequest.getCognome());
    }

    public List<AutoreDTO> getAllAutori() {

        List<Autore> autoriDB = autoreRepository.findAll();
        List<AutoreDTO> autoriDTO = new ArrayList<>();
        for (Autore autore : autoriDB) {
            autoriDTO.add(mapper.toAutoreDTO(autore));
        }
        return autoriDTO;
    }
    /**
     * Il metodo prende un id e restituisce l'autore corrispondente all'id.
     * Controlla se l'autore esiste e se non esiste lancia AutoreNonTrovatoException
     * @param id
     * @return
     * @throws AutoreNonTrovatoException se l'autore non esiste
     */
    public AutoreDTO getById(Integer id) {
            //Verifico l'esistenza dell'Autore. Imposto il controllo con la negazione davanti
            //Quindi lancio l'eccezione se non esiste 
               if(!autoreRepository.existsById(id))
                throw new AutoreNonTrovatoException(id);
            //Recupero l'oggetto Autore dal DB
            Autore autoreDaTrovare = autoreRepository.findById(id).orElseThrow();
            return mapper.toAutoreDTO(autoreDaTrovare);
    }

    public AutoreDTO updateById(AutoreRequest autoreRequest, Integer id) {
        // Ho cercato un autore per id nel DB e l'ho salvato in autoreDaModificare
        Autore autoreDaModificare = autoreRepository.findById(id)
                .orElseThrow(() -> new AutoreNonTrovatoException(id));
                //Imposto i nuovi parametri che voglio modificare
        autoreDaModificare.setCognome(autoreRequest.getCognome());
        autoreDaModificare.setNome(autoreRequest.getNome());
        autoreDaModificare.setNazionalita(autoreRequest.getNazionalita());
        //Poi salvo l'oggetto modificato (di tipo Autore) nel DB e lo converto in AutoreDTO ma stavolta modificato
        return mapper.toAutoreDTO(autoreRepository.save(autoreDaModificare));

    }

    public void deleteById(Integer id) {
        // Prima cerco ciò che voglio eliminare, findById. Se non esiste lancio l'eccezione
        Autore autoreDaEliminare = autoreRepository.findById(id).orElseThrow(
                () -> new AutoreNonTrovatoException(id));
        // Se esiste, poi lo elimino
        autoreRepository.delete(autoreDaEliminare);
    }

}
