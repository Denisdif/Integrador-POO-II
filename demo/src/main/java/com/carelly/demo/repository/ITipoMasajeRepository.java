package com.carelly.demo.repository;
import java.util.List;
import java.util.Optional;


import com.carelly.demo.model.TipoMasaje;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoMasajeRepository extends JpaRepository<TipoMasaje,Long>{
    //select fields from TipoIdentificacion where id='[parametro]'
    //TipoMasaje findByid(String id);
    Optional<TipoMasaje> findByTipoMasaje(String tipo);

    @Cacheable(value = "tiposMsajeTipoMasaje")
    List<TipoMasaje> findAll();
}
