package com.empresaperu.empresaperuapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empresaperu.empresaperuapi.model.Client;

@Repository
public class ClientRepository implements IClientRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Client> findAll() {
		String SQL = "SELECT*FROM CLIENTE";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Client.class));
	}

	@Override
	public int save(Client client) {
		String SQL = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,1)";
		return jdbcTemplate.update(SQL, new Object[] {client.getNombre(),client.getApellido(),client.getDni(),client.getCorreo_electronico(),client.getContrasenia()});
	}

	@Override
	public int update(Client client) {
		String SQL = "UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, correo_electronico = ?, contrasenia = ? WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {client.getNombre(),client.getApellido(),client.getDni(),client.getCorreo_electronico(),client.getContrasenia(),client.getId()});
	}

	@Override
	public int deleteById(int id) {
		String SQL = "UPDATE cliente SET estado = 0 WHERE id  = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}
	
}
