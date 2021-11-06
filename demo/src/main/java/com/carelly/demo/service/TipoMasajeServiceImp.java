package com.carelly.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.carelly.demo.dto.TipoMasajeDto;
import com.carelly.demo.model.TipoMasaje;
import com.carelly.demo.repository.ITipoMasajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoMasajeServiceImp implements ITipoMasajeService {

    @Autowired
    private ITipoMasajeRepository tipoMasajeJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TipoMasajeDto create(TipoMasajeDto tipoMasaje) {
        //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como parámetro
        TipoMasaje tipoMasajeEntity = modelMapper.map(tipoMasaje, TipoMasaje.class);

        //Almacenar en Base de datos ese objeto con los datos cargados 
        tipoMasajeEntity = tipoMasajeJpaRepository.save(tipoMasajeEntity);

        //Se retorna nuevamente el DTO mapeado con los datos almacenados
        return modelMapper.map(tipoMasajeEntity, TipoMasajeDto.class);
    }

    @Override
    public TipoMasajeDto get(Long id) {
        //Obtener Entidad de base de datos y almacenarla en un objeto del tipo de la Entidad
        TipoMasaje tipoMasajeEntity = tipoMasajeJpaRepository.getOne(id);

        //Mapear esos datos en un DTO
        TipoMasajeDto tipoMasajeDto = modelMapper.map(tipoMasajeEntity, TipoMasajeDto.class);

        //Retornar DTO
        return tipoMasajeDto;
    }

    @Override
    public void delete(Long id) {
        //Eliminar la Entidad de la base de datos con el id recibido
        tipoMasajeJpaRepository.deleteById(id);
    }

    @Override
    public List<TipoMasajeDto> getAll() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<TipoMasaje> listTipoMasajeEntity = tipoMasajeJpaRepository.findAll();

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<TipoMasajeDto> listTipoMasajeDto = listTipoMasajeEntity.stream().map(tipoMasaje -> modelMapper.
            map(tipoMasaje, TipoMasajeDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listTipoMasajeDto;
    }
    
}
