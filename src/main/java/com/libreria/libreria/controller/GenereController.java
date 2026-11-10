package com.libreria.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreria.libreria.dto.GenereDTO;
import com.libreria.libreria.service.GenereService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController 
@RequestMapping ("/generi")
public class GenereController {
    //Dal Controller chiamo il Service
    private final GenereService genereService;

    //Constructor Injection
    public GenereController (GenereService genereService) {
        this.genereService = genereService;
    }

    //Richiamo tutti i generi
    @GetMapping
    public List<GenereDTO> getAll() {
        return genereService.getAllGeneri();
    }
    



}
