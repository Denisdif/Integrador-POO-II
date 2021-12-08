package com.carelly.demo.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.carelly.demo.dto.UserDto;
import com.carelly.demo.model.Rol;
import com.carelly.demo.mvc.form.UserForm;
import com.carelly.demo.repository.IRolJpaRepository;
import com.carelly.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    IUserService user;

    @Autowired
	private IRolJpaRepository rolRepo;

    @Autowired
	private BCryptPasswordEncoder encoder;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", user.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("userIndex", params);
    }

    @GetMapping("/new")
    public ModelAndView nuevo() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        UserForm form = new UserForm();

        //Se asigna al objeto form el valor de el nuevo objeto a cargar 
        form.setUser(new UserDto());

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("userCreate", params);
    }

    @GetMapping("/edit")
    public ModelAndView edit() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        UserForm form = new UserForm();

        //Se asigna al objeto form el valor de el nuevo objeto a cargar
        String nombre = (SecurityContextHolder.getContext().getAuthentication().getName());
        form.setUser(user.get(nombre));

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("userCreate", params);
    }

    @PostMapping("/save")
    public ModelAndView save(UserForm form) {

        //Se asigna el rol de cliente cuando se crea el usuario
        if (form.getUser().getRoles() == null) {
            List<Rol> clienteRoles = new ArrayList<>();
            clienteRoles.add(rolRepo.findByRol("CLIENTE"));
            form.getUser().setRoles(clienteRoles);
        } 
        form.getUser().setPassword(encoder.encode(form.getPass()));
        user.create(form.getUser());

        //Se retorna la vista principal del objeto
        return new ModelAndView("redirect:/index");
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@ModelAttribute("id") Long id) {
        user.delete(id);
        return new ModelAndView("redirect:/User/show");
    }
}
