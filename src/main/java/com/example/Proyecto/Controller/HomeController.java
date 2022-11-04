package com.example.Proyecto.Controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Proyecto.model.Producto;
import com.example.Proyecto.service.IProductosService;


import com.example.Proyecto.model.Usuario;
import com.example.Proyecto.service.IUsuariosService;
import com.example.Proyecto.service.ICategoriasService;
import com.example.Proyecto.model.Perfil;

@Controller
public class HomeController {
	
	@Autowired
   	private IProductosService serviceProductos;
	
	@Autowired 
	private ICategoriasService serviceCategorias;
	
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Producto> lista = serviceProductos.buscarTodas();
		model.addAttribute("productos", lista);
		
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalles(Model model) {
		Producto producto = new Producto();
		/*vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a internet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);*/
		
		model.addAttribute("producto", producto);
		
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		/*lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");*/
		
		model.addAttribute("producto", lista);
		
		return "listado";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		return "index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Authentication auth, HttpSession session) {
		String username = auth.getName();
		System.out.println(username + " ha entrado al mundo");
		
		for(GrantedAuthority rol: auth.getAuthorities()) {
			System.out.println("ROL: " + rol.getAuthority());
			
			if (session.getAttribute("usuario") == null) {
			
			Usuario usuario = serviceUsuarios.buscarPorUsername(username);
			usuario.setPassword(null);
			System.out.println("Usuario: " + usuario);
			session.setAttribute("usuario", usuario);
			}
			
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "usuarios/formRegistro";
	}
	
	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		 
		 String pwdPlano = usuario.getPassword();
		 String pwdEncriptado = passwordEncoder.encode(pwdPlano);
		 usuario.setPassword(pwdEncriptado);
		 usuario.setEstatus(1);
		 usuario.setFechaRegistro(new Date());
		 
		 Perfil perfil = new Perfil();
		 perfil.setId(3);
		 usuario.agregar(perfil);
			
		 serviceUsuarios.guardar(usuario);
		 attributes.addFlashAttribute("msg", "Usuario guardado!");
		 
		 return "redirect:/usuarios/index";
	}
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Producto producto, Model model) {
		System.out.println("Buscando por : " + producto);
		
		ExampleMatcher matcher = ExampleMatcher.
				// where descripcion like '%?%'
				matching().withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
		
		Example<Producto> example = Example.of(producto, matcher);
		List<Producto> lista = serviceProductos.buscarByExample(example);
		model.addAttribute("productos", lista);
		return "index";
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
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + "Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
	}
	
	/**
	 * InitBinder para Strings si los detecta vacios en el Data Binding los settea a NULL
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		Producto productoSearch = new Producto();
		productoSearch.reset();
		model.addAttribute("productos", serviceProductos.buscarOferta());
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
		model.addAttribute("search", productoSearch);
	}
	
}