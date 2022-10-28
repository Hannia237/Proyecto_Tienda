package com.example.Proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Proyecto.model.Categoria;

//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	
}
