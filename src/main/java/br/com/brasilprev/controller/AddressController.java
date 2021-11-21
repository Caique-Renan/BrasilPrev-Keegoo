package br.com.brasilprev.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.brasilprev.domain.AddressEntity;
import br.com.brasilprev.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	/**
	 * This is the method responsable of the control List.
	 * @return Address list.
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<AddressEntity>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(addressService.listar());
	}
	
	
	/**
	 * This is the method responsable of the save control.
	 * @return Address save.
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Validated @RequestBody AddressEntity addressRequest) {
		addressRequest = addressService.salvar(addressRequest);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addressRequest.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	

}
