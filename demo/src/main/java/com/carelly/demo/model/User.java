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
public class User {

    // <editor-fold desc="Atributos">
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column
        private String name;

        @Column
        private String password;

        @ManyToOne(optional = true)
        @JoinColumn(name = "id_persona")
        private Persona persona;

        @ManyToMany()
        @JoinTable( name               = "user_rol",
                    joinColumns        = { @JoinColumn(name = "user_id" ) }, 
                    inverseJoinColumns = { @JoinColumn(name = "rol_id") }
                    )
        private List<Rol> roles = new ArrayList<Rol>();
    // </editor-fold>

    // <editor-fold desc="Constructores">
        public User() {
        }

        public User(String name, String password, List<Rol> roles) {
            this.name = name;
            this.password = password;
            this.roles = roles;
        }
    // </editor-fold>

    // <editor-fold desc="Getters and Setters">
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public List<Rol> getRoles() {
            return roles;
        }

        public void setRoles(List<Rol> roles) {
            this.roles = roles;
        }

        public Persona getPersona() {
            return persona;
        }

        public void setPersona(Persona persona) {
            this.persona = persona;
        }
    // </editor-fold>

    @Override
    public String toString() {
        return "User [name=" + name + ", rol=" + roles + "]";
    }
}
