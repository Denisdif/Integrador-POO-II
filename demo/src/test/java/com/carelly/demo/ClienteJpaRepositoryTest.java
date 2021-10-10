package com.carelly.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.carelly.demo.model.Cliente;
import com.carelly.demo.repository.IClienteJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ClienteJpaRepositoryTest {
    @Autowired
    private IClienteJpaRepository repository;

    @Test
    public void saveCliente(){
        Cliente john = new Cliente();
        Cliente jose = new Cliente();
        repository.save(john);
        repository.save(jose);
        repository.flush();

        assertEquals(2, repository.findAll().size());
    }

}
