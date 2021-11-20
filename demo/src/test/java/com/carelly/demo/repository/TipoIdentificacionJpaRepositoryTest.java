package com.carelly.demo.repository;

import java.util.List;
import java.util.Optional;

import com.carelly.demo.model.TipoIdentificacion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TipoIdentificacionJpaRepositoryTest {

    @Autowired
    ITipoIdentificacionJpaRepository repo;

    @Test 
    // @Order(1)
    public void createTipoIdentificacion() {

        TipoIdentificacion tipo = new TipoIdentificacion("GREEN CARD");
        repo.save(tipo);
        Assertions.assertThat(tipo.getId()).isGreaterThan(0);
    }   

    @Test
    // @Order(2)
    public void getTipoIdentificacion() {

        TipoIdentificacion tipo = repo.findById(10L).get();
        Assertions.assertThat(tipo.getId()).isEqualTo(10L);

    }

    @Test
    // @Order(3)
    public void getListOfTipoIdentificacion() {

        List<TipoIdentificacion> tipos = repo.findAll();
        Assertions.assertThat(tipos.size()).isGreaterThan(0);
        
    }

    @Test
    // @Order(4)
    public void updateTipoIdentificacion() {

        TipoIdentificacion tipo = repo.findById(12L).get();
        tipo.setTipoIdentificacion("New tipo identificación");
        TipoIdentificacion updatedTipo = repo.save(tipo);
        Assertions.assertThat(updatedTipo.getTipoIdentificacion()).isEqualTo("New tipo identificación");

    }

    @Test 
    // @Order(5)
    public void deleteTipoIdentificacion() {

        TipoIdentificacion tipo = repo.findById(10L).get();
        repo.delete(tipo);
        TipoIdentificacion tipo1 = null;
        Optional<TipoIdentificacion> optionalTipo = repo.findByTipoIdentificacion("VISA");

        if (optionalTipo.isPresent()) {
            tipo1 = optionalTipo.get();
        }

        Assertions.assertThat(tipo1).isNull();
    }

}