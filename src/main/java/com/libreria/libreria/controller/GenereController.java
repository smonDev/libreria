package com.libreria.libreria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreria.libreria.dto.GenereDTO;
import com.libreria.libreria.dto.request.GenereRequest;
import com.libreria.libreria.service.GenereService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/generi")
public class GenereController {
    // Dal Controller chiamo il Service
    private final GenereService genereService;

    // Constructor Injection
    public GenereController(GenereService genereService) {
        this.genereService = genereService;
    }

    // Richiamo tutti i generi
    @GetMapping("/all")
    public List<GenereDTO> getAll() {
        return genereService.getAllGeneri();
    }

    // Richiamo un genere specifico
    @GetMapping("/nome/{nome}")
    public GenereDTO getNome(@PathVariable String nome) {
        return genereService.getByNome(nome);
    }

    // Modifico un genere con la ricerca tramite nome (però mi serve il nome che
    // aveva prima della modifica)
    @PutMapping("/update/{nomeVecchio}")
    // Utilizzo @PathVariable quando ho un parametro specifico nel path. In questo
    // caso, recupera il nome prima della modifica
    // @RequestParam recupera un nuovo nome dai parametri
    public GenereDTO updateByNome(@Valid @RequestBody GenereRequest genereRequest, @PathVariable String nomeVecchio) {
        return genereService.updateByNome(genereRequest, nomeVecchio);
    }

    // Aggiungo un nuovo genere
    @PostMapping("/add")
    public GenereDTO addGenere(@Valid @RequestBody GenereRequest genereRequest) {
        return genereService.addGenere(genereRequest);
    }

    // Elimino un genere tramite id
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        genereService.deleteById(id);
    }
}
