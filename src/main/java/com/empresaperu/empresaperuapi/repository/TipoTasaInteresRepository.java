package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empresaperu.empresaperuapi.model.TipoTasaInteres;

@Repository
public class TipoTasaInteresRepository implements ITipoTasaInteresRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TipoTasaInteres> findAll() {
		String SQL = "SELECT*FROM CLIENTE";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(TipoTasaInteres.class));
	}

	@Override
	public int save(TipoTasaInteres tipoTasaInteres) {
		String SQL = "INSERT INTO CLIENTE VALUES (?,?,?,1)";
		return jdbcTemplate.update(SQL, new Object[] {tipoTasaInteres.getNombre_tipo_tasa(),tipoTasaInteres.getValor_tipo_tasa()});
	}

	@Override
	public int update(TipoTasaInteres tipoTasaInteres) {
		String SQL = "UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, correo_electronico = ?, contrasenia = ? WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {tipoTasaInteres.getNombre_tipo_tasa(),tipoTasaInteres.getValor_tipo_tasa(),tipoTasaInteres.getId_tipo_tasa_interes()});
	}

	@Override
	public int deleteById(int id) {
		String SQL = "UPDATE cliente SET estado = 0 WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}
}
