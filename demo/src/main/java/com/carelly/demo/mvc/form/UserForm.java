package com.carelly.demo.mvc.form;

import com.carelly.demo.dto.UserDto;

public class UserForm {
    private UserDto user;
    private String pass;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
