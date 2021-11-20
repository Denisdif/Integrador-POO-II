package com.carelly.demo.repository;

import com.carelly.demo.model.TipoMasaje;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TipoMasajeJpaRepositoryTest {

    @Autowired
    ITipoMasajeRepository repo;

    @Test 
    // @Order(1)
    public void createTipoMasaje() {

        TipoMasaje tipo = new TipoMasaje("Masaje para contracturas", "Este tipo de masaje se enfoca en eliminar contracturas musculares");
        repo.save(tipo);
        Assertions.assertThat(tipo.getId()).isGreaterThan(0);
    }   

    @Test
    // @Order(2)
    public void getTipoMasaje() {

        TipoMasaje tipo = repo.findById(22L).get();
        Assertions.assertThat(tipo.getId()).isEqualTo(22L);

    }

    @Test
    // @Order(3)
    public void getListOfTiposDeMasajes() {

        List<TipoMasaje> tipos = repo.findAll();
        Assertions.assertThat(tipos.size()).isGreaterThan(0);
        
    }

    @Test
    // @Order(4)
    public void updateTipoMasaje() {

        TipoMasaje tipo = repo.findById(21L).get();
        tipo.setTipoMasaje("Masaje descontracturante");
        TipoMasaje updatedTipoMasaje = repo.save(tipo);
        Assertions.assertThat(updatedTipoMasaje.getTipoMasaje()).isEqualTo("Masaje descontracturante");

    }

    @Test 
    // @Order(5)
    public void deleteTipoMasaje() {

        TipoMasaje tipo = repo.findById(24L).get();
        repo.delete(tipo);
        TipoMasaje tipo1 = null;
        Optional<TipoMasaje> optionalTipo = repo.findByTipoMasaje("Masaje sueco");

        if (optionalTipo.isPresent()) {
            tipo1 = optionalTipo.get();
        }

        Assertions.assertThat(tipo1).isNull();
    }


}