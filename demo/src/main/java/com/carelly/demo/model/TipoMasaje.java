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

    @Column(length = 50,nullable = false)
    private String tipoMasaje;

    @Column(nullable = false)
    private String descripcionMasaje;
// </editor-fold>


// <editor-fold desc="Constructores">
    public TipoMasaje() {
    }

    public TipoMasaje(String tipoMasaje, String descripcionMasaje) {
        this.tipoMasaje = tipoMasaje;
        this.descripcionMasaje = descripcionMasaje;
    }
// </editor-fold>

// <editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
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