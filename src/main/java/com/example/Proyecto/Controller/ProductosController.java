package com.example.Proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Producto> lista = serviceProductos.buscarTodos();
    	model.addAttribute("productos", lista);
		return "productos/listProductos";
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
			// String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			//String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				producto.setImagen(nombreImagen);
			}
		}
		
		serviceProductos.guardar(producto);
		attributes.addFlashAttribute("msg", "Producto Guardado");		
		System.out.println("Producto: " + producto);		
		return "redirect:/producto/index"; 
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idProducto, RedirectAttributes attributes) {
		System.out.println("Borrando producto con id: " + idProducto);
		serviceProductos.eliminar(idProducto);
		attributes.addFlashAttribute("msg","El producto fue eliminado!");
		return "redirect:/producto/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idProducto, Model model) {
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
	public void setGenerico(Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas() );
	}
	
}
