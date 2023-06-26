package com.empresaperu.empresaperuapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresaperu.empresaperuapi.model.DataPDP;
import com.empresaperu.empresaperuapi.model.EjecutarPDP;
import com.empresaperu.empresaperuapi.model.PlanDePagos;
import com.empresaperu.empresaperuapi.model.ResponsePDP;

import com.empresaperu.empresaperuapi.model.ResponsePDP;

@Service
public class EjecutarPDPService implements IEjecutarPDPService {

	@Override
	public List<ResponsePDP> ejecutar(DataPDP data) {
		PlanDePagos plan = new PlanDePagos();
        EjecutarPDP ejecutar = new EjecutarPDP(plan, data);
        ejecutar.correr();
        ejecutar.imprimirInformacion();
        return ejecutar.list;
	}

}
