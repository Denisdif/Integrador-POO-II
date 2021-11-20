package com.carelly.demo.model;

import java.util.ArrayList;
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

   @ManyToOne(optional = false)
   @JoinColumn(name = "id_cliente")
   private Cliente cliente;

   @ManyToMany()
   @JoinTable( name               = "truno_tipomasaje",
               joinColumns        = { @JoinColumn(name = "turno_id" ) }, 
               inverseJoinColumns = { @JoinColumn(name = "tipoMasaje_id") }
               )
   private List<TipoMasaje> tipoMasajes = new ArrayList<TipoMasaje>();
// </editor-fold>

// <editor-fold desc="Constructores">
    public Turno() {
    }    

    public Turno(Date fecha, Cliente cliente, List<TipoMasaje> tipoMasajes) {
        this.fecha = fecha;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<TipoMasaje> getTipoMasajes() {
        return tipoMasajes;
    }

    public void setTipoMasajes(List<TipoMasaje> tipoMasajes) {
        this.tipoMasajes = tipoMasajes;
    }
// </editor-fold>

    @Override
    public String toString() {
        return "Turno [cliente=" + cliente + ", fecha=" + fecha + "]";
    }

}

