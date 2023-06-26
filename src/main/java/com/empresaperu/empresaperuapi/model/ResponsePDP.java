package com.empresaperu.empresaperuapi.model;

public class ResponsePDP {
	int nroCuota;
	double tea;
	double tep;
	double saldoInicial;
	double intereses;
	double cuota;
	double amortizacion;
	double seguroDegravamen;
	double seguroTodoRiesgo;
	double gastosAdministrativos;
	public int getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}
	public double getTea() {
		return tea;
	}
	public void setTea(double tea) {
		this.tea = tea;
	}
	public double getTep() {
		return tep;
	}
	public void setTep(double tep) {
		this.tep = tep;
	}
	public double getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public double getIntereses() {
		return intereses;
	}
	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	public double getAmortizacion() {
		return amortizacion;
	}
	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}
	public double getSeguroDegravamen() {
		return seguroDegravamen;
	}
	public void setSeguroDegravamen(double seguroDegravamen) {
		this.seguroDegravamen = seguroDegravamen;
	}
	public double getSeguroTodoRiesgo() {
		return seguroTodoRiesgo;
	}
	public void setSeguroTodoRiesgo(double seguroTodoRiesgo) {
		this.seguroTodoRiesgo = seguroTodoRiesgo;
	}
	public double getGastosAdministrativos() {
		return gastosAdministrativos;
	}
	public void setGastosAdministrativos(double gastosAdministrativos) {
		this.gastosAdministrativos = gastosAdministrativos;
	}
	public double getComisionPeriodica() {
		return comisionPeriodica;
	}
	public void setComisionPeriodica(double comisionPeriodica) {
		this.comisionPeriodica = comisionPeriodica;
	}
	public double getPortes() {
		return portes;
	}
	public void setPortes(double portes) {
		this.portes = portes;
	}
	public double getSaldoFinalPeriodo() {
		return saldoFinalPeriodo;
	}
	public void setSaldoFinalPeriodo(double saldoFinalPeriodo) {
		this.saldoFinalPeriodo = saldoFinalPeriodo;
	}
	double comisionPeriodica;
	double portes;
	double saldoFinalPeriodo;	
}
