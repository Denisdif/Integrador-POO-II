package com.carelly.demo.mvc.controller;

import java.util.HashMap;

import com.carelly.demo.dto.TipoMasajeDto;
import com.carelly.demo.mvc.form.TipoMasajeForm;
import com.carelly.demo.service.ITipoMasajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/TipoMasaje")
public class TipoMasajeController {

    @Autowired
    ITipoMasajeService tipoMasaje;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", tipoMasaje.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("tiposMasajesIndex", params);
    }

    @GetMapping("/new")
    public ModelAndView newTipo() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        TipoMasajeForm form = new TipoMasajeForm();

        //Se asigna al objeto form el valor de el nuevo objeto a cargar 
        form.setTipoMasaje(new TipoMasajeDto());

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("tiposMasajesForm", params);
    }

    @PostMapping("/save")
    public ModelAndView save(TipoMasajeForm form) {
        //Se ejecuta el create del servicio pasando como parametro el objeto almacenado en el form
        tipoMasaje.create(form.getTipoMasaje());

        //Se retorna la vista principal del objeto
        return new ModelAndView("redirect:/TipoMasaje/show");
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@ModelAttribute("id") Long id) {
        tipoMasaje.delete(id);
        return new ModelAndView("redirect:/TipoMasaje/show");
    }
}
