package com.carelly.demo.mvc.controller;

import java.util.HashMap;

import com.carelly.demo.dto.ClienteDto;
import com.carelly.demo.dto.PersonaDto;
import com.carelly.demo.model.Persona;
import com.carelly.demo.mvc.form.ClienteForm;
import com.carelly.demo.service.IClienteService;
import com.carelly.demo.service.IPersonaService;
import com.carelly.demo.service.IProblemaService;
import com.carelly.demo.service.ITipoIdentificacionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    ITipoIdentificacionService tipo;

    @Autowired
    IProblemaService problema;

    @Autowired
    IClienteService cliente;

    @Autowired
    IPersonaService persona;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/show")
    public ModelAndView show(){
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera una lista con todos los objetos
        params.put("list", cliente.getAll());

        //Se retorna la vista con la lista de objetos
        return new ModelAndView("clienteIndex", params);
    }

    @GetMapping("/new")
    public ModelAndView newCliente() {
        //Se genera un objeto para almacenar datos
        var params = new HashMap<String, Object>();

        //Se genera un objeto form para almacenar datos
        ClienteForm form = new ClienteForm();

        //Se asigna al objeto form los datos para la carga 
        form.setCliente(new ClienteDto());
        form.setPersona(new PersonaDto());
        form.setTipos(tipo.getAll());
        form.setProblemasAll(problema.getAll());

        //Se añade a params el form generado anteriormente
        params.put("form", form);

        //Se retorna la vista del formulario con el params
        return new ModelAndView("clienteForm", params);
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@ModelAttribute("id") Long id) {
        var params = new HashMap<String, Object>();
        ClienteForm form = new ClienteForm();

        //Se asigna al objeto form los datos para la carga 
        form.setCliente(cliente.get(id));
        form.setPersona(persona.get(cliente.get(id).getPersona().getId())); //Se asigna la persona que pertenece al cliente que se paso como parametro
        form.setTipos(tipo.getAll());
        form.setProblemasAll(problema.getAll());

        params.put("form", form);

        return new ModelAndView("clienteForm", params);

    }

    @PostMapping("/save")
    public ModelAndView save(ClienteForm form) {
        //Se almacenan los datos de Persona
        PersonaDto personaDto = persona.create(form.getPersona());

        //Se asocia la persona cargada al clienteForm
        form.getCliente().setPersona(modelMapper.map(personaDto, Persona.class));

        //Se almacenan los datos de Cliente
        cliente.create(form.getCliente());

        return new ModelAndView("redirect:/Cliente/show");
    }

}
