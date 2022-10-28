package com.example.Proyecto.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Proyecto.model.Producto;
import com.example.Proyecto.repository.ProductosRepository;
import com.example.Proyecto.service.IProductosService;

public class ProductosServiceJpa implements IProductosService {

	@Autowired
	private ProductosRepository productosRepo;
	
	public List<Producto> buscarTodos() {
		return productosRepo.findAll();
	}

	public Producto buscarPorId(Integer idProducto) {
		Optional<Producto> optional = productosRepo.findById(idProducto);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void guardar(Producto producto) {
		productosRepo.save(producto);
	}

	public List<Producto> buscarOferta() {
		return productosRepo.findByOferta(1);
	}

	public void eliminar(Integer idProducto) {
		productosRepo.deleteById(idProducto);
	}

}
