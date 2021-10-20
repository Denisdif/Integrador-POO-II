package com.carelly.demo.service;

import java.util.List;

import com.carelly.demo.dto.ClienteDto;

public interface IClienteService {
    public ClienteDto create(ClienteDto cliente);
    public ClienteDto get(Long id);
    public void delete(Long id);
    public List<ClienteDto> getAll();
}
