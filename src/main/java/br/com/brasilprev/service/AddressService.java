package br.com.brasilprev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	
	@Autowired
	private MailAddressService mailAddressService;
	
	
	
	public void teste() {
		
		mailAddressService.mailSend();
		
	}

	
	
}
