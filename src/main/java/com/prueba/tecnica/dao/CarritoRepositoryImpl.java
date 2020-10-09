package com.prueba.tecnica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.entity.Carrito;
import com.prueba.tecnica.entity.Producto;

@Repository
public class CarritoRepositoryImpl implements CarritoRepository {

	public List<Producto> lstProd = new ArrayList<Producto>();
	public List<Carrito> lstCarr = new ArrayList<Carrito>();
	
	public CarritoRepositoryImpl() {
		lstProd.add(new Producto((long) 1,"a",9));
		lstProd.add(new Producto((long) 1,"b",23));
		lstProd.add(new Producto((long) 1,"c",35));
		
		lstCarr.add(new Carrito((long) 1,"NN"));
		lstCarr.add(new Carrito((long) 2,"jj"));
	}
	 
	@Autowired
	@Qualifier(value = "entityManagerFactorySqlServer")
	private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;
	
	@Override
	public List<Producto> findAllProd() {
		
//		EntityManager entityManager = entityManagerFactoryBean.getObject().createEntityManager();
//		Query q = entityManager.createQuery("select p from Producto p");
//		List<Producto> r = q.getResultList(); 
		return lstProd;

	}

	@Override
	public List<Carrito> findAllCarritos() {
//		EntityManager entityManager = entityManagerFactoryBean.getObject().createEntityManager();
//		Query q = entityManager.createQuery("select u from Carrito u");
//		return q.getResultList();
		return lstCarr;
	}

	@Override
	@Transactional
	public String deleteProducto(long idC, long idP) {

		EntityManager entityManager = entityManagerFactoryBean.getObject().createEntityManager();
		System.out.println(idC + "  " + idP);
		entityManager.getTransaction().begin();
//		Query q =entityManager.createQuery("select p from Producto p where idProd = :idP");
//		q.setParameter("idP", idP);
//		List<Producto> pr = (List<Producto>) q.getResultList();
//		Query qp = entityManager.createQuery("select c from Carrito c where idCar = :idC");
//		qp.setParameter("idC", idC);
//		List<Carrito> carr = (List<Carrito>) qp.getResultList();
//		System.out.println(pr);
//		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return "BORRADO";
		
	}

	@Override
	public String insertProducto(long idC, long idP) {
		
		return null;
	}

	@Override
	public String insertCarrito(String dni, long idP) {
		Carrito ultimo = new Carrito(); 
		ultimo.setIdCar(lstCarr.get(lstCarr.size() - 1).getIdCar() + 1); 
		ultimo.setNombre(dni);
		lstCarr.add(ultimo);
		return "NUEVO CARRITO CREADO";
	}

	@Override
	public String deleteCarrito(long idC) {
		Carrito a = null;
		System.out.println(idC);
		for(Carrito carr: lstCarr) {
			if (carr.getIdCar() == idC) a = carr; 
		}
		lstCarr.remove(a);
		return "CARRITO BORRADO";
	}

}
