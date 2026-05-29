package com.example.Proyecto_ABCC_MySQL.repositories;

import com.example.Proyecto_ABCC_MySQL.models.MateriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<MateriaModel, Integer> {
}