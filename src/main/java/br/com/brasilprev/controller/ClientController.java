package br.com.brasilprev.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.brasilprev.domain.ClientEntity;
import br.com.brasilprev.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	
	/**
	 * This is the method responsable of the control List.
	 * @return Client list.
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientEntity>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.listar());
	}

	
	/**
	 * This is the method responsable of the save control.
	 * @return Client save.
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Validated @RequestBody ClientEntity clientRequest) {
		clientRequest = clientService.salvar(clientRequest);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientRequest.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
