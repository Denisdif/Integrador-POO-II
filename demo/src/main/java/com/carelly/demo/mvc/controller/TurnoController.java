package com.carelly.demo.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.dto.TurnoDto;
import com.carelly.demo.dto.UserDto;
import com.carelly.demo.model.Rol;
import com.carelly.demo.mvc.form.TurnoForm;
import com.carelly.demo.repository.IRolJpaRepository;
import com.carelly.demo.service.ITipoMasajeService;
import com.carelly.demo.service.ITurnoService;
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
@RequestMapping("/Turno")
public class TurnoController {
    
    @Autowired
    ITurnoService turno;

    @Autowired
    ITipoMasajeService tipoMasaje;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    IUserService user;

    @Autowired
    private IRolJpaRepository rolJpaRepository;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", turno.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("turnoAll", params);
    }

    @GetMapping("/solicitudes")
    public ModelAndView solicitudes(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", turno.getSolicitudes());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("turnoSolicitudes", params);
    }

    @GetMapping("/misTurnos")
    public ModelAndView misTurnos(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Obtener usuario logueado
        String nombre = (SecurityContextHolder.getContext().getAuthentication().getName());

        if (user.get(nombre).getPersona() != null ) {
            //Creamos un objeto de la Entidad y le asignamos los valores del DTO que recibimos como par??metro
            PersonaDto personaDto = modelMapper.map(user.get(nombre).getPersona(), PersonaDto.class);
            //Se genera una lista con todos los objetos
            params.put("list", turno.getMisTurnos(personaDto));
        } else {
            params.put("list", new ArrayList<>());
        }

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
        form.setTipoMasaje(tipoMasaje.getAllHabilitados());

        //Se a??ade a params el form generado anteriormente
        params.put("form", form);
        params.put("list", turno.getAll());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 1);  // numero de horas a a??adir, o restar en caso de horas<0
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        String dateAux=formato.format(calendar.getTime());
        
        params.put("actual", dateAux);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("turnoCreate", params);
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@ModelAttribute("id") Long id) {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        TurnoForm form = new TurnoForm();

        //Se asigna al objeto form los datos para la carga 
        form.setTurno(turno.get(id));
        form.setTipoMasaje(tipoMasaje.getAll());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 1);  // numero de horas a a??adir, o restar en caso de horas<0
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        String dateAux=formato.format(calendar.getTime());

        params.put("actual", dateAux);

        //Se a??ade a params el form generado anteriormente
        params.put("form", form);
        params.put("list", turno.getAll());

        //Se retorna la vista del formulario con el params
        return new ModelAndView("turnoCreate", params);

    }

    @PostMapping("/save")
    public ModelAndView save(TurnoForm form) throws ParseException {

        //Obtener usuario
        String nombre = (SecurityContextHolder.getContext().getAuthentication().getName());
        UserDto userDto = user.get(nombre);
        //Obtener rol
        Rol admin = rolJpaRepository.findByRol("ADMIN");
        //Si no es admin, controla que haya registrado sus datos personales, asigna a esa persona y deshabilita
        if (!(userDto.hasRole(admin))) {
            if (userDto.getPersona() == null) {
                return new ModelAndView("redirect:/Persona/new");
            }
            form.getTurno().setPersona(userDto.getPersona());
            form.getTurno().setHabilitado(null);
        }

        Date dateAux=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(form.getFecha());  
        form.getTurno().setFecha(dateAux);
        turno.create(form.getTurno());

        return new ModelAndView("redirect:/Turno/show");
    }

    @GetMapping("/habilitar/{id}")
    public ModelAndView habilitar(@ModelAttribute("id") Long id) {

        TurnoDto turnoDto = turno.get(id);
        turnoDto.setHabilitado(true);
        turno.create(turnoDto);

        return new ModelAndView("redirect:/Turno/show");
    }

    @GetMapping("/deshabilitar/{id}")
    public ModelAndView deshabilitar(@ModelAttribute("id") Long id) {

        TurnoDto turnoDto = turno.get(id);
        turnoDto.setHabilitado(false);
        turno.createSinControl(turnoDto);

        return new ModelAndView("redirect:/Turno/show");
    }
}
