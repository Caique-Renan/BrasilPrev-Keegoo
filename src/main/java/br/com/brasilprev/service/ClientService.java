package br.com.brasilprev.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.domain.ClientEntity;
import br.com.brasilprev.repository.ClientRepository;

@Service
public class ClientService {
	
	public static final Logger log = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired
	private ClientRepository clientRepository;

	// TODO: Add Comentarios e Documentacao
	// TODO: Terminar o CRUD
	// TODO: Se possivel, Add Autenticacao do usuario... como preferir
	/**
	 * 
	 * @return
	 */
	public List<ClientEntity> listar() {

		List<ClientEntity> clientList = clientRepository.findAll();
		log.info("Numero de Clientes encontrados: {}", clientList.size());
		return clientList;
	}
	
	public ClientEntity salvar(ClientEntity clientRequest) {
		ClientEntity save = clientRepository.save(clientRequest);
		log.info("Cliente criado com sucesso, com os parametros: {} ", save.toString());
		return save;
	}
	
	

}
