package com.carelly.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Problema {
// <editor-fold desc="Atributos">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50,nullable = false)
    private String problema;
// </editor-fold>

// <editor-fold desc="Constructores">
    public Problema() {
    }

    public Problema(String problema) {
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

    @Override
    public String toString() {
        return "Problema [problema=" + problema + "]";
    }

}
