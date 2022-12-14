package com.example.Proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Proyecto.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
	
}
