package com.carelly.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.carelly.demo.dto.TurnoDto;
import com.carelly.demo.model.Turno;
import com.carelly.demo.repository.ITurnoJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoServiceImp implements ITurnoService{

    @Autowired
    private ITurnoJpaRepository turnoJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TurnoDto create(TurnoDto turno) {
        //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como parámetro
        Turno turnoEntity = modelMapper.map(turno, Turno.class);

        //Almacenar en Base de datos ese objeto con los datos cargados 
        turnoEntity = turnoJpaRepository.save(turnoEntity);

        //Se retorna nuevamente el DTO mapeado con los datos almacenados
        return modelMapper.map(turnoEntity, TurnoDto.class);
    }

    @Override
    public TurnoDto get(Long id) {
        //Obtener Entidad de base de datos y almacenarla en un objeto del tipo de la Entidad
        Turno turnoEntity = turnoJpaRepository.getOne(id);

        //Mapear esos datos en un DTO
        TurnoDto turnoDto = modelMapper.map(turnoEntity, TurnoDto.class);

        //Retornar DTO
        return turnoDto;
    }

    @Override
    public void delete(Long id) {
       //Eliminar la Entidad de la base de datos con el id recibido
       turnoJpaRepository.deleteById(id);
    }

    @Override
    public List<TurnoDto> getAll() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<Turno> listTurnoEntity = turnoJpaRepository.findAll();

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<TurnoDto> listTurnoDto = listTurnoEntity.stream().map(turno -> modelMapper.
            map(turno, TurnoDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listTurnoDto;
    }
    
}
