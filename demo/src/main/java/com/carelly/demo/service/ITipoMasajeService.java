package com.carelly.demo.service;
import java.util.List;
import com.carelly.demo.dto.TipoMasajeDto;

public interface ITipoMasajeService {
    public TipoMasajeDto create(TipoMasajeDto tipo);
    public TipoMasajeDto get(Long id);
    public void delete(Long id);
    public List<TipoMasajeDto> getAll();
}
