package com.carelly.demo.repository;

import java.util.List;

import com.carelly.demo.model.User;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<User,Long>{
    User findByName(String name);
    @Cacheable(value = "User")
    List<User> findAll();
}
