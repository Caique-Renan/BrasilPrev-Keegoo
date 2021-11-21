package br.com.brasilprev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeZip() {
		return codeZip;
	}

	public void setCodeZip(String codeZip) {
		this.codeZip = codeZip;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressDistrict() {
		return addressDistrict;
	}

	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	@Override
	public String toString() {
		return String.format(
				"AddressEntity [id=%s, codeZip=%s, addressState=%s, addressCity=%s, addressDistrict=%s, addressName=%s]",
				id, codeZip, addressState, addressCity, addressDistrict, addressName);
	}

}
