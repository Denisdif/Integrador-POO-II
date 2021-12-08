package com.carelly.demo.service;
import java.util.List;

import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.dto.TurnoDto;

public interface ITurnoService {
    public Boolean create(TurnoDto turno);
    public TurnoDto get(Long id);
    public void delete(Long id);
    public List<TurnoDto> getAll();
    public List<TurnoDto> getSolicitudes();
    public List<TurnoDto> getMisTurnos(PersonaDto persona);
}
