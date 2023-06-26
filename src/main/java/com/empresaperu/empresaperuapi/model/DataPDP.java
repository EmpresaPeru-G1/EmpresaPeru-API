package com.empresaperu.empresaperuapi.model;

public class DataPDP {
	String tipoDeTasa; //Si es Efectiva ingrese E y si es Nominal ingrese N
	double valorTasaEfectiva; // Valor de la tasa efectiva
	
	
	/**
	 * "Tasa Efectiva Anual (TEA)\n" +
                    "Tasa Efectiva Semestral (TES)\n" +
                    "Tasa Efectiva Cuatrimestral (TEC)\n" +
                    "Tasa Efectiva Trimestral (TET)\n" +
                    "Tasa Efectiva Bimestral (TEB)\n" +
                    "Tasa Efectiva Mensual (TEM)\n" +
                    "Tasa Efectiva Quincenal (TEQ)\n" +
                    "Tasa Efectiva Diaria (TED)\n" 
	 */
	String tipoTasaEfectiva; // tipo de Tasa Efectiva
	
	double valorTasaNominal;
	String tipoTasaNominal; /*"Tasa Nominal Anual (TNA)\n"
                        + "Tasa Nominal Semestral (TNS)\n"
                        + "Tasa Nominal Cuatrimestral (TNC)\n"
                        + "Tasa Nominal Trimestral (TNT)\n"
                        + "Tasa Nominal Bimestral (TNB)\n"
                        + "Tasa Nominal Mensual (TNM)\n"
                        + "Tasa Nominal Quincenal (TNQ)\n"
                        + "Tasa Nominal Diaria (TND)\n"
                        + "Tipo de Tasa Nominal: ");*/
	int frecuenciaCapitalizacionDias; //frecuencia de la capitalización en días
	
	double precioVenta; //Precio de venta PV
	
	double porcentajeCuotaInicial;
	
	int numeroAnios;
	
	String tipoPeriodoGracia; // ("T") && !pgInput.equalsIgnoreCase("P") && !pgInput.equalsIgnoreCase("N"))
	
	int cantidadPeriodoGracia; 
	
	double tasaSeguroDesgravamen;
	
	double tasaSeguroTodoRiesgo;
	
	public String getTipoDeTasa() {
		return tipoDeTasa;
	}

	public void setTipoDeTasa(String tipoDeTasa) {
		this.tipoDeTasa = tipoDeTasa;
	}

	public double getValorTasaEfectiva() {
		return valorTasaEfectiva;
	}

	public void setValorTasaEfectiva(double valorTasaEfectiva) {
		this.valorTasaEfectiva = valorTasaEfectiva;
	}

	public String getTipoTasaEfectiva() {
		return tipoTasaEfectiva;
	}

	public void setTipoTasaEfectiva(String tipoTasaEfectiva) {
		this.tipoTasaEfectiva = tipoTasaEfectiva;
	}

	public double getValorTasaNominal() {
		return valorTasaNominal;
	}

	public void setValorTasaNominal(double valorTasaNominal) {
		this.valorTasaNominal = valorTasaNominal;
	}

	public String getTipoTasaNominal() {
		return tipoTasaNominal;
	}

	public void setTipoTasaNominal(String tipoTasaNominal) {
		this.tipoTasaNominal = tipoTasaNominal;
	}

	public int getFrecuenciaCapitalizacionDias() {
		return frecuenciaCapitalizacionDias;
	}

	public void setFrecuenciaCapitalizacionDias(int frecuenciaCapitalizacionDias) {
		this.frecuenciaCapitalizacionDias = frecuenciaCapitalizacionDias;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getPorcentajeCuotaInicial() {
		return porcentajeCuotaInicial;
	}

	public void setPorcentajeCuotaInicial(double porcentajeCuotaInicial) {
		this.porcentajeCuotaInicial = porcentajeCuotaInicial;
	}

	public int getNumeroAnios() {
		return numeroAnios;
	}

	public void setNumeroAnios(int numeroAnios) {
		this.numeroAnios = numeroAnios;
	}

	public String getTipoPeriodoGracia() {
		return tipoPeriodoGracia;
	}

	public void setTipoPeriodoGracia(String tipoPeriodoGracia) {
		this.tipoPeriodoGracia = tipoPeriodoGracia;
	}

	public int getCantidadPeriodoGracia() {
		return cantidadPeriodoGracia;
	}

	public void setCantidadPeriodoGracia(int cantidadPeriodoGracia) {
		this.cantidadPeriodoGracia = cantidadPeriodoGracia;
	}

	public double getTasaSeguroDesgravamen() {
		return tasaSeguroDesgravamen;
	}

	public void setTasaSeguroDesgravamen(double tasaSeguroDesgravamen) {
		this.tasaSeguroDesgravamen = tasaSeguroDesgravamen;
	}

	public double getTasaSeguroTodoRiesgo() {
		return tasaSeguroTodoRiesgo;
	}

	public void setTasaSeguroTodoRiesgo(double tasaSeguroTodoRiesgo) {
		this.tasaSeguroTodoRiesgo = tasaSeguroTodoRiesgo;
	}

	public double getGastosAdministrativos() {
		return gastosAdministrativos;
	}

	public void setGastosAdministrativos(double gastosAdministrativos) {
		this.gastosAdministrativos = gastosAdministrativos;
	}

	public double getPortes() {
		return portes;
	}

	public void setPortes(double portes) {
		this.portes = portes;
	}

	public double getComisionPeriodica() {
		return comisionPeriodica;
	}

	public void setComisionPeriodica(double comisionPeriodica) {
		this.comisionPeriodica = comisionPeriodica;
	}

	public double getCostosNotariales() {
		return costosNotariales;
	}

	public void setCostosNotariales(double costosNotariales) {
		this.costosNotariales = costosNotariales;
	}

	public double getRegistrales() {
		return registrales;
	}

	public void setRegistrales(double registrales) {
		this.registrales = registrales;
	}

	double gastosAdministrativos;
	
	double portes;
	
	double comisionPeriodica;
	
	double costosNotariales;
	
	double registrales;
	

}
