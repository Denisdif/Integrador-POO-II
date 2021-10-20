package com.carelly.demo.dto;

import com.carelly.demo.model.Persona;

public class ClienteDto {
// <editor-fold desc="Atributos">
    private Long id;
    private Persona persona;
// </editor-fold>

// <editor-fold desc="Constructores">
    public ClienteDto() {
    }

    public ClienteDto(Persona persona) {
        this.persona = persona;
    }
// </editor-fold>

// <editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
// </editor-fold>
}
