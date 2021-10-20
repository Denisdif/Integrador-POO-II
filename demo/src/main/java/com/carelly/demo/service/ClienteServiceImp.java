package com.carelly.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.carelly.demo.dto.ClienteDto;
import com.carelly.demo.model.Cliente;
import com.carelly.demo.repository.IClienteJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServiceImp implements IClienteService{

    @Autowired
    private IClienteJpaRepository clienteJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDto create(ClienteDto cliente) {
        //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como parámetro
        Cliente clienteEntity = modelMapper.map(cliente, Cliente.class);
        
        //Almacenar en Base de datos ese objeto con los datos cargados 
        clienteEntity = clienteJpaRepository.save(clienteEntity);

        //Se retorna nuevamente el DTO mapeado con los datos almacenados
        return modelMapper.map(clienteEntity, ClienteDto.class);
    }

    @Override
    public ClienteDto get(Long id) {
        //Obtener Entidad de base de datos y almacenarla en un objeto del tipo de la Entidad
        Cliente clienteEntity = clienteJpaRepository.getOne(id);

        //Mapear esos datos en un DTO
        ClienteDto clienteDto = modelMapper.map(clienteEntity, ClienteDto.class);

        //Retornar DTO
        return clienteDto;
    }

    @Override
    public void delete(Long id) {
        //Eliminar la Entidad de la base de datos con el id recibido
        clienteJpaRepository.deleteById(id);
    }

    @Override
    public List<ClienteDto> getAll() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<Cliente> listClienteEntity = clienteJpaRepository.findAll();

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<ClienteDto> listClienteDto = listClienteEntity.stream().map(cliente -> modelMapper.
            map(cliente, ClienteDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listClienteDto;
    }
}
