package com.empresaperu.empresaperuapi.model;

import lombok.Data;

@Data
public class CronogramaPago {
	int id;
	int moneda_id;
	String fecha_pago;
	float saldo_capital;
	float amortizacion;
	int interes;
	float seguro_desgravamen;
	float seguro_inmueble;
	int portes;
	int cuota;
	Boolean estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoneda_id() {
		return moneda_id;
	}
	public void setMoneda_id(int moneda_id) {
		this.moneda_id = moneda_id;
	}
	public String getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public float getSaldo_capital() {
		return saldo_capital;
	}
	public void setSaldo_capital(float saldo_capital) {
		this.saldo_capital = saldo_capital;
	}
	public float getAmortizacion() {
		return amortizacion;
	}
	public void setAmortizacion(float amortizacion) {
		this.amortizacion = amortizacion;
	}
	public int getInteres() {
		return interes;
	}
	public void setInteres(int interes) {
		this.interes = interes;
	}
	public float getSeguro_desgravamen() {
		return seguro_desgravamen;
	}
	public void setSeguro_desgravamen(float seguro_desgravamen) {
		this.seguro_desgravamen = seguro_desgravamen;
	}
	public float getSeguro_inmueble() {
		return seguro_inmueble;
	}
	public void setSeguro_inmueble(float seguro_inmueble) {
		this.seguro_inmueble = seguro_inmueble;
	}
	public int getPortes() {
		return portes;
	}
	public void setPortes(int portes) {
		this.portes = portes;
	}
	public int getCuota() {
		return cuota;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
