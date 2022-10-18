package com.example.Proyecto.model;

public class Producto {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen ="";
	private Double precio;
	private Integer oferta;
	private String categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getOferta() {
		return oferta;
	}
	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", oferta=" + oferta + ", categoria=" + categoria + "]";
	}

}
