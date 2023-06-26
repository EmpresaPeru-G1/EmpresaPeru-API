package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empresaperu.empresaperuapi.model.Prestamo;

@Repository
public class PrestamoRepository implements IPrestamoRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Prestamo> findAll() {
		String SQL = "SELECT*FROM PRESTAMO";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Prestamo.class));
	}

	@Override
	public int save(Prestamo prestamo) {
		String SQL = "INSERT INTO PRESTAMO VALUES (?,?,?,?,1)";
		return jdbcTemplate.update(SQL, new Object[] {prestamo.getCliente_id(),prestamo.getOferta_inmobiliaria_id(),prestamo.getMoneda_id(),prestamo.getTipo_tasa_interes()});
	}

	@Override
	public int update(Prestamo prestamo) {
		String SQL = "UPDATE prestamo SET cliente_id = ?, oferta_inmobiliaria_id = ?, moneda_id = ?, tipo_tasa_interes = ? WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {prestamo.getCliente_id(),prestamo.getOferta_inmobiliaria_id(),prestamo.getMoneda_id(),prestamo.getTipo_tasa_interes(),prestamo.getId()});
	}

	@Override
	public int deleteById(int id) {
		String SQL = "UPDATE prestamo SET estado = 0 WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}
}
