package com.libreria.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.libreria.libreria.dto.AutoreDTO;
import com.libreria.libreria.dto.AutoreRequest;
import com.libreria.libreria.service.AutoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@RequestMapping ("/autori")
public class AutoreController {
    
    private final AutoreService autoreService; 

    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @PostMapping
    public AutoreDTO addAutore(@RequestBody AutoreRequest autoreRequest) {
        return autoreService.addAutore(autoreRequest);
    }
    
    @GetMapping("/all")
    public List <AutoreDTO> getAllAutori() {
        return autoreService.getAllAutori();
    }
    
    @GetMapping("/id/{id}")
    public AutoreDTO getById(@PathVariable Integer id) {
        return autoreService.getById(id);
    }

    @PutMapping("/update/{id}")
    public AutoreDTO updateById(@PathVariable Integer id, @RequestBody AutoreRequest autoreRequest) {
        return autoreService.updateById(autoreRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        autoreService.deleteById(id);
    }
}
