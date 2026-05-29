package com.example.Proyecto_ABCC_MySQL.controllers;

import com.example.Proyecto_ABCC_MySQL.models.MateriaModel;
import com.example.Proyecto_ABCC_MySQL.services.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materias")
public class MateriaRestController {

    @Autowired
    private MateriaService service;

    @GetMapping
    public List<MateriaModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<MateriaModel> buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public MateriaModel guardar(@RequestBody MateriaModel materia) {
        return service.guardar(materia);
    }

    @PutMapping("/{id}")
    public MateriaModel actualizar(@PathVariable Integer id,
            @RequestBody MateriaModel materia) {
        return service.actualizar(id, materia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
