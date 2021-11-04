package com.carelly.demo.mvc.controller;

import java.util.HashMap;

import com.carelly.demo.dto.ProblemaDto;
import com.carelly.demo.mvc.form.ProblemaForm;
import com.carelly.demo.service.IProblemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Problema")
public class ProblemaController {

    @Autowired
    IProblemaService problema;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", problema.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("problemasIndex", params);
    }

    @GetMapping("/new")
    public ModelAndView newProblema() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        ProblemaForm form = new ProblemaForm();

        //Se asigna al objeto form el valor de el nuevo objeto a cargar 
        form.setProblema(new ProblemaDto());

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("problemasCreate", params);
    }
    
    @PostMapping("/save")
    public ModelAndView save(ProblemaForm form) {
        //Se ejecuta el create del servicio pasando como parametro el objeto almacenado en el form
        problema.create(form.getProblema());

        //Se retorna la vista principal del objeto
        return new ModelAndView("redirect:/Problema/show");
    }
}
