package com.carelly.demo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Turno
 */
@Entity
public class Turno {

// <editor-fold desc="Atributos">
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(nullable = false)
   private Date fecha;

   @Column(nullable = true)
   private Boolean habilitado;

   @ManyToOne(optional = false)
   @JoinColumn(name = "id_persona")
   private Persona persona;

   @ManyToMany()
   @JoinTable( name               = "turno_tipomasaje",
               joinColumns        = { @JoinColumn(name = "turno_id" ) }, 
               inverseJoinColumns = { @JoinColumn(name = "tipoMasaje_id") }
               )
   private List<TipoMasaje> tipoMasajes = new ArrayList<TipoMasaje>();
// </editor-fold>

// <editor-fold desc="Constructores">
    public Turno() {
    }    

    public Turno(Date fecha, Persona persona, List<TipoMasaje> tipoMasajes) {
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

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
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

    @Override
    public String toString() {
        return "Turno [persona=" + persona + ", tipoMasajes=" + tipoMasajes + "]";
    }

}

