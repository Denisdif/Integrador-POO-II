package com.carelly.demo.mvc.form;

import java.util.List;
import com.carelly.demo.dto.ClienteDto;
import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.dto.ProblemaDto;
import com.carelly.demo.dto.TipoIdentificacionDto;

public class ClienteForm {
    private ClienteDto cliente;
    private PersonaDto persona;
    private List<TipoIdentificacionDto> tipos;
    private List<ProblemaDto> problemas;

    public List<TipoIdentificacionDto> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoIdentificacionDto> tipos) {
        this.tipos = tipos;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public List<ProblemaDto> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<ProblemaDto> problemas) {
        this.problemas = problemas;
    }
}
