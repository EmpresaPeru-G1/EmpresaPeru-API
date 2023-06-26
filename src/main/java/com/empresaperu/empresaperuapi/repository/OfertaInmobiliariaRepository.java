package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empresaperu.empresaperuapi.model.OfertaInmobiliaria;

@Repository
public class OfertaInmobiliariaRepository implements IOfertaInmobiliariaRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<OfertaInmobiliaria> findAll() {
		String SQL = "SELECT*FROM oferta_inmobiliaria";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(OfertaInmobiliaria.class));
	}

	@Override
	public int save(OfertaInmobiliaria ofertaInmobiliaria) {
		String SQL = "INSERT INTO oferta_inmobiliaria VALUES (?,?,?,1)";
		return jdbcTemplate.update(SQL, new Object[] {ofertaInmobiliaria.getCliente_id(),ofertaInmobiliaria.getMoneda_id(),ofertaInmobiliaria.getDireccion(),ofertaInmobiliaria.getValor_inmueble(),ofertaInmobiliaria.getVan(),ofertaInmobiliaria.getTir()});
	}

	@Override
	public int update(OfertaInmobiliaria ofertaInmobiliaria) {
		String SQL = "UPDATE oferta_inmobiliaria SET cliente_id = ?, moneda_id = ?, dni = ?, correo_electronico = ?, contrasenia = ? WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {ofertaInmobiliaria.getCliente_id(),ofertaInmobiliaria.getMoneda_id(),ofertaInmobiliaria.getDireccion(),ofertaInmobiliaria.getValor_inmueble(),ofertaInmobiliaria.getVan(),ofertaInmobiliaria.getTir(),ofertaInmobiliaria.getId()});
	}

	@Override
	public int deleteById(int id) {
		String SQL = "UPDATE oferta_inmobiliaria SET estado = 0 WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}
}
