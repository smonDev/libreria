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

import com.libreria.libreria.dto.CopiaDTO;
import com.libreria.libreria.dto.request.CopiaRequest;
import com.libreria.libreria.service.CopiaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/copie")
public class CopiaController {
    private final CopiaService copiaService;

    public CopiaController(CopiaService copiaService) {
        this.copiaService = copiaService;
    }

    @PostMapping
    // @RequestBody fa leggere a Spring il JSON della richiesta e lo converte in un
    // CopiaRequest. Il controller passa quell’oggetto al service e restituisce il
    // DTO ottenuto.
    public CopiaDTO addCopia(@Valid @RequestBody CopiaRequest copiaRequest) {
        return copiaService.addCopia(copiaRequest);
    }

    @PutMapping("/update/{id}")
    public CopiaDTO updateCopia(@Valid @RequestBody CopiaRequest copiaRequest, @PathVariable Integer id) {
        return copiaService.updateCopiaById(copiaRequest, id);
    }

    @GetMapping("/all")
    public List<CopiaDTO> getAllCopie() {
        return copiaService.getAllCopie();
    }
    
    @GetMapping("/id/{id}")
    public CopiaDTO getById(@PathVariable Integer id) {
        return copiaService.getById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        copiaService.deleteById(id);
    }
}
