package com.carelly.demo.repository;
import java.util.List;
import com.carelly.demo.model.TipoMasaje;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoMasajeRepository extends JpaRepository<TipoMasaje,Long>{
    //select fields from TipoIdentificacion where id='[parametro]'
    TipoMasaje findByid(String id);
    @Cacheable(value = "tiposMsajeTipoMasaje")
    List<TipoMasaje> findAll();
}
