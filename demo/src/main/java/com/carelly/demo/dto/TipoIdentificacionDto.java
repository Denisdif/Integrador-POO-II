package com.carelly.demo.dto;

public class TipoIdentificacionDto {
// <editor-fold desc="Atributos">
    private Long id;
    private String tipoIdentificacion;
// </editor-fold>

// <editor-fold desc="Constructores">
    public TipoIdentificacionDto() {
    }
    
    public TipoIdentificacionDto(String tipoIdentificacion) {
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
        return "TipoIdentificacionDto [tipoIdentificacion=" + tipoIdentificacion + "]";
    }
}

