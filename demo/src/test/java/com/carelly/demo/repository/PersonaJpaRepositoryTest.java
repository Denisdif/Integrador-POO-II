package com.carelly.demo.repository;

import java.util.List;
import java.util.Optional;

import com.carelly.demo.model.Persona;
import com.carelly.demo.model.TipoIdentificacion;

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
public class PersonaJpaRepositoryTest {

    @Autowired
    private IPersonaJpaRepository repo;

    @Autowired
    private ITipoIdentificacionJpaRepository repoTipoId;

    @Test 
    // @Order(1)
    public void createPersona() {

        TipoIdentificacion tipo = repoTipoId.findById(9L).get();
        Persona persona = new Persona("Juan", "Pérez", "40555222", "Masculino", "15457898", 
                        "juan@mail.com", "Posadas", null, tipo, null);

        repo.save(persona);
        Assertions.assertThat(persona.getId()).isGreaterThan(0);
    }   

    @Test
    // @Order(2)
    public void getPersona() {

        Persona persona = repo.findById(35L).get();
        Assertions.assertThat(persona.getId()).isEqualTo(35L);

    }

    @Test
    // @Order(3)
    public void getListOfPersonas() {

        List<Persona> personas = repo.findAll();
        Assertions.assertThat(personas.size()).isGreaterThan(0);
        
    }

    @Test
    // @Order(4)
    public void updatePersona() {

        Persona persona = repo.findById(39L).get();
        persona.setNombre("Matías Agustín");
        Persona updatedPersona = repo.save(persona);
        Assertions.assertThat(updatedPersona.getNombre()).isEqualTo("Matías Agustín");

    }

    @Test 
    // @Order(5)
    public void deletePersona() {

        Persona persona = repo.findById(31L).get();
        repo.delete(persona);
        Persona persona1 = null;
        Optional<Persona> optionalPersona = repo.findByApellido("Scocco");

        if (optionalPersona.isPresent()) {
            persona1 = optionalPersona.get();
        }

        Assertions.assertThat(persona1).isNull();
    }

}