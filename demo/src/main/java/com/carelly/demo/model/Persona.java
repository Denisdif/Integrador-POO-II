package com.carelly.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity

public class Persona {

// <editor-fold desc="Atributos">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 20, nullable = false)
    private String identificacion;

    @Column(length = 20, nullable = true)
    private String sexo;

    @Column(length = 12, nullable = false)
    private String telefono;

    @Column(length = 50, nullable = true)
    private String email;

    @Column(length = 255, nullable = true)
    private String direccion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipoIdent")
    private TipoIdentificacion tipoIdentificacion;

    @ManyToMany()
    @JoinTable( name               = "persona_problema",
                joinColumns        = { @JoinColumn(name = "persona_id" ) }, 
                inverseJoinColumns = { @JoinColumn(name = "problema_id") }
                )
    private List<Problema> problemas = new ArrayList<Problema>();
// </editor-fold>

// <editor-fold desc="Constructores">
    public Persona() {
    }

    public Persona(String nombre, String apellido, String identificacion, String sexo, String telefono, String email,
            String direccion, TipoIdentificacion tipoIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.sexo = sexo;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.tipoIdentificacion = tipoIdentificacion;
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

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "Persona [apellido=" + apellido + ", nombre=" + nombre + "]";
    }
}
