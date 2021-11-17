package com.carelly.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
// </editor-fold>

// <editor-fold desc="Constructores">
    public Turno() {
    }    

    public Turno(Date fecha, Cliente cliente) {
            this.fecha = fecha;
            this.cliente = cliente;
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
// </editor-fold>

    @Override
    public String toString() {
        return "Turno [cliente=" + cliente + ", fecha=" + fecha + "]";
    }
    
}