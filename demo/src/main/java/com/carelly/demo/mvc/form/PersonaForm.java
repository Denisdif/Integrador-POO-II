package com.carelly.demo.mvc.form;

import java.util.List;

import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.dto.ProblemaDto;
import com.carelly.demo.dto.TipoIdentificacionDto;

public class PersonaForm {
    private PersonaDto persona;
    private List<TipoIdentificacionDto> tipos;
    private List<ProblemaDto> problemasAll;

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public List<TipoIdentificacionDto> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoIdentificacionDto> tipos) {
        this.tipos = tipos;
    }

    public List<ProblemaDto> getProblemasAll() {
        return problemasAll;
    }

    public void setProblemasAll(List<ProblemaDto> problemasAll) {
        this.problemasAll = problemasAll;
    }
}
