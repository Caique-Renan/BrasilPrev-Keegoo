package br.com.brasilprev.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENT")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CLIENT_NAME")
	private String clientName;

	@Column(name = "CPF")
	private String cpf;

	@OneToMany
	private List<AddressEntity> addressList;

	public ClientEntity() {
		super();
	}

	public ClientEntity(Long id, String clientName, String cpf, List<AddressEntity> addressList) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.cpf = cpf;
		this.addressList = addressList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<AddressEntity> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressEntity> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return String.format("ClientEntity [id=%s, clientName=%s, cpf=%s, addressList=%s]", id, clientName, cpf,
				addressList);
	}

}
