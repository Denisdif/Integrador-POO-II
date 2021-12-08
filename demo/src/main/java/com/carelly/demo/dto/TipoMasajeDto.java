package com.carelly.demo.dto;

public class TipoMasajeDto {
// <editor-fold desc="Atributos">
    private Long id;
    private String tipoMasaje;
    private String descripcionMasaje;
    private Integer tiempo;
    private Boolean disponible;
// </editor-fold>

// <editor-fold desc="Constructores">
    public TipoMasajeDto() {
    }

    public TipoMasajeDto(String tipoMasaje, String descripcionMasaje, Integer tiempo, boolean disp) {
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

    public void setId(Long id) {
        this.id = id;
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
