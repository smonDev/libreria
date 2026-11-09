package com.libreria.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.libreria.libreria.entity.Libro;

public interface LibroRepository extends JpaRepository <Libro, Integer> {

    @Query (value = """ 
        SELECT * FROM Libri
        WHERE year(anno) <= :anno;
        """, nativeQuery = true)
    List<Libro> findAllByAnno(@Param ("anno") Integer anno);

}
