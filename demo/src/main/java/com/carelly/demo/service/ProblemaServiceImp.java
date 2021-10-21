package com.carelly.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.carelly.demo.dto.ProblemaDto;
import com.carelly.demo.model.Problema;
import com.carelly.demo.repository.IProblemaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProblemaServiceImp implements IProblemaService{

    @Autowired
    private IProblemaRepository problemaJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProblemaDto create(ProblemaDto problema) {
        //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como parámetro
        Problema problemaEntity = modelMapper.map(problema, Problema.class);
        
        //Almacenar en Base de datos ese objeto con los datos cargados 
        problemaEntity = problemaJpaRepository.save(problemaEntity);

        //Se retorna nuevamente el DTO mapeado con los datos almacenados
        return modelMapper.map(problemaEntity, ProblemaDto.class);
    }

    @Override
    public ProblemaDto get(Long id) {
        //Obtener Entidad de base de datos y almacenarla en un objeto del tipo de la Entidad
        Problema problemaEntity = problemaJpaRepository.getOne(id);

        //Mapear esos datos en un DTO
        ProblemaDto problemaDto = modelMapper.map(problemaEntity, ProblemaDto.class);

        //Retornar DTO
        return problemaDto;
    }

    @Override
    public void delete(Long id) {
        //Eliminar la Entidad de la base de datos con el id recibido
        problemaJpaRepository.deleteById(id);
    }

    @Override
    public List<ProblemaDto> getAll() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<Problema> listProblemaEntity = problemaJpaRepository.findAll();

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<ProblemaDto> listProblemaDto = listProblemaEntity.stream().map(problema -> modelMapper.
            map(problema, ProblemaDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listProblemaDto;
    }
    
}
