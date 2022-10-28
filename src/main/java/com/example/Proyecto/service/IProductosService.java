package com.example.Proyecto.service;

import java.util.List;

import com.example.Proyecto.model.Producto;

public interface IProductosService {
	
	List<Producto> buscarTodos();
	Producto buscarPorId(Integer idProducto);
	void guardar(Producto producto);
	List<Producto> buscarOferta();
	void eliminar(Integer idProducto);

}
