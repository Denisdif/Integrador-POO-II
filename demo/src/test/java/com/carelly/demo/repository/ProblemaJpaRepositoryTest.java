package com.carelly.demo.repository;

import java.util.List;
import java.util.Optional;

import com.carelly.demo.model.Problema;

import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProblemaJpaRepositoryTest {

    @Autowired
    private IProblemaRepository repo;

    @Test 
    // @Order(1)
    public void createProblema() {

        Problema problema = new Problema("Hernia de disco");
        repo.save(problema);
        Assertions.assertThat(problema.getId()).isGreaterThan(0);
    }   

    @Test
    // @Order(2)
    public void getProblema() {

        Problema problema = repo.findById(15L).get();
        Assertions.assertThat(problema.getId()).isEqualTo(15L);

    }

    @Test
    // @Order(3)
    public void getListOfProblemas() {

        List<Problema> problemas = repo.findAll();
        Assertions.assertThat(problemas.size()).isGreaterThan(0);
        
    }

    @Test
    // @Order(4)
    public void updateProblema() {

        Problema problema = repo.findById(19L).get();
        problema.setProblema("New problema");
        Problema updatedProblema = repo.save(problema);
        Assertions.assertThat(updatedProblema.getProblema()).isEqualTo("New problema");

    }

    @Test 
    // @Order(5)
    public void deleteProblema() {

        Problema problema = repo.findById(20L).get();
        repo.delete(problema);
        Problema problema1 = null;
        Optional<Problema> optionalProblema = repo.findByProblema("Dislocaciones");

        if (optionalProblema.isPresent()) {
            problema1 = optionalProblema.get();
        }

        Assertions.assertThat(problema1).isNull();
    }

}