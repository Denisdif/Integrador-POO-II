package com.carelly.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.carelly.demo.model.Persona;
import com.carelly.demo.model.TipoMasaje;

public class TurnoDto {
// <editor-fold desc="Atributos">
   private Long id;
   private Date fecha;
   private Persona persona;
   private Boolean habilitado;
   private List<TipoMasaje> tipoMasajes = new ArrayList<TipoMasaje>();
// </editor-fold>

// <editor-fold desc="Constructores">
    public TurnoDto() {

    }
    public TurnoDto(Date fecha, Persona persona, List<TipoMasaje> tipoMasajes) {
        this.fecha = fecha;
        this.persona = persona;
        this.tipoMasajes = tipoMasajes;
    }
// </editor-fold>

// <editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Boolean getHabilitado() {
        return habilitado;
    }
    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public List<TipoMasaje> getTipoMasajes() {
        return tipoMasajes;
    }
    public void setTipoMasajes(List<TipoMasaje> tipoMasajes) {
        this.tipoMasajes = tipoMasajes;
    }

// </editor-fold>
}
