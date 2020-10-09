package com.prueba.tecnica.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PRODUCTO")
	private Long idProd;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PRECIO")
	private int precio;
	
	 @ManyToMany(mappedBy = "productos")
	 private List<Carrito> carrito;
	
	public Producto() {}
	
	public Producto(Long idProd, String nombre, int precio) {
		super();
		this.idProd = idProd;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Producto(Long idProd, String nombre, int precio, List<Carrito> carrito) {
		super();
		this.idProd = idProd;
		this.nombre = nombre;
		this.precio = precio;
		this.carrito = carrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Producto [id=" + idProd + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
