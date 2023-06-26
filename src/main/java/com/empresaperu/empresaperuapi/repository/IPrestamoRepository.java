package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import com.empresaperu.empresaperuapi.model.Prestamo;

public interface IPrestamoRepository {
	public List<Prestamo> findAll();
	public int save(Prestamo prestamo);
	public int update(Prestamo prestamo);
	public int deleteById(int id);
}
