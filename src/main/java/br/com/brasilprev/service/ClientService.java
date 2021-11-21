package br.com.brasilprev.service;

import java.util.List;
import java.util.Optional;

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

	/**
	 * 
	 * @return
	 */

	/**
	 * This method is responsible for the customer listing service.
	 * 
	 * @return Client list.
	 */

	public List<ClientEntity> listClient() {

		List<ClientEntity> clientList = clientRepository.findAll();
		log.info("Numero de Clientes encontrados: {}", clientList.size());
		return clientList;
	}

	/**
	 * This method is responsible for searching customers by id.
	 * 
	 * @return Client find.
	 */

	public ClientEntity findClientById(Long id) {

		ClientEntity clientFound = new ClientEntity();
		Optional<ClientEntity> clientFoundOp = clientRepository.findById(id);

		if (clientFoundOp.isPresent()) {
			clientFound = clientFoundOp.get();
		} else {
			new Exception("Cliente nao encontado");
		}

		return clientFound;
	}

	/**
	 * This method is responsible for the customer rescue service.
	 * 
	 * @return Client save.
	 */

	public ClientEntity saveClient(ClientEntity clientRequest) {
		ClientEntity save = clientRepository.save(clientRequest);
		log.info("Cliente criado com sucesso, com os parametros: {} ", save.toString());
		return save;
	}

	/**
	 * This method is responsible for the "delete" service within clients.
	 * 
	 * @return Client delete.
	 */

	public void deleteClient(Long id) {
		try {
			clientRepository.deleteById(id);

		} catch (Exception e) {
			new Exception("Cliente nao encontado");
		}

	}

	/**
	 * This method is responsible for the customer update service.
	 * 
	 * @return Client update.
	 */

	public void upadteClient(ClientEntity clientRequest) {
		Optional<ClientEntity> clientFound = clientRepository.findById(clientRequest.getId());

		// MapStruct
		if (clientFound.isPresent()) {
			ClientEntity clientEntity = clientFound.get();

			if (null != clientRequest.getCpf()) {
				clientEntity.setCpf(clientRequest.getCpf());

			}

			if (null != clientRequest.getClientName()) {
				clientEntity.setClientName(clientRequest.getClientName());

			}

			if (null != clientRequest.getAddressList()) {
				clientEntity.setAddressList(clientRequest.getAddressList());

			}

			clientRepository.save(clientEntity);
		} else {
			new Exception("Cliente nao encontado");
		}

	}

}
