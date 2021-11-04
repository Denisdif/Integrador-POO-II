package com.carelly.demo.dto;

public class TipoMasajeDto {
// <editor-fold desc="Atributos">
    private Long id;
    private String tipoMasaje;
    private String descripcionMasaje;
// </editor-fold>


// <editor-fold desc="Constructores">
    public TipoMasajeDto() {
    }

    public TipoMasajeDto(String tipoMasaje, String descripcionMasaje) {
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
