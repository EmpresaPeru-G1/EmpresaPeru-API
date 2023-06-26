package com.empresaperu.empresaperuapi.model;

import lombok.Data;

@Data
public class Prestamo {
	int id;
	int cliente_id;
	int oferta_inmobiliaria_id;
	int moneda_id;
	float tipo_tasa_interes;
	Boolean estado;
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public int getOferta_inmobiliaria_id() {
		return oferta_inmobiliaria_id;
	}
	public void setOferta_inmobiliaria_id(int oferta_inmobiliaria_id) {
		this.oferta_inmobiliaria_id = oferta_inmobiliaria_id;
	}
	public int getMoneda_id() {
		return moneda_id;
	}
	public void setMoneda_id(int moneda_id) {
		this.moneda_id = moneda_id;
	}
	public float getTipo_tasa_interes() {
		return tipo_tasa_interes;
	}
	public void setTipo_tasa_interes(float tipo_tasa_interes) {
		this.tipo_tasa_interes = tipo_tasa_interes;
	}
}
