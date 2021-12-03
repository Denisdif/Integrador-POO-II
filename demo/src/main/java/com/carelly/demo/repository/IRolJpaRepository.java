package com.carelly.demo.repository;

import com.carelly.demo.model.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolJpaRepository extends JpaRepository<Rol,Long>{
    Rol findByRol(String rol);
}
