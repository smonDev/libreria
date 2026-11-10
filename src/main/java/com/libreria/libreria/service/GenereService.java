package com.libreria.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.libreria.libreria.dto.GenereDTO;
import com.libreria.libreria.entity.Genere;
import com.libreria.libreria.repository.GenereRepository;
import com.libreria.libreria.utility.Mapper;

@Service 
public class GenereService {

    //Per ogni classe Service ho bisogno di implementare sia Repository che Mapper
    private final GenereRepository genereRepository;
    private final Mapper mapper;

    //Constructor 
    public GenereService (GenereRepository genereRepository, Mapper mapper) {
    //Inizializzo i parametri
    this.genereRepository = genereRepository;
    this.mapper = mapper;
}

//Voglio poter cercare tutti i generi, e creo il metodo getAll()
//Prendo sempre come riferimento il DTO, non l'Entity 
public List<GenereDTO> getAllGeneri() {
    List <Genere> generiDB = genereRepository.findAll();
    //Inizializzo l'ArrayList
    List <GenereDTO> generiDTO = new ArrayList<>();
    //ciclo for each: per ogni genere del DB 
    for(Genere genere : generiDB)
        //Trasformo Genere in GenereDTO con mapper, lo aggiungo poi a Generi
        generiDTO.add(mapper.toGenereDTO(genere));
    return generiDTO;
} 
 

}

