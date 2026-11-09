package com.libreria.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libreria.libreria.entity.Copia;

@Repository 
public interface CopiaRepository extends JpaRepository<Copia, Integer> {

}
