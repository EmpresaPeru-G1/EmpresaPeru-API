package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import com.empresaperu.empresaperuapi.model.TipoTasaInteres;

public interface ITipoTasaInteresRepository {
	public List<TipoTasaInteres> findAll();
	public int save(TipoTasaInteres tipoTasaInteres);
	public int update(TipoTasaInteres cronogramaPago);
	public int deleteById(int id);
}
