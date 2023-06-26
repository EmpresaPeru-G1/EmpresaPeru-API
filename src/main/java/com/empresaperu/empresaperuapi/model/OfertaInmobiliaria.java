package com.empresaperu.empresaperuapi.model;

import lombok.Data;

@Data
public class OfertaInmobiliaria {
	int id;
	int cliente_id;
	float moneda_id;
	String direccion;
	String valor_inmueble;
	float van;
	float tir;
	Boolean estado;
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
	public float getMoneda_id() {
		return moneda_id;
	}
	public void setMoneda_id(float moneda_id) {
		this.moneda_id = moneda_id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getValor_inmueble() {
		return valor_inmueble;
	}
	public void setValor_inmueble(String valor_inmueble) {
		this.valor_inmueble = valor_inmueble;
	}
	public float getVan() {
		return van;
	}
	public void setVan(float van) {
		this.van = van;
	}
	public float getTir() {
		return tir;
	}
	public void setTir(float tir) {
		this.tir = tir;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
