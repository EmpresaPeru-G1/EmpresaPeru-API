package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import com.empresaperu.empresaperuapi.model.OfertaInmobiliaria;

public interface IOfertaInmobiliariaRepository {
	public List<OfertaInmobiliaria> findAll();
	public int save(OfertaInmobiliaria ofertaInmobiliaria);
	public int update(OfertaInmobiliaria ofertaInmobiliaria);
	public int deleteById(int id);
}
