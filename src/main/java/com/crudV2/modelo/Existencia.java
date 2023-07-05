package com.crudV2.modelo;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "existenciasV2")
public class Existencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	@Column(name = "id_producto")
	private int idProducto;
	@Column(name = "fecha_entrega")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEntrega;
	@Column(name = "fecha_salida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")

	private Date fechaSalida;
	
	public Existencia() {
		
	}
	
	public Existencia(int id, int cantidad, int idProducto, Date fechaEntrega, Date fechaSalida) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.fechaEntrega = fechaEntrega;
		this.fechaSalida = fechaSalida;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
}
