package com.carelly.demo.service;

import com.carelly.demo.dto.TipoIdentificacionDto;
import com.carelly.demo.model.TipoIdentificacion;
import com.carelly.demo.repository.ITipoIdentificacionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class TipoIdentificacionServiceImpl implements ITipoIdentificacionService{

    @Autowired
    private ITipoIdentificacionJpaRepository tipoIdentificacionJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TipoIdentificacionDto create(TipoIdentificacionDto tipo) {
        TipoIdentificacion tipoEntity = modelMapper.map(tipo, TipoIdentificacion.class);
        tipoEntity = tipoIdentificacionJpaRepository.save(tipoEntity);
        return modelMapper.map(tipoEntity, TipoIdentificacionDto.class);
    }
}
