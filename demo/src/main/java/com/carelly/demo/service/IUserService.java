package com.carelly.demo.service;

import java.util.List;

import com.carelly.demo.dto.UserDto;

public interface IUserService {
    public UserDto create(UserDto user);
    public UserDto get(Long id);
    public UserDto get(String name);
    public void delete(Long id);
    public List<UserDto> getAll();
}
