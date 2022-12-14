package com.example.Proyecto.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Proyecto.model.Producto;
import com.example.Proyecto.repository.ProductosRepository;
import com.example.Proyecto.service.IProductosService;

@Service
@Primary
public class ProductosServiceJpa implements IProductosService {
	
	@Autowired
	private ProductosRepository productosRepo;

	@Override
	public List<Producto> buscarTodas() {
		
		return productosRepo.findAll();
	}

	@Override
	public Producto buscarPorId(Integer idProducto) {
		// TODO Auto-generated method stub
		Optional<Producto> optional = productosRepo.findById(idProducto);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		productosRepo.save(producto);
	}

	

	@Override
	public void eliminar(Integer idProducto) {
		// TODO Auto-generated method stub
		productosRepo.deleteById(idProducto);
		
	}

	@Override
	public List<Producto> buscarByExample(Example<Producto> example) {
		return productosRepo.findAll(example);
	}

	@Override
	public List<Producto> buscarOferta() {
		return productosRepo.findByOferta(1);
	}

	@Override
	public Page<Producto> buscarTodas(Pageable page) {
		return productosRepo.findAll(page);
	}

}
