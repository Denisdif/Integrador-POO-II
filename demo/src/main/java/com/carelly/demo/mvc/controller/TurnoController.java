package com.carelly.demo.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.carelly.demo.dto.TurnoDto;
import com.carelly.demo.mvc.form.TurnoForm;
import com.carelly.demo.service.IClienteService;
import com.carelly.demo.service.ITipoMasajeService;
import com.carelly.demo.service.ITurnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Turno")
public class TurnoController {
    
    @Autowired
    ITurnoService turno;

    @Autowired
    ITipoMasajeService tipoMasaje;

    @Autowired
    IClienteService cliente;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", turno.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("turnoIndex", params);
    }
    
    @GetMapping("/new")
    public ModelAndView newTurno() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        TurnoForm form = new TurnoForm();

        //Se asigna al objeto form los datos para la carga 
        form.setTurno(new TurnoDto());
        form.setTipoMasaje(tipoMasaje.getAll());
        form.setCliente(cliente.getAll());

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("turnoCreate", params);
    }

    @PostMapping("/save")
    public ModelAndView save(TurnoForm form) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        Date parsed = format.parse(form.getFecha());
        form.getTurno().setFecha(parsed);
        turno.create(form.getTurno());
        return new ModelAndView("redirect:/Turno/show");
    }
}
