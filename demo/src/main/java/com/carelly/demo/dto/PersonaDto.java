package com.carelly.demo.dto;

import java.util.ArrayList;
import java.util.List;
import com.carelly.demo.model.Problema;
import com.carelly.demo.model.TipoIdentificacion;

public class PersonaDto {

// <editor-fold desc="Atributos">
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String sexo;
    private String telefono;
    private String email;
    private String direccion;
    private String observaciones;
    private TipoIdentificacion tipoIdentificacion;
    private List<Problema> problemas = new ArrayList<Problema>();
// </editor-fold>

// <editor-fold desc="Constructores">
    public PersonaDto() {
    }
    
    public PersonaDto(String nombre, String apellido, String identificacion, String sexo, String telefono, String email,
    String direccion, String observaciones, TipoIdentificacion tipoIdentificacion, List<Problema> problemas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.sexo = sexo;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.observaciones = observaciones;
        this.tipoIdentificacion = tipoIdentificacion;
        this.problemas = problemas;
        }

// </editor-fold>

    // <editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }
// </editor-fold>
}