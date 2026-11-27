package com.libreria.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libreria.libreria.dto.casaEditriceDTO;
import com.libreria.libreria.dto.casaEditriceRequest;
import com.libreria.libreria.entity.casaEditrice;
import com.libreria.libreria.exception.casaEditriceGiaEsistenteException;
import com.libreria.libreria.exception.casaEditriceInvalidNameException;
import com.libreria.libreria.exception.casaEditriceNonTrovataException;
import com.libreria.libreria.repository.casaEditriceRepository;
import com.libreria.libreria.utility.Mapper;

@Service
public class CasaEditriceService {
    // Implemento sempre Repository e Mapper
    private final casaEditriceRepository casaEditriceRepository;
    private final Mapper mapper;

    // Constructor
    public CasaEditriceService(casaEditriceRepository casaEditriceRepository, Mapper mapper) {
        this.casaEditriceRepository = casaEditriceRepository;
        this.mapper = mapper;
    }

    // Tutte le case editrici
    public List<casaEditriceDTO> getAllCaseEditrici() {
        // Una variabile che mi prende la lista degli oggetti casaEditrice presenti nel
        // DB. Li richiamo dal Repository con findAll()
        List<casaEditrice> listaCaseEditrici = casaEditriceRepository.findAll();
        // Creo l'oggetto casaEditriceDTO di tipo List
        List<casaEditriceDTO> listaCaseEditriciDTO = new ArrayList<>();
        // Per ogni oggetto casaEditrice in ListaCaseEditrici utilizzo il mapper per
        // convertire casaEditrice in casaEditriceDTO
        for (casaEditrice casaEditrice : listaCaseEditrici) {
            listaCaseEditriciDTO.add(mapper.toCasaEditriceDTO(casaEditrice));
        }
        // Il metodo torna le varie caseEditrici come oggetto DTO
        return listaCaseEditriciDTO;
    }

    public casaEditriceDTO getByNome(String nome) {
        casaEditrice trovaNomeCasaEditrice = casaEditriceRepository.findByNome(nome)
                .orElseThrow(() -> new casaEditriceNonTrovataException(nome));
        return mapper.toCasaEditriceDTO(trovaNomeCasaEditrice);
    }

    public casaEditriceDTO getById(Integer id) {
        casaEditrice trovaIdCasaEditrice = casaEditriceRepository.findById(id)
                .orElseThrow(() -> new casaEditriceNonTrovataException(id));
        return mapper.toCasaEditriceDTO(trovaIdCasaEditrice);
    }

    public casaEditriceDTO addNewCasaEditrice(casaEditriceRequest casaEditriceRequest) {
        casaEditrice nuovaCasaEditrice = new casaEditrice();
        if (casaEditriceRequest.getNome() == null) {
            throw new casaEditriceInvalidNameException(casaEditriceRequest);
        } // Controllo anche se il nome creato esiste già nel DB
        if (casaEditriceRepository.findByNome(casaEditriceRequest.getNome()).isPresent()) {
            throw new casaEditriceGiaEsistenteException(casaEditriceRequest);
        } // Se i controlli vengono superati, imposto il nome al nuovo oggetto
        nuovaCasaEditrice.setNome(casaEditriceRequest.getNome());
        return mapper.toCasaEditriceDTO(casaEditriceRepository.save(nuovaCasaEditrice));
    }

    public casaEditriceDTO updateById(casaEditriceRequest casaEditriceRequest, Integer id) {
        casaEditrice casaEditriceDaModificare = casaEditriceRepository.findById(id).orElseThrow(() -> new casaEditriceNonTrovataException(id));
            casaEditriceDaModificare.setNome(casaEditriceRequest.getNome());
            return mapper.toCasaEditriceDTO(casaEditriceRepository.save(casaEditriceDaModificare));
    }

    public void deleteById(Integer id) {
        if (casaEditriceRepository.existsById(id)) {
            casaEditriceRepository.deleteById(id);
        } else
            throw new casaEditriceNonTrovataException(id);
    }
}
