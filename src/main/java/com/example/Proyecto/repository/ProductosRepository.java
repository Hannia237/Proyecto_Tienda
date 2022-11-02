package com.example.Proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Proyecto.model.Producto;








public interface ProductosRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByOferta(Integer oferta);
	

}
