package com.carelly.demo.service;

import java.util.List;

import com.carelly.demo.dto.PersonaDto;

public interface IPersonaService {
    public PersonaDto create(PersonaDto persona);
    public PersonaDto get(Long id);
    public void delete(Long id);
    public List<PersonaDto> getAll();
}
