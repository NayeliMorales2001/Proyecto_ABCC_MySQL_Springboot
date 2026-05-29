package com.example.Proyecto_ABCC_MySQL.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRestController {

    private final AlumnoService alumnoService;

    public AlumnoRestController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // LISTAR TODOS
    @GetMapping
    public List<AlumnoModel> listar() {

        return alumnoService.findAlumnos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public AlumnoModel buscar(@PathVariable Integer id) {

        return alumnoService.getAlumnoById(id);
    }

    // GUARDAR
    @PostMapping
    public AlumnoModel guardar(@RequestBody AlumnoModel alumno) {

        return alumnoService.saveAlumno(alumno);
    }

    // EDITAR
    @PutMapping("/{id}")
    public AlumnoModel editar(@PathVariable Integer id,
            @RequestBody AlumnoModel alumno) {

        alumno.setId(id);

        return alumnoService.saveAlumno(alumno);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {

        alumnoService.deleteAlumno(id);
    }

}