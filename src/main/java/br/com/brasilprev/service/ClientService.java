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

	// TODO: Add Comentarios e Documentacao
	// TODO: Terminar o CRUD
	// TODO: Se possivel, Add Autenticacao do usuario... como preferir
	/**
	 * 
	 * @return
	 */
	public List<ClientEntity> listClient() {

		List<ClientEntity> clientList = clientRepository.findAll();
		log.info("Numero de Clientes encontrados: {}", clientList.size());
		return clientList;
	}

	public ClientEntity saveClient(ClientEntity clientRequest) {
		ClientEntity save = clientRepository.save(clientRequest);
		log.info("Cliente criado com sucesso, com os parametros: {} ", save.toString());
		return save;
	}

	public void deleteClient(Long id) {
		// TODO: Estudar Optional
		try {
			clientRepository.deleteById(id);
			
		} catch (Exception e) {
			new Exception("Cliente nao encontado");
		}
		
	}

	public void upadteClient(ClientEntity clientRequest) {
		// TODO: Estudar Optional
		Optional<ClientEntity> clientFound = clientRepository.findById(clientRequest.getId());
		
		// MapStruct
		if(clientFound.isPresent()) {
			ClientEntity clientEntity = clientFound.get();
			
			if(null != clientRequest.getCpf()) {
				clientEntity.setCpf(clientRequest.getCpf());
				
			}
			
			if(null != clientRequest.getClientName()) {
				clientEntity.setClientName(clientRequest.getClientName());
				
			}

			if(null != clientRequest.getAddressList()) {
				clientEntity.setAddressList(clientRequest.getAddressList());
				
			}
			
			clientRepository.save(clientEntity);
		} else {
			new Exception("Cliente nao encontado");
		}
		
		
	}

}
