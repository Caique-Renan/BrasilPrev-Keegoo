package br.com.brasilprev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.domain.ClientEntity;
import br.com.brasilprev.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<ClientEntity>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.listar());
	}

}
