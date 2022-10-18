package com.example.Proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Proyecto.model.Producto;
import com.example.Proyecto.service.IProductosService;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String inicio(Model model) {
		
		
		return "index";
	}
	
	@Autowired
	private IProductosService serviceProductos;
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Producto> lista = serviceProductos.buscarTodos();
		model.addAttribute("productos", lista);
		
		return "tabla";

   }
	
	@GetMapping("/Categoria-Telefonos")
	public String categorias(Model model) {
		
		return "/Categoria-Telefonos";
	}
	
	@GetMapping("/formulario-categorias")
	public String form(Model model) {
		
		return "/formulario-categorias";
	}
	
	@GetMapping("/mensaje-form")
	public String mostrarMensaje(Model model, String produ, String produ_name, String produ_precio, String produ_descripcion){
		
		model.addAttribute("produ_precio", produ_precio);
		model.addAttribute("produ_name", produ_name);
		model.addAttribute("produ", produ);
		model.addAttribute("produ_descripcion", produ_descripcion);
		return "/mensaje-form";
	}
	
	@GetMapping("/ofertas")
	public String ofertas(Model model) {
		
		return "/ofertas";
	}
	
}