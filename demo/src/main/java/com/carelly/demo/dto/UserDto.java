package com.carelly.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.carelly.demo.model.Persona;
import com.carelly.demo.model.Rol;
public class UserDto {

    // <editor-fold desc="Atributos">
        private Long id;
        private String name;
        private String password;
        private Persona persona;
        private List<Rol> roles = new ArrayList<Rol>();
    // </editor-fold>

    // <editor-fold desc="Constructores">
        public Long getId() {
            return id;
        }

        public UserDto(String name, String password, List<Rol> roles) {
            this.name = name;
            this.password = password;
            this.roles = roles;
        }
    // </editor-fold>

    // <editor-fold desc="Getters and Setters">
        public UserDto() {
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
        public Persona getPersona() {
            return persona;
        }
        public void setPersona(Persona persona) {
            this.persona = persona;
        }
        public List<Rol> getRoles() {
            return roles;
        }
        public void setRoles(List<Rol> roles) {
            this.roles = roles;
        }
        public Boolean hasRole(Rol rol) {
            Boolean retorno = false;
            for (Rol aux : this.getRoles()) {
                if (aux == rol) {
                    retorno = true;
                }
            }
            return retorno;
        }
    // </editor-fold>

}
