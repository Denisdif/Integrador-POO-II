package com.carelly.demo.mvc.controller;

import java.util.HashMap;

import com.carelly.demo.service.ITipoMasajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    ITipoMasajeService tipoMasaje;

    @GetMapping({"/index", "/home", "/"})
    public ModelAndView index() {

        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", tipoMasaje.getAllHabilitados());

        return new ModelAndView("layout", params);
    }
}
