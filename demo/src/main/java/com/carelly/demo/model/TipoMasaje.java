package com.carelly.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * TipoMasaje
 */
@Entity
public class TipoMasaje {

// <editor-fold desc="Atributos">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30,nullable = false)
    private String tipoMasaje;

    @Column(nullable = true)
    private String descripcionMasaje;

    @Column(nullable = false)
    private Integer tiempo;

    @Column(nullable = false)
    private Boolean disponible;
// </editor-fold>


// <editor-fold desc="Constructores">
    public TipoMasaje() {
    }

    public TipoMasaje(String tipoMasaje, String descripcionMasaje, Integer tiempo, boolean disp) {
        this.tipoMasaje = tipoMasaje;
        this.descripcionMasaje = descripcionMasaje;
        this.tiempo = tiempo;
        this.disponible = true;
    }
// </editor-fold>

// <editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMasaje() {
        return tipoMasaje;
    }

    public void setTipoMasaje(String tipoMasaje) {
        this.tipoMasaje = tipoMasaje;
    }

    public String getDescripcionMasaje() {
        return descripcionMasaje;
    }

    public void setDescripcionMasaje(String descripcionMasaje) {
        this.descripcionMasaje = descripcionMasaje;
    }
// </editor-fold>

    @Override
    public String toString() {
        return "TipoMasaje [tipoMasaje=" + tipoMasaje + "]";
    }

}