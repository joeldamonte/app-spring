package com.prueba.tecnica.dao;

import java.util.List;

import com.prueba.tecnica.entity.Carrito;
import com.prueba.tecnica.entity.Producto;

public interface CarritoRepository {

	List<Producto> findAllProd();

	String insertProducto(long idC, long idP);
	
	String deleteProducto(long idC, long idP);
	
	List<Carrito> findAllCarritos();
	
	String insertCarrito(String dni,long idP);
	
	String deleteCarrito(long idC);
}
