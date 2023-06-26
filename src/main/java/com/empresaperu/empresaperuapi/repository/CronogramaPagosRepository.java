package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empresaperu.empresaperuapi.model.CronogramaPago;

@Repository
public class CronogramaPagosRepository implements ICronogramaPagosRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CronogramaPago> findAll() {
		String SQL = "SELECT*FROM cronograma_pago";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(CronogramaPago.class));
	}

	@Override
	public int save(CronogramaPago cronogramaPago) {
		String SQL = "INSERT INTO cronograma_pago VALUES (?,?,?,?,?,?,?,?,1)";
		return jdbcTemplate.update(SQL, new Object[] {});
	}

	@Override
	public int update(CronogramaPago cronogramaPago) {
		String SQL = "UPDATE cronograma_pago SET moneda_id = ?, fecha_pago = ?, saldo_capital = ?, amortizacion = ?, interes = ?, seguro_desgravamen = ?, seguro_inmueble = ?, portes = ?, cuota = ? WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {cronogramaPago.getMoneda_id(),cronogramaPago.getFecha_pago(),cronogramaPago.getSaldo_capital(),cronogramaPago.getAmortizacion(),cronogramaPago.getInteres(),cronogramaPago.getSeguro_desgravamen(),cronogramaPago.getSeguro_inmueble(),cronogramaPago.getPortes(),cronogramaPago.getCuota()});
	}

	@Override
	public int deleteById(int id) {
		String SQL = "UPDATE cronograma_pago SET estado = 0 WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}
}
