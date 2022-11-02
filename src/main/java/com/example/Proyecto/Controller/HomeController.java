package com.example.Proyecto.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Proyecto.model.Producto;
import com.example.Proyecto.service.IProductosService;


import com.example.Proyecto.model.Usuario;
import com.example.Proyecto.service.IUsuariosService;
import com.example.Proyecto.model.Perfil;




@Controller
public class HomeController {
	
	
	@Autowired
   	private IUsuariosService serviceUsuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}
	
	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		
		String pwdPlano = usuario.getPassword();
		String pwdEncriptado = passwordEncoder.encode(pwdPlano);
		usuario.setPassword(pwdEncriptado);
		
		usuario.setEstatus(1); // Activado por defecto
		usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor
		
		// Creamos el Perfil que le asignaremos al usuario nuevo
		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		usuario.agregar(perfil);
		
		/**
		 * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
		 */
		serviceUsuarios.guardar(usuario);
				
		attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");
		
		return "redirect:/usuarios/index";
	}
	
	
	
	@GetMapping("/login" )
	public String mostrarLogin() {
	return "formLogin";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		SecurityContextLogoutHandler logoutHandler =
		new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
	return "redirect:/login";
	}

	
	
	@GetMapping("/bcrypt/{texto}")
	@ResponseBody
	public String encriptar (@PathVariable ("texto") String texto ) {
		return texto + "Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
	}
	
	
	
	
	
	
	
	
	
	
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
	
	@GetMapping("/form-categorias")
	public String form(Model model) {
		
		return "/form-categorias";
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