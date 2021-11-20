package com.carelly.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.carelly.demo.model.Cliente;
import com.carelly.demo.model.TipoMasaje;

public class TurnoDto {
// <editor-fold desc="Atributos">
   private Long id;
   private Date fecha;
   private Cliente cliente;
   private List<TipoMasaje> tipoMasajes = new ArrayList<TipoMasaje>();
// </editor-fold>

// <editor-fold desc="Constructores">
    public TurnoDto() {

    }
    public TurnoDto(Date fecha, Cliente cliente, List<TipoMasaje> tipoMasajes) {
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
}
