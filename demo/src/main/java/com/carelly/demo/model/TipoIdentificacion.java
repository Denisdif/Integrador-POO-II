package com.carelly.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoIdentificacion {

// <editor-fold desc="Atributos">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30,nullable = false)
    private String tipoIdentificacion;
// </editor-fold>

// <editor-fold desc="Constructores">
    public TipoIdentificacion() {

    }

    public TipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
// </editor-fold>

// <editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
// </editor-fold>

    @Override
    public String toString() {
        return "TipoIdentificacion [tipoIdentificacion=" + tipoIdentificacion + "]";
    }
}
