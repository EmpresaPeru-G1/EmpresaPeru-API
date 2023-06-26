package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.empresaperu.empresaperuapi.model.CronogramaPago;

@Repository
public interface ICronogramaPagosRepository {
	public List<CronogramaPago> findAll();
	public int save(CronogramaPago cronogramaPago);
	public int update(CronogramaPago cronogramaPago);
	public int deleteById(int id);
}
