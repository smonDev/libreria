package com.libreria.libreria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libreria.libreria.entity.Genere;

@Repository 
public interface GenereRepository extends JpaRepository <Genere, Integer> {
    //Optional gestisce meglio genere, quando per esempio viene aggiunto un genere che non è nel DB, l'app non si rompe
    Optional <Genere> findByNome(String nome);

}
