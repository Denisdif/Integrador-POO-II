package com.carelly.demo.repository;

import com.carelly.demo.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaJpaRepository extends JpaRepository<Persona,Long> {
    //select fields from Persona where id='[parametro]'
    Persona findByid(String id);
}
