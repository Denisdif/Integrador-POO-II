package com.carelly.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.carelly.demo.dto.UserDto;
import com.carelly.demo.model.User;
import com.carelly.demo.repository.IUserJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserJpaRepository userJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto create(UserDto user) {
        //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como parámetro
        User userEntity = modelMapper.map(user, User.class);

        //Almacenar en Base de datos ese objeto con los datos cargados 
        userEntity = userJpaRepository.save(userEntity);

        //Se retorna nuevamente el DTO mapeado con los datos almacenados
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto get(Long id) {
        //Obtener Entidad de base de datos y almacenarla en un objeto del tipo de la Entidad
        User userEntity = userJpaRepository.getOne(id);

        //Mapear esos datos en un DTO
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);

        //Retornar DTO
        return userDto;
    }

    @Override
    public UserDto get(String name) {
        //Obtener Entidad de base de datos y almacenarla en un objeto del tipo de la Entidad
        User userEntity = userJpaRepository.findByName(name);

        //Mapear esos datos en un DTO
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);

        //Retornar DTO
        return userDto;
    }

    @Override
    public void delete(Long id) {
        //Eliminar la Entidad de la base de datos con el id recibido
        userJpaRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        //Obtener una lista con objetos de tipo Entidad de la Base de datos
        List<User> listUserEntity = userJpaRepository.findAll();

        //Mapear los objetos del tipo Entidad en una lista de DTOs  
        List<UserDto> listUserDto = listUserEntity.stream().map(user -> modelMapper.
            map(user, UserDto.class)).collect(Collectors.toList());
        
        //Retornar lista con DTOs
        return listUserDto;
    }
    
}
