package com.libreria.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libreria.libreria.entity.Genere;

@Repository 
public interface GenereRepository extends JpaRepository <Genere, Integer> {

}
