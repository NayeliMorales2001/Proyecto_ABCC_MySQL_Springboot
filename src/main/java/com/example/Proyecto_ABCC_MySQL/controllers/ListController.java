package com.example.Proyecto_ABCC_MySQL.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.services.AlumnoService;

@Controller
public class ListController {

    private final AlumnoService alumnoService;

    public ListController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // LISTAR
    @GetMapping("/alumnos")
    public String listaAlumnos(Model model) {

        List<AlumnoModel> listaAlumnos = alumnoService.findAlumnos();

        model.addAttribute("alumnos", listaAlumnos);

        return "list";
    }

    // FORMULARIO NUEVO
    @GetMapping("/alumnos/nuevo")
    public String nuevoAlumno(Model model) {

        model.addAttribute("alumno", new AlumnoModel());

        return "form";
    }

    // GUARDAR
    @PostMapping("/alumnos/guardar")
    public String guardarAlumno(@ModelAttribute AlumnoModel alumno) {

        alumnoService.saveAlumno(alumno);

        return "redirect:/alumnos";
    }

    // EDITAR
    @GetMapping("/alumnos/editar/{id}")
    public String editarAlumno(@PathVariable Integer id, Model model) {

        AlumnoModel alumno = alumnoService.getAlumnoById(id);

        model.addAttribute("alumno", alumno);

        return "form";
    }

    // ELIMINAR
    @GetMapping("/alumnos/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {

        alumnoService.deleteAlumno(id);

        return "redirect:/alumnos";
    }

    // DETALLE
    @GetMapping("/alumnos/detalle/{id}")
    public String detalleAlumno(@PathVariable Integer id, Model model) {

        AlumnoModel alumno = alumnoService.getAlumnoById(id);

        model.addAttribute("alumno", alumno);

        return "detalle";
    }

}