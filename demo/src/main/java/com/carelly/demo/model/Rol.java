package com.carelly.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {
    // <editor-fold desc="Atributos">
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(length = 30, nullable = false, unique = true)
        private String rol;
    // </editor-fold>

    // <editor-fold desc="Constructores">
        public Rol() {
        }

        public Rol(String rol) {
            this.rol = rol;
        }
    // </editor-fold>

    // <editor-fold desc="Getters and Setters">
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }
    // </editor-fold>

        @Override
        public String toString() {
            return "Rol [rol=" + rol + "]";
        }
}
