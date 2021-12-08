package com.carelly.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.dto.TurnoDto;
import com.carelly.demo.model.Persona;
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
    public Boolean create(TurnoDto newTurno) {
        //Control para guardar
        Boolean permitir = true;
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<TurnoDto> listTurnoEntityAux = this.getAll();

        for (TurnoDto turno : listTurnoEntityAux)
        {   
            //Si el inicio del nuevo turno es MENOR que los turnos almacenados => 
            //El final del nuevo turno tiene que ser menor que el inicio de los almacenados
            if ((turno.getFecha().getTime() >= newTurno.getFecha().getTime()) 
            &  !(turno.getFecha().getTime() > newTurno.getFinalizacion().getTime()))
            {
                permitir = false;
            }
            //Si el inicio del nuevo turno es MAYOR que los turnos almacenados =>
            //El inicio del nuevo turno tiene que ser mayor que el final de los almacenados
            if ((turno.getFecha().getTime() <= newTurno.getFecha().getTime()) 
            &  !(newTurno.getFecha().getTime() > turno.getFinalizacion().getTime()))
            {
                permitir = false;
            }
        }

        if (permitir) {
            //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como parámetro
            Turno turnoEntity = modelMapper.map(newTurno, Turno.class);

            //Almacenar en Base de datos ese objeto con los datos cargados 
            turnoEntity = turnoJpaRepository.save(turnoEntity); 
        }

        //Se retorna nuevamente el DTO mapeado con los datos almacenados
        return permitir;
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
    // Turnos aprobados posteriores a fecha actual
    public List<TurnoDto> getAll() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<Turno> listTurnoEntityAux = turnoJpaRepository.findByHabilitado(true);
        List<Turno> listTurnoEntity = new ArrayList<>();

        //Control para que sean posteriores a la fecha actual
        for (Turno turno : listTurnoEntityAux)
        {
            if (turno.getFecha().getTime() > new Date().getTime() )
            {
                listTurnoEntity.add(turno);
            }
        }

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<TurnoDto> listTurnoDto = listTurnoEntity.stream().map(turno -> modelMapper.
            map(turno, TurnoDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listTurnoDto;
    }

    @Override
    // Solicitudes posteriores a fecha actual
    public List<TurnoDto> getSolicitudes() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<Turno> listTurnoEntityAux = turnoJpaRepository.findByHabilitado(null);
        List<Turno> listTurnoEntity = new ArrayList<>();

        for (Turno turno : listTurnoEntityAux)
        {
            if (turno.getFecha().getTime() > new Date().getTime() )
            {
                listTurnoEntity.add(turno);
            }
        }

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<TurnoDto> listTurnoDto = listTurnoEntity.stream().map(turno -> modelMapper.
            map(turno, TurnoDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listTurnoDto;
    }

    @Override
    // Mis turnos y solicitudes
    public List<TurnoDto> getMisTurnos(PersonaDto personaDto) {

        //Mapear persona entity a partir de personaDto
        Persona persona = modelMapper.map(personaDto, Persona.class);

        //lista de mis turnos 
        List<Turno> listTurnoEntityAux = turnoJpaRepository.findByPersona(persona);

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<TurnoDto> listTurnoDto = listTurnoEntityAux.stream().map(turno -> modelMapper.
        map(turno, TurnoDto.class)).collect(Collectors.toList());

        //Retornar DTO
        return listTurnoDto;
    }
    
}
