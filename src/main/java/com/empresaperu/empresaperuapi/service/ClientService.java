package com.empresaperu.empresaperuapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresaperu.empresaperuapi.model.Client;
import com.empresaperu.empresaperuapi.repository.IClientRepository;


@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientRepository iClientRepository;
	
	@Override
	public List<Client> findAll() {
		List<Client> list;
		try {
			list = iClientRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public int save(Client client) {
		int row;
		try {
			row = iClientRepository.save(client);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int update(Client client) {
		int row;
		try {
			row = iClientRepository.update(client);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int deleteById(int id) {
		int row;
		try {
			row = iClientRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}
	
}
