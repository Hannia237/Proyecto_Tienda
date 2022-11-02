package com.example.Proyecto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String producto;
	private String marca;
	private String descripcion;
	private String imagen ="";
	private Double precio;
	private Integer oferta;

	
	//@Transient
	@OneToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return producto;
	}


	public void setNombre(String nombre) {
		this.producto = nombre;
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


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", producto=" + producto + ", marca=" + marca + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", precio=" + precio + ", oferta=" + oferta + ", categoria=" + categoria + "]";
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public void reset() {
		this.imagen=null;
	}
	
}
