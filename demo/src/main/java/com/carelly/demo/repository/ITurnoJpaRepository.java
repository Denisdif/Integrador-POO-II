package com.carelly.demo.repository;
import java.util.List;

import com.carelly.demo.model.Persona;
import com.carelly.demo.model.Turno;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoJpaRepository extends JpaRepository<Turno,Long>{
    @Cacheable(value = "Turnos")
    List<Turno> findAll();
    List<Turno> findByHabilitado(Boolean habilitado);
    List<Turno> findByPersona(Persona persona);
}
