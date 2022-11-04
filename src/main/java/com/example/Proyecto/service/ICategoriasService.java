package com.example.Proyecto.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Proyecto.model.Categoria;


public interface ICategoriasService {
	
	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);	
	void eliminar(Integer idCategoria);
	Page<Categoria> buscarTodas(Pageable page);
	
}