package com.example.spring_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    //    modelandview
    @GetMapping("index")
    public String getHomePage(){
        ModelAndView obj = new ModelAndView();
        return ("index");

    }
    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }
}