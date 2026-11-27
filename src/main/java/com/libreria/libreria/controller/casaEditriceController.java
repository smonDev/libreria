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

import com.libreria.libreria.dto.casaEditriceDTO;
import com.libreria.libreria.dto.request.casaEditriceRequest;
import com.libreria.libreria.service.CasaEditriceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/caseeditrici")
public class casaEditriceController {

    private final CasaEditriceService casaEditriceService;

    public casaEditriceController(CasaEditriceService casaEditriceService) {
        this.casaEditriceService = casaEditriceService;
    }

    @GetMapping("/all")
    public List<casaEditriceDTO> getAll() {
        return casaEditriceService.getAllCaseEditrici();
    }

    @PostMapping
    public casaEditriceDTO aggiungiCasaEditrice(@Valid @RequestBody casaEditriceRequest casaEditriceRequest) {
        return casaEditriceService.addNewCasaEditrice(casaEditriceRequest);
    }

    @PutMapping("/{id}")
    public casaEditriceDTO modificaCasaEditrice(@PathVariable Integer id,
            @Valid @RequestBody casaEditriceRequest casaEditriceRequest) {
        return casaEditriceService.updateById(casaEditriceRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        casaEditriceService.deleteById(id);
    }

}
