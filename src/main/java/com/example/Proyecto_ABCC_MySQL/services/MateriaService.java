package com.example.Proyecto_ABCC_MySQL.services;

import com.example.Proyecto_ABCC_MySQL.models.MateriaModel;
import com.example.Proyecto_ABCC_MySQL.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository repository;

    public List<MateriaModel> listar() {
        return repository.findAll();
    }

    public Optional<MateriaModel> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public MateriaModel guardar(MateriaModel materia) {
        return repository.save(materia);
    }

    public MateriaModel actualizar(Integer id, MateriaModel materia) {
        materia.setId(id);
        return repository.save(materia);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}