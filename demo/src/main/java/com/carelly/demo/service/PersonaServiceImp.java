package com.carelly.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.model.Persona;
import com.carelly.demo.repository.IPersonaJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonaServiceImp implements IPersonaService{

    @Autowired
    private IPersonaJpaRepository personaJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PersonaDto create(PersonaDto persona) {
        //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como parámetro
        Persona personaEntity = modelMapper.map(persona, Persona.class);
        
        //Almacenar en Base de datos ese objeto con los datos cargados 
        personaEntity = personaJpaRepository.save(personaEntity);

        //Se retorna nuevamente el DTO mapeado con los datos almacenados
        return modelMapper.map(personaEntity, PersonaDto.class);
    }

    @Override
    public PersonaDto get(Long id) {
        //Obtener Entidad de base de datos y almacenarla en un objeto del tipo de la Entidad
        Persona personaEntity = personaJpaRepository.getOne(id);

        //Mapear esos datos en un DTO
        PersonaDto personaDto = modelMapper.map(personaEntity, PersonaDto.class);

        //Retornar DTO
        return personaDto;
    }

    @Override
    public void delete(Long id) {
        //Eliminar la Entidad de la base de datos con el id recibido
        personaJpaRepository.deleteById(id);
    }

    @Override
    public List<PersonaDto> getAll() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<Persona> listPersonaEntity = personaJpaRepository.findAll();

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<PersonaDto> listPersonaDto = listPersonaEntity.stream().map(persona -> modelMapper.
            map(persona, PersonaDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listPersonaDto;
    }
    
}
