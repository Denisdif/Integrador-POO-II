package com.carelly.demo.mvc.form;

import java.util.List;

import com.carelly.demo.dto.TipoMasajeDto;
import com.carelly.demo.dto.TurnoDto;

public class TurnoForm {
    private TurnoDto turno;
    private List<TipoMasajeDto> tipoMasaje;
    private String fecha;

    public TurnoDto getTurno() {
        return turno;
    }
    public void setTurno(TurnoDto turno) {
        this.turno = turno;
    }
    public List<TipoMasajeDto> getTipoMasaje() {
        return tipoMasaje;
    }
    public void setTipoMasaje(List<TipoMasajeDto> tipoMasaje) {
        this.tipoMasaje = tipoMasaje;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
