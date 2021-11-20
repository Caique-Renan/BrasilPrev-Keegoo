package br.com.brasilprev.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CLIENT_NAME")
	private String clientName;

	@Column(name = "CPF")
	private String cpf;

	@OneToMany
	@JoinColumn(name="id")
	private List<AddressEntity> addressList;

	public ClientEntity() {
		super();
	}

}
