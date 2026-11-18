package com.libreria.libreria.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libreria.libreria.entity.casaEditrice;

@Repository 
//Aggiungo un metodo non presente nei metodi CRUD di JPA.
//findByNome() è un metodo personalizzato, quindi se non lo compilo qui nel Service non avrò la possibilità di scriverlo senza generare un errore. 
//Tutti i metodi inseriti nel Repository manualmente sono metodi non presenti tra i CRUD di JPA
public interface casaEditriceRepository extends JpaRepository<casaEditrice, Integer> {
    Optional <casaEditrice> findByNome(String nome);
    

}
