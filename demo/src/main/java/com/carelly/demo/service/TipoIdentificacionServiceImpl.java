package com.carelly.demo.service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public TipoIdentificacionDto get(Long id) {
        TipoIdentificacion tipoEntity = tipoIdentificacionJpaRepository.getOne(id);
        TipoIdentificacionDto tipoDto = modelMapper.map(tipoEntity, TipoIdentificacionDto.class);
        return tipoDto;
    }

    @Override
    public List<TipoIdentificacionDto> getAll() {
        List<TipoIdentificacion> listEntity = tipoIdentificacionJpaRepository.findAll();
        List<TipoIdentificacionDto> listDto = listEntity.stream().map(tipo -> modelMapper.
            map(tipo, TipoIdentificacionDto.class)).collect(Collectors.toList());
        return listDto;
    }

    @Override
    public void delete(Long id) {
        tipoIdentificacionJpaRepository.deleteById(id);
    }


}
