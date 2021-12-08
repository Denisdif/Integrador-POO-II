package com.carelly.demo.mvc.controller;

import java.util.HashMap;

import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.dto.UserDto;
import com.carelly.demo.model.Persona;
import com.carelly.demo.mvc.form.PersonaForm;
import com.carelly.demo.service.IPersonaService;
import com.carelly.demo.service.IProblemaService;
import com.carelly.demo.service.ITipoIdentificacionService;
import com.carelly.demo.service.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Persona")
public class PersonaController {
    @Autowired
    ITipoIdentificacionService tipo;

    @Autowired
    IProblemaService problema;

    @Autowired
    IPersonaService persona;

    @Autowired
    IUserService user;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", persona.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("personaIndex", params);
    }

    @GetMapping("/new")
    public ModelAndView newPersona() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        String nombre = (SecurityContextHolder.getContext().getAuthentication().getName());
        UserDto userDto = user.get(nombre);
        if (userDto.getPersona()== null) {
            //Se genera un objeto form para almacenar datos
            PersonaForm form = new PersonaForm();

            //Se asigna al objeto form los datos para la carga 
            form.setPersona(new PersonaDto());
            form.setTipos(tipo.getAll());
            form.setProblemasAll(problema.getAll());

            //Se añade a params el form generado anteriormente
            params.put("form", form);

            //Se retorna la vista del formulario con el params
            return new ModelAndView("personaCreate", params);
        } else {
            PersonaForm form = new PersonaForm();

            //Se asigna al objeto form los datos para la carga 
            form.setPersona(persona.get(userDto.getPersona().getId())); //Se asigna la persona que pertenece al cliente que se paso como parametro
            form.setTipos(tipo.getAll());
            form.setProblemasAll(problema.getAll());
    
            params.put("form", form);
    
            return new ModelAndView("personaCreate", params);
        
        }

    }

    @GetMapping(value = "/datos/{id}")
    public ModelAndView datos(@ModelAttribute("id") Long id) {
        var params = new HashMap<String, Object>();
        PersonaForm form = new PersonaForm();

        //Se asigna al objeto form los datos para la carga 
        form.setPersona(persona.get(id)); //Se asigna la persona que pertenece al cliente que se paso como parametro

        params.put("form", form);

        return new ModelAndView("personaShow", params);

    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@ModelAttribute("id") Long id) {
        var params = new HashMap<String, Object>();
        PersonaForm form = new PersonaForm();

        //Se asigna al objeto form los datos para la carga 
        form.setPersona(persona.get(id)); //Se asigna la persona que pertenece al cliente que se paso como parametro
        form.setTipos(tipo.getAll());
        form.setProblemasAll(problema.getAll());

        params.put("form", form);

        return new ModelAndView("personaCreate", params);

    }

    @PostMapping("/save")
    public ModelAndView save(PersonaForm form) {
        //Se almacenan los datos de Persona
        PersonaDto personaDto = persona.create(form.getPersona());

        String nombre = (SecurityContextHolder.getContext().getAuthentication().getName());
        UserDto userDto = user.get(nombre);
        userDto.setPersona(modelMapper.map(personaDto, Persona.class));
        user.create(userDto);

        return new ModelAndView("redirect:/Persona/show");
    }

}
