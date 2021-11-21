package br.com.brasilprev.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.domain.AddressEntity;
import br.com.brasilprev.repository.AddressRepository;

@Service
public class AddressService {
	
	public static final Logger log = LoggerFactory.getLogger(AddressService.class);

	@Autowired
	private AddressRepository addressRepository;

	/**
	 * This method retrieves all users from the bank.
	 * @return Client List.
	 */
	public List<AddressEntity> listar() {
		
		List<AddressEntity> addressList = addressRepository.findAll();
		log.info("O numero de Enderecos e: {}", addressList.size());
		return addressList;
	}

	public AddressEntity salvar(AddressEntity addressRequest) {
		AddressEntity save = addressRepository.save(addressRequest);
		log.info("Endereco criado com sucesso, com os parametros: {} ", save.toString());
		return save;
	}

}
