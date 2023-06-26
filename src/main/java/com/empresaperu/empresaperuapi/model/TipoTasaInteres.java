package com.empresaperu.empresaperuapi.model;

import lombok.Data;

@Data
public class TipoTasaInteres {
	int id_tipo_tasa_interes;
	String nombre_tipo_tasa;
	float valor_tipo_tasa;
	Boolean estado;
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public int getId_tipo_tasa_interes() {
		return id_tipo_tasa_interes;
	}
	public void setId_tipo_tasa_interes(int id_tipo_tasa_interes) {
		this.id_tipo_tasa_interes = id_tipo_tasa_interes;
	}
	public String getNombre_tipo_tasa() {
		return nombre_tipo_tasa;
	}
	public void setNombre_tipo_tasa(String nombre_tipo_tasa) {
		this.nombre_tipo_tasa = nombre_tipo_tasa;
	}
	public float getValor_tipo_tasa() {
		return valor_tipo_tasa;
	}
	public void setValor_tipo_tasa(float valor_tipo_tasa) {
		this.valor_tipo_tasa = valor_tipo_tasa;
	}
}
