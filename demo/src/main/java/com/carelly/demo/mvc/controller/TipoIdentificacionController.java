package com.carelly.demo.mvc.controller;

import java.util.HashMap;

import com.carelly.demo.dto.TipoIdentificacionDto;
import com.carelly.demo.mvc.form.TipoIdentificacionForm;
import com.carelly.demo.service.ITipoIdentificacionService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        var params = new HashMap<String, Object>();
        params.put("list", tipo.getAll());
        return new ModelAndView("tiposIdentificacionesIndex", params);
    }

    @GetMapping("/new")
    public ModelAndView newTipo() {
        var params = new HashMap<String, Object>();
        TipoIdentificacionForm form = new TipoIdentificacionForm();
        form.setTipo(new TipoIdentificacionDto());
        params.put("form", form);
        return new ModelAndView("tiposIdentificacionesForm", params);
    }

    @PostMapping("/save")
    public ModelAndView save(TipoIdentificacionForm form) {
        tipo.create(form.getTipo());
        return new ModelAndView("redirect:/TipoIdentificacion/show");
    }

}
