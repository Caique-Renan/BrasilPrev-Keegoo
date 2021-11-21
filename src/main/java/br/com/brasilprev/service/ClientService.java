package br.com.brasilprev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.domain.ClientEntity;
import br.com.brasilprev.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	
	public List<ClientEntity> listar() {

		return clientRepository.findAll();
	}

}
