package com.empresaperu.empresaperuapi.service;

import java.util.List;

import com.empresaperu.empresaperuapi.model.DataPDP;
import com.empresaperu.empresaperuapi.model.ResponsePDP;

public interface IEjecutarPDPService {
	public List<ResponsePDP> ejecutar(DataPDP data);
}
