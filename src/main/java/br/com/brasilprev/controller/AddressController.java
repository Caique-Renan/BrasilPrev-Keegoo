package br.com.brasilprev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.domain.AddressEntity;
import br.com.brasilprev.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<AddressEntity>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(addressService.listar());
	}
	
	

}
