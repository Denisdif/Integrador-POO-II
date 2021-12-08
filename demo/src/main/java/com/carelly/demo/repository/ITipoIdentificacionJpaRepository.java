package com.carelly.demo.repository;
import java.util.List;
import java.util.Optional;

import com.carelly.demo.model.TipoIdentificacion;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoIdentificacionJpaRepository extends JpaRepository<TipoIdentificacion,Long>{
    Optional<TipoIdentificacion> findByTipoIdentificacion(String tipo);
    @Cacheable(value = "tiposIdentificacion")
    List<TipoIdentificacion> findAll();
}
