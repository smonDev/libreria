package com.libreria.libreria.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.libreria.libreria.dto.AutoreDTO;
import com.libreria.libreria.dto.CopiaDTO;
import com.libreria.libreria.dto.GenereDTO;
import com.libreria.libreria.dto.LibroDTO;
import com.libreria.libreria.dto.casaEditriceDTO;
import com.libreria.libreria.entity.Autore;
import com.libreria.libreria.entity.Copia;
import com.libreria.libreria.entity.Genere;
import com.libreria.libreria.entity.Libro;
import com.libreria.libreria.entity.casaEditrice;

//CREO UNA CLASSE MAPPER dove racchiudo tutti i metodi del Converter e lo utilizzo per ogni Entity che ho creato nel progetto
@Component
public class Mapper {

    // Autore
    public AutoreDTO toAutoreDTO(Autore autore) {
        // Se l'autore è null, torna un oggetto AutoreDTO null
        if (autore == null) {
            return null;
        }
        // Se non è null, creo un nuovo oggetto
        AutoreDTO autoreDTOret = new AutoreDTO();
        // Poi setto tutti i campi
        autoreDTOret.setId(autore.getIdAutore());
        autoreDTOret.setNome(autore.getNome());
        autoreDTOret.setCognome(autore.getCognome());
        autoreDTOret.setNazionalita(autore.getNazionalita());

        return autoreDTOret;
    }

    // AutoreDTO
    public Autore toAutore(AutoreDTO autoreDTO) {
        if (autoreDTO == null) {
            return null;
        }
            Autore autoreRet = new Autore();

            autoreRet.setIdAutore(autoreDTO.getId());
            autoreRet.setNome(autoreDTO.getNome());
            autoreRet.setCognome(autoreDTO.getCognome());
            autoreRet.setNazionalita(autoreDTO.getNazionalita());
        
            return autoreRet;
    }

    // Libro
    public LibroDTO toLibroDTO(Libro libro) {
        if (libro == null) {
            return null;
        }
        LibroDTO libroDTOret = new LibroDTO();

        libroDTOret.setId(libro.getIsbn());
        libroDTOret.setTitolo(libro.getTitolo());
        libroDTOret.setAnno(libro.getAnno());
        // passo GenereDTO perché mi serve un tipo Libro, quindi in Libro c'è Genere
        libroDTOret.setGenere(toGenereDTO(libro.getGenere()));
        List<AutoreDTO> autoriDTO = new ArrayList<>();
        for (Autore autore : libro.getAutori())
            autoriDTO.add(toAutoreDTO(autore));
        libroDTOret.setAutori(autoriDTO);

        return libroDTOret;
    }

    // LibroDTO
    public Libro toLibro(LibroDTO libroDTO) {
        if (libroDTO == null) {
            return null;
        }
        Libro libroRet = new Libro();

        libroRet.setIsbn(libroDTO.getId());
        libroRet.setTitolo(libroDTO.getTitolo());
        libroRet.setAnno(libroDTO.getAnno());
        // dato che il libro vuole Genere e LibroDTO ha GenereDTO, devo convertirlo
        libroRet.setGenere(toGenere(libroDTO.getGenere()));
         List<AutoreDTO> autoriDTO = new ArrayList<>();
        for (AutoreDTO autoreDTO : libroDTO.getAutori()) {
            libroRet.getAutori().add(toAutore(autoreDTO));
        }
        return libroRet;
    }

    // Genere
    public GenereDTO toGenereDTO(Genere genere) {
        if (genere == null) {
            return null;
        }
        GenereDTO genereDTOret = new GenereDTO();

        genereDTOret.setId(genere.getidGenere());
        genereDTOret.setNome(genere.getNome());

        return genereDTOret;
    }

    // GenereDTO
    public Genere toGenere(GenereDTO genereDTO) {
        if (genereDTO == null) {
            return null;
        }
        Genere genereRet = new Genere();

        genereRet.setidGenere(genereDTO.getId());
        genereRet.setNome(genereDTO.getNome());

        return genereRet;
    }

    // casaEditrice
    public casaEditrice toCasaEditrice(casaEditriceDTO casaeditriceDTO) {
        if (casaeditriceDTO == null) {
            return null;
        }
            casaEditrice casaEditriceRet = new casaEditrice();

            casaEditriceRet.setId(casaeditriceDTO.getId());
            casaEditriceRet.setNome(casaeditriceDTO.getNome());
    
            return casaEditriceRet;
    }

    // casaEditriceDTO
    public casaEditriceDTO toCasaEditriceDTO(casaEditrice casaeditrice) {
        if (casaeditrice == null) {
            return null;
        }
            casaEditriceDTO casaEditriceDTOret = new casaEditriceDTO();

            casaEditriceDTOret.setId(casaeditrice.getId());
            casaEditriceDTOret.setNome(casaeditrice.getNome());
        
            return casaEditriceDTOret;
    }

    // Copia
    public CopiaDTO toCopiaDTO(Copia copia) {
        if (copia == null) {
            return null;
        }
            CopiaDTO copiaDTOret = new CopiaDTO();

            copiaDTOret.setId(copia.getId());
            copiaDTOret.setCasaeditrice(toCasaEditriceDTO(copia.getCasaeditrice()));
            // passo casaEditriceDTO perché devo convertirlo in CopiaDTO, e in CopiaDTO c'è
            // casaEditriceDTO
            copiaDTOret.setNum_copie(copia.getNum_copie());
        
            return copiaDTOret;
    }

    // CopiaDTO
    public Copia toCopia(CopiaDTO copiaDTO) {
        if (copiaDTO == null) {
            return null;
        }
            Copia copiaRet = new Copia();

            copiaRet.setId(copiaDTO.getId());
            copiaRet.setCasaeditrice(toCasaEditrice(copiaDTO.getCasaeditrice()));
            // passo casaEditrice perché devo convertirlo in Copia, e in Copia c'è
            // casaEditrice
            copiaRet.setNum_copie(copiaDTO.getNum_copie());
        
            return copiaRet;
    }

} // EndClass
