package com.example.Proyecto.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Proyecto.model.Producto;

public interface IProductosService {
	List<Producto> buscarTodas();
	Producto buscarPorId(Integer idProducto);
	void guardar(Producto producto);
	List<Producto> buscarOferta();
	void eliminar(Integer idProducto);
	List<Producto> buscarByExample(Example<Producto> example);
	Page<Producto> buscarTodas(Pageable page);
	
}
