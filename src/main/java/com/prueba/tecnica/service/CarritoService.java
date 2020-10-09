package com.prueba.tecnica.service;

import java.util.List;

import com.prueba.tecnica.entity.Carrito;
import com.prueba.tecnica.entity.Producto;

public interface CarritoService {

	public List<Producto> findAllProd();
	public String insertProd(long idC,long idP);
	public List<Carrito> findAllCarrito();
	public String deleteProd(long idC,long idP);
	public String insertCarrito(String dni, long idP);
	public String deleteCarrito(long idC);
	
	
}
