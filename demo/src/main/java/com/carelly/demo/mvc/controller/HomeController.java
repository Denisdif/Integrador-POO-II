package com.carelly.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping({"/index", "/home", "/"})
    public ModelAndView index() {
        return new ModelAndView("layout");
    }
}
