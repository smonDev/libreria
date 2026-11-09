package com.libreria.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.libreria.entity.casaEditrice;

@Repository 
public interface casaEditriceRepository extends JpaRepository<casaEditrice, Integer> {

}
