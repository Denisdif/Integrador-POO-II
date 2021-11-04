package com.carelly.demo.dto;

public class ProblemaDto {
// <editor-fold desc="Atributos">
    private Long id;
    private String problema;
// </editor-fold>

// <editor-fold desc="Constructores">
    public void Problema() {
    }

    public void Problema(String problema) {
        this.problema = problema;
    }
// </editor-fold>

// <editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
// </editor-fold>

}
