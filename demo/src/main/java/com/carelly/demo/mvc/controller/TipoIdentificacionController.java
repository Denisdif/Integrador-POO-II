package com.carelly.demo.mvc.controller;

import java.util.HashMap;

import com.carelly.demo.dto.TipoIdentificacionDto;
import com.carelly.demo.mvc.form.TipoIdentificacionForm;
import com.carelly.demo.service.ITipoIdentificacionService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/TipoIdentificacion")
public class TipoIdentificacionController {
    
    @Autowired
    ITipoIdentificacionService tipo;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", tipo.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("tiposIdentificacionesIndex", params);
    }

    @GetMapping("/new")
    public ModelAndView newTipo() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        TipoIdentificacionForm form = new TipoIdentificacionForm();

        //Se asigna al objeto form el valor de el nuevo objeto a cargar 
        form.setTipo(new TipoIdentificacionDto());

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("tiposIdentificacionesForm", params);
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@ModelAttribute("id") Long id) {
        var params = new HashMap<String, Object>();
        //Se genera un objeto form para almacenar datos
        TipoIdentificacionForm form = new TipoIdentificacionForm();

        //Se asigna al objeto form el valor de el nuevo objeto a cargar 
        form.setTipo(tipo.get(id));

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("tiposIdentificacionesForm", params);
    }

    @PostMapping("/save")
    public ModelAndView save(TipoIdentificacionForm form) {
        //Se ejecuta el create del servicio pasando como parametro el objeto almacenado en el form
        tipo.create(form.getTipo());

        //Se retorna la vista principal del objeto
        return new ModelAndView("redirect:/TipoIdentificacion/show");
    }

}
