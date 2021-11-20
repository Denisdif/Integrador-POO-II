package com.carelly.demo.repository;
import java.util.List;
import com.carelly.demo.model.Turno;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoJpaRepository extends JpaRepository<Turno,Long>{
    //select fields from Cliente where id='[parametro]'
    Turno findByid(String id);
    @Cacheable(value = "Turnos")
    List<Turno> findAll();
}
