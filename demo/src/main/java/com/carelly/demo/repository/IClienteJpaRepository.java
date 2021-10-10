package com.carelly.demo.repository;

import com.carelly.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteJpaRepository extends JpaRepository<Cliente,Long>{
    //select fields from Cliente where id='[parametro]'
    Cliente findByid(String id);
}
