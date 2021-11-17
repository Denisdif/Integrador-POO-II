package com.carelly.demo.dto;

import java.util.Date;

import com.carelly.demo.model.Cliente;

public class TurnoDto {
    // <editor-fold desc="Atributos">
   private Long id;
   private Date fecha;
   private Cliente cliente;
// </editor-fold>

// <editor-fold desc="Constructores">
    public TurnoDto() {

    }
    public TurnoDto(Date fecha, Cliente cliente) {
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
    
}
