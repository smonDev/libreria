package com.libreria.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.libreria.entity.Autore;

//Nel Repository servono come dati solamente il tipo della Entity e il tipo di dato che fa riferimento all'id
//Le parentesi acute vengono utilizzate per i Generics 
//I Generics permettono di specificare a una classe o a un'interfaccia quale tipo di dato deve gestire

@Repository 
public interface AutoreRepository extends JpaRepository <Autore, Integer> {

}
