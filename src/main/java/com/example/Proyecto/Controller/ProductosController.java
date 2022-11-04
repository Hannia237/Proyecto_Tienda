package com.example.Proyecto.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Proyecto.model.Producto;
import com.example.Proyecto.service.ICategoriasService;
import com.example.Proyecto.service.IProductosService;
import com.example.Proyecto.util.Utileria;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Value("${tiendaapp.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IProductosService serviceProductos;
	
	@Autowired
	private ICategoriasService serviceCategorias;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Producto> lista = serviceProductos.buscarTodas();
    	model.addAttribute("productos", lista);
		return "productos/ListProductos";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Producto> lista = serviceProductos.buscarTodas(page);
		model.addAttribute("productos", lista);
		return "productos/ListProductos";
	}
	
	@GetMapping("/create")
	public String crear(Producto producto, Model model) {
		
		return "productos/formProductos";
	}
	
	@PostMapping("/save")
	public String guardar(Producto producto, BindingResult result, RedirectAttributes attributes, 
			@RequestParam("archivoImagen") MultipartFile multiPart) {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}			
			return "productos/formProductos";
		}
		
		if (!multiPart.isEmpty()) {
			
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) {//La imagen si se sibió
				//Procesamos la variable nombreImagen
				producto.setImagen(nombreImagen);
			}
		}
		
		serviceProductos.guardar(producto);
		attributes.addFlashAttribute("msg", "Registro Guardado");

			
		System.out.println("Producto: " + producto);		
		return "redirect:/productos/index"; 
	}
	/*
	@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, 
			@RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado, 
			@RequestParam("salario") double salario, @RequestParam("detalles") String detalles) {
		System.out.println("Nombre Vacante: " + nombre);
		System.out.println("Descripcion: " + descripcion);
		System.out.println("Estatus: " + estatus);
		System.out.println("Fecha Publicación: " + fecha);
		System.out.println("Destacado: " + destacado);
		System.out.println("Salario Ofrecido: " + salario);
		System.out.println("detalles: " + detalles);
		return "vacantes/listVacantes"; 
	}
	*/
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idProducto, RedirectAttributes attributes) {
		System.out.println("Borrando producto con id: " + idProducto);
		serviceProductos.eliminar(idProducto);
		attributes.addFlashAttribute("msg", "El producto fue eliminada");
		return "redirect:/productos/index";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id")int idProducto, Model model) {
		Producto producto = serviceProductos.buscarPorId(idProducto);
		model.addAttribute("producto", producto);
		
		return "productos/formProductos";
	}
	
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idProducto, Model model) {		
		Producto producto = serviceProductos.buscarPorId(idProducto);	
		System.out.println("Producto: " + producto);
		model.addAttribute("producto", producto);
		
		// Buscar los detalles de la vacante en la BD...		
		return "detalle";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}