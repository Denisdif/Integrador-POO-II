package com.carelly.demo.service;

import java.util.List;

import com.carelly.demo.dto.TipoIdentificacionDto;

public interface ITipoIdentificacionService {
    public TipoIdentificacionDto create(TipoIdentificacionDto tipo);
    public TipoIdentificacionDto get(Long id);
    public List<TipoIdentificacionDto> getAll();
    public void delete(Long id);
}
