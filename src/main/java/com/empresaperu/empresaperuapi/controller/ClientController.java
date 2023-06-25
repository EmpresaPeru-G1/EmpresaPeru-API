package com.empresaperu.empresaperuapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresaperu.empresaperuapi.model.Client;
import com.empresaperu.empresaperuapi.model.ServiceResponse;
import com.empresaperu.empresaperuapi.service.IClientService;

@RestController
@RequestMapping("api/v1/client")
@CrossOrigin("*")
public class ClientController {
	
	@Autowired
	private IClientService iClientService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Client>> list() {
		var result = iClientService.findAll();
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ServiceResponse> save(@RequestBody Client client) {
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iClientService.save(client);
		if(result == 1) {
			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Cliente ingresado correctamente");
		}
		else {
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("No se pudo ingresar al cliente");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ServiceResponse> update(@RequestBody Client client) {
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iClientService.update(client);
		if(result == 1) {
			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Cliente actualizado correctamente");
		}
		else {
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("No se pudo actualizar al cliente");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<ServiceResponse> deleteById(@PathVariable int id) {
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iClientService.deleteById(id);
		if(result == 1) {
			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Cliente removido correctamente");
		}
		else {
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("No se pudo remover al cliente");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
}
