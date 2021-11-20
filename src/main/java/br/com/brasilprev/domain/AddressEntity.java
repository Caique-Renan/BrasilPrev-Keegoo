package br.com.brasilprev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODE_ZIP")
	private String codeZip;

	@Column(name = "ADDRESS_STATE")
	private String addressState;

	@Column(name = "ADDRESS_CITY")
	private String addressCity;

	@Column(name = "ADDRESS_DISTRICT")
	private String addressDistrict;

	@Column(name = "ADDRESS_NAME")
	private String addressName;

	public AddressEntity() {
		super();
	}

	public AddressEntity(Long id, String codeZip, String addressState, String addressCity, String addressDistrict,
			String addressName) {
		super();
		this.id = id;
		this.codeZip = codeZip;
		this.addressState = addressState;
		this.addressCity = addressCity;
		this.addressDistrict = addressDistrict;
		this.addressName = addressName;
	}



}
