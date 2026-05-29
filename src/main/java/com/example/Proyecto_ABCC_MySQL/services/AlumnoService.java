package com.example.Proyecto_ABCC_MySQL.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.repositories.AlumnoRepositorie;

@Service
public class AlumnoService {
    private final AlumnoRepositorie alumnoRepositorie;

    public AlumnoService(AlumnoRepositorie alumnoRepositorie) {
        this.alumnoRepositorie = alumnoRepositorie;
    }

    public List<AlumnoModel> findAlumnos() {
        return alumnoRepositorie.findAll();

    }

    public AlumnoModel saveAlumno(AlumnoModel alumno) {
        return alumnoRepositorie.save(alumno);
    }

    public AlumnoModel getAlumnoById(Integer id) {
        return alumnoRepositorie.findById(id).orElse(null);
    }

    public void deleteAlumno(Integer id) {
        alumnoRepositorie.deleteById(id);
    }

}
