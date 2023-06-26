package com.empresaperu.empresaperuapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresaperu.empresaperuapi.model.Client;
import com.empresaperu.empresaperuapi.model.DataPDP;
import com.empresaperu.empresaperuapi.model.ResponsePDP;
import com.empresaperu.empresaperuapi.model.ServiceResponse;
import com.empresaperu.empresaperuapi.service.IClientService;
import com.empresaperu.empresaperuapi.service.IEjecutarPDPService;

@RestController
@RequestMapping("api/v1/pdp")
@CrossOrigin("*")
public class PDPController {
	@Autowired
	private IEjecutarPDPService iEjecutarPDPService;
	
	@PostMapping("/")
	public ResponseEntity<List<ResponsePDP>> save(@RequestBody DataPDP data) {
		ResponsePDP response = new ResponsePDP();
		var result = iEjecutarPDPService.ejecutar(data);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}	
}
