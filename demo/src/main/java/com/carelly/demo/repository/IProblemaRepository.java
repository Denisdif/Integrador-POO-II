package com.carelly.demo.repository;

import java.util.List;

import com.carelly.demo.model.Problema;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProblemaRepository extends JpaRepository<Problema,Long>{
    //select fields from Problema where id='[parametro]'
    Problema findByid(String id);
    @Cacheable(value = "Problemas")
    List<Problema> findAll();
}
