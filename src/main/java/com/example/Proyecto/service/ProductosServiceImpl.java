package com.example.Proyecto.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Proyecto.model.Producto;

@Service
public class ProductosServiceImpl implements IProductosService {
	
	private List<Producto> lista = null;
	
	public ProductosServiceImpl() {
		lista = new LinkedList<Producto>();
		
		Producto producto1 = new Producto();
		producto1.setId(1);
		producto1.setImagen("product-1.jpg");
		producto1.setNombre("Samsung Galaxy s5-2015");
		producto1.setDescripcion("El Samsung Galaxy S5 es la quinta generación del Galaxy S, esta vez conservando bastantes aspectos de diseño y características del Galaxy S4, pero agregando funcionalidades como monitor de ritmo cardíaco, sensor dactilar, y resistencia al agua.");
		producto1.setPrecio(999.00);
		producto1.setOferta(1);
		
		Producto producto2 = new Producto();
		producto2.setId(2);
		producto2.setImagen("product-2.jpg");
		producto2.setNombre("Nokia Lumia");
		producto2.setDescripcion("El Nokia Lumia cuenta con 1 GB de memoria RAM y 8 GB para almacenamiento de apps, vídeos, fotos y datos en general. Completando sus características técnicas, en sus tripas encontraremos un procesador Qualcomm MSM8930AB Snapdragon 400 a 1,7 GHz de velocidad.");
		producto2.setPrecio(3399.00);
		producto2.setOferta(0);
		
		Producto producto3 = new Producto();
		producto3.setId(3);
		producto3.setImagen("product-3.jpg");
		producto3.setNombre("LG Leon 2015");
		producto3.setDescripcion("El LG Leon tiene un tamaño de pantalla de 4,5\" , con una resolución de 1280 x 720. La pantalla es de tipo FWVGA. Tiene una densidad de píxeles de 220 ppp. El LG Leon cuenta con Android como sistema operativo, y en su lanzamiento corre la versión 5.0 Lollipop.");
		producto3.setPrecio(3500.00);
		producto3.setOferta(1);
		
		Producto producto4 = new Producto();
		producto4.setId(4);
		producto4.setImagen("product-4.jpg");
		producto4.setNombre("Sony microsoft");
		producto4.setDescripcion("10C dispone de una pantalla LCD con una diagonal que crece hasta las 6,71 pulgadas resolución HD+ y un notch en forma de gota, donde está alaojada la cámara frontal de 5 megapíxeles.");
		producto4.setPrecio(2500.00);
		producto4.setOferta(0);
		
		Producto producto5 = new Producto();
		producto5.setId(5);
		producto5.setImagen("product-5.jpg");
		producto5.setNombre("¡Phone 6");
		producto5.setDescripcion("El Apple iPhone 6 sube la apuesta de Apple con una pantalla de mayor tamaño de 4.7 pulgadas protegida por un cristal ultra resistente, nuevo procesador A8, 16GB, 64GB o 128GB de almacenamiento interno, cámara trasera de 8 megapixels con flash, cámara frontal de 1.2MP, conectividad 4G LTE y iOS 8.");
		producto5.setPrecio(2500.00);
		producto5.setOferta(1);
		
		Producto producto6 = new Producto();
		producto6.setId(6);
		producto6.setImagen("product-6.jpg");
		producto6.setNombre("Samsung galaxy Note 4");
		producto6.setDescripcion("Viene con una pantalla de 5,7 pulgadas Súper AMOLED con resolución de 1440x2560 píxeles. Incorpora un SPen y dos cámaras: una trasera de 16 MP y otra frontal de 3,7 MP para videollamadas. Asimismo, incluye 32 GB de almacenaje ampliable a 128 GB con micro SD card y 3 GB de RAM.");
		producto6.setPrecio(1000.00);
		producto6.setOferta(0);
		
		Producto producto7 = new Producto();
		producto7.setId(7);
		producto7.setImagen("apple1.jpg");
		producto7.setNombre("Apple! Phone 7");
		producto7.setDescripcion("Cámara de 7 MP, Grabación de video HD de 1080p. Retina Flash.  Apertura de ƒ/2.2.  Amplia gama de colores en fotos y Live Photos.  HDR para fotos  Sensor de iluminación posterior Estabilización automática de imagen.");
		producto7.setPrecio(2700.00);
		producto7.setOferta(1);
		
		Producto producto8 = new Producto();
		producto8.setId(8);
		producto8.setImagen("apple2.jpg");
		producto8.setNombre("Apple! Phone 7 Plus");
		producto8.setDescripcion( "Procesador: Apple A10 Fusion de cuatro núcleos a 2.34 GHz. Pantalla: LED-backlit IPS LCD de 5.5 pulgadas y con 1080 x 1920 píxeles de resolución. Cámara trasera: dual de 12 MP, autofoco, zoom, flash; cámara frontal de 7 MP.");
		producto8.setPrecio(8000.00);
		producto8.setOferta(0);
		
		Producto producto9 = new Producto();
		producto9.setId(9);
		producto9.setImagen("nokia1.jpg");
		producto9.setNombre("Nokia G50");
		producto9.setDescripcion("un móvil que entra de lleno en el segmento de la gama media Su pantalla es de 6,82 pulgadas; esto lo sitúa como un terminal grande, lo que no facilitará su manejo si no tenemos manos acordes a este tamaño.");
		producto9.setPrecio(5999.00);
		producto9.setOferta(1);
		
		Producto producto10 = new Producto();
		producto10.setId(10);
		producto10.setImagen("nokia2.jpg");
		producto10.setNombre("Nokia C1 Plus");
		producto10.setDescripcion("cuenta con sistemas GSM, HSPA, LTE. La fecha de presentación es Diciembre 15 2020. Sistema operativo instalado es Android 10 (Go edition) y se utilizó el procesador Quad-core 1.4 GHz. El dispositivo Nokia C1 Plus tiene 16GB 1GB RAM de memoria incorporada.");
		producto10.setPrecio(2999.00);
		producto10.setOferta(0);
		
		Producto producto11 = new Producto();
		producto11.setId(11);
		producto11.setImagen("sony1.jpg");
		producto11.setNombre("Sony Xperia 1 Series");
		producto11.setDescripcion("se creó para darte lo mejor de la pantalla, cámara y tecnología de audio profesionales de Sony en un smartphone. Con una pantalla de 6.5\" OLED 4K HDR de 21:9 CinemaWide™, sistema de cámara de triple objetivo y sonido multidimensional cinemático Dolby Atmos");
		producto11.setPrecio(19999.00);
		producto11.setOferta(1);
		
		Producto producto12 = new Producto();
		producto12.setId(12);
		producto12.setImagen("sony2.jpg");
		producto12.setNombre("Sony Xperia 10 II");
		producto12.setDescripcion("un móvil para competir en el cada vez más exigente segmento de la gama media Tiene un tamaño de pantalla de 6 pulgadas, con lo que podemos decir que es un dispositivo pequeño, como ya quedan pocos en el mercado.");
		producto12.setPrecio(2500.00);
		producto12.setOferta(0);
		
		lista.add(producto1);
		lista.add(producto2);
		lista.add(producto3);
		lista.add(producto4);
		lista.add(producto5);
		lista.add(producto6);
		lista.add(producto7);
		lista.add(producto8);
		lista.add(producto9);
		lista.add(producto10);
		lista.add(producto11);
		lista.add(producto12);
		
	}
	
	@Override
	public List<Producto> buscarTodos() {
		return lista;
	}
	
	@Override
	public Producto buscarPorId(Integer idProducto) {
		
		for (Producto p : lista) {
			if(p.getId()==idProducto) {
				return p;
			}
		}
		
		return null;
		
	}

}
