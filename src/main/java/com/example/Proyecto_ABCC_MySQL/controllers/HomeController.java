package com.example.Proyecto_ABCC_MySQL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {

        return "redirect:/alumnos";
    }

    @GetMapping("/health")
    @ResponseBody
    public String health() {

        return "OK";
    }

}