package com.prueba.tecnica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	private Long idCliente;
	
	@Column(name="DNI")
	private String dni;
	
	@Column(name="VIP")
	private boolean vip;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public Cliente() {}
	
	public Cliente(Long idCliente, String dni, boolean vip) {
		super();
		this.idCliente = idCliente;
		this.dni = dni;
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", vip=" + vip + "]";
	}
	
}
