package com.prueba.tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.dao.CarritoRepository;
import com.prueba.tecnica.entity.Carrito;
import com.prueba.tecnica.entity.Producto;

@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired
	CarritoRepository repo;
	
	@Override
	public List<Producto> findAllProd() {
		return repo.findAllProd();
	}

	@Override
	public List<Carrito> findAllCarrito() {
		return repo.findAllCarritos();
	}

	@Override
	public String deleteProd(long idC,long idP) {
		return repo.deleteProducto(idC, idP);
	}

	@Override
	public String insertProd(long idC,long idP) {
		repo.insertProducto(idC, idP);
		return null;
	}

	@Override
	public String insertCarrito(String dni, long idP) {
		return repo.insertCarrito(dni, idP);
	}

	@Override
	public String deleteCarrito(long idC) {
		return repo.deleteCarrito(idC);
	}
	
}
