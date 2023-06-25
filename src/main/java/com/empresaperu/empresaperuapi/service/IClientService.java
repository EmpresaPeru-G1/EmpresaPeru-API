package com.empresaperu.empresaperuapi.service;

import java.util.List;

import com.empresaperu.empresaperuapi.model.Client;

public interface IClientService {
	public List<Client> findAll();
	public int save(Client client);
	public int update(Client client);
	public int deleteById(int id);
}
