package com.carelly.demo.dto;

import java.util.ArrayList;
import java.util.Calendar;
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

// <editor-fold desc="Otros Métodos">

    //Get fecha fin
    public Date getFinalizacion() {

        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(this.getFecha()); // Configuramos la fecha que se recibe
        
        calendar.add(Calendar.MINUTE, this.getDuracion());  // numero de horas a añadir, o restar en caso de horas<0

        return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	
    }

    //Get duración (Suma de todos los tipos de masaje más el inicio)
    public Integer getDuracion() {
        Integer duracion = 0;
        for (TipoMasaje tipoMasaje : this.tipoMasajes) {
            duracion += tipoMasaje.getTiempo();
        }
        return duracion; 
    }
// </editor-fold>

}
