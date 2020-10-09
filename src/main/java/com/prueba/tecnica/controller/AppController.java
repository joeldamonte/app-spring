package com.prueba.tecnica.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.entity.Carrito;
import com.prueba.tecnica.entity.Producto;
import com.prueba.tecnica.service.CarritoService;

@RestController
@RequestMapping("/rest")
public class AppController {

	private Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	CarritoService service;
	
	@GetMapping("/findAllProd")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Producto> getProductoAll() {
		logger.info("ENTRO AL POST");
		return service.findAllProd();
	}
	
	@PostMapping("/insertProd/{idCarr}/{idProd}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseStatus(code= HttpStatus.CREATED)
	public String insertProd(@PathVariable(name="idCarr") String idCarr, @PathVariable(name="idProd") String idProd) {
		
		return "";
	}
	
	@GetMapping("/findProdCarr/{idCarr}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Producto> findProdCarr(@PathVariable(name="idCarr") String idCarr) {
		
		return service.findAllProd();
	}
	@PostMapping("/findAllCarritos")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Carrito> getCarritoAll(){
		logger.info("ENTRO AL POST");
		return service.findAllCarrito();
	}
	
	@DeleteMapping("/deleteProd/{idCarr}/{idProd}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String deleteProd(@PathVariable(name="idCarr") String idCarr, @PathVariable(name="idProd") String idProd) {
		long idC = Long.parseLong(idCarr);
		long idP = Long.parseLong(idProd);
		return service.deleteProd(idC, idP);
	}
	
	@PostMapping("/insertCarrito/{dni}/{idProd}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseStatus(code= HttpStatus.CREATED)
	public String insertCarrito(@PathVariable(name="dni") String dni, @PathVariable(name="idProd") String idProd) {
		long idP = Long.parseLong(idProd);
		return service.insertCarrito(dni, idP);
	}
	
	@DeleteMapping("/deleteCarrito/{idCarr}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String deleteProd(@PathVariable(name="idCarr") String idCarr) {
		long idC = Long.parseLong(idCarr);
		return service.deleteCarrito(idC);
	}
	
	@PostMapping("pagarCarrito/{idCarr}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String pagarCarrito(@PathVariable(name="idCarr") String idCarr) {
		
		return "CARRITO PAGADO";
	}
}
