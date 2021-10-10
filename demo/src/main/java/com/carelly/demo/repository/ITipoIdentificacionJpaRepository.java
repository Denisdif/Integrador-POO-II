package com.carelly.demo.repository;

import com.carelly.demo.model.TipoIdentificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoIdentificacionJpaRepository extends JpaRepository<TipoIdentificacion,Long>{
    //select fields from TipoIdentificacion where id='[parametro]'
    TipoIdentificacion findByid(String id);
}
