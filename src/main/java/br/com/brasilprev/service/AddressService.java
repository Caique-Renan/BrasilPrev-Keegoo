package br.com.brasilprev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.domain.AddressEntity;
import br.com.brasilprev.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<AddressEntity> listar() {
		return addressRepository.findAll();
	}

}
