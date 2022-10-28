package com.example.Proyecto.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Proyecto.model.Categoria;
import com.example.Proyecto.repository.CategoriasRepository;
import com.example.Proyecto.service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	public void guardar(Categoria categoria) {
		 categoriasRepo.save(categoria);
	}

	
	public List<Categoria> buscarTodas() {
		return categoriasRepo.findAll();
	}

	
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void eliminar(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
	}

}
