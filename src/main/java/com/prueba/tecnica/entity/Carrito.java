package com.prueba.tecnica.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="CARRITO")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CARRITO")
	private Long idCar;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
	        name = "rel_carrito_producto",
	        joinColumns = @JoinColumn(name = "FK_CARRITO", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_PRODUCTO", nullable = false)
	    )
    private List<Producto> productos;

	public void addTag(Producto prod) {
		productos.add(prod);
        prod.getCarrito().add(this);
    }
	
	
	public void deleteProducto(Producto prod) {
		productos.remove(prod);
		prod.getCarrito().remove(this);
	}
	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Carrito() {}

	public Carrito(Long idCar, String nombre) {
		super();
		this.idCar = idCar;
		this.nombre = nombre;
	}
	
	public Carrito(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Carrito(Long idCar, String nombre, List<Producto> productos) {
		super();
		this.idCar = idCar;
		this.nombre = nombre;
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Carrito [idCar=" + idCar + ", nombre=" + nombre + ", productos=" + productos + "]";
	}	
	
	
}
