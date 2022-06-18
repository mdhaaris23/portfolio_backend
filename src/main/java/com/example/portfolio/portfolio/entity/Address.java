package com.example.portfolio.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.portfolio.portfolio.dto.AddressDTO;

@Entity
@Table(name = "address_details")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	Integer id;

	String houseName;
	String streetName;
	String state;
	String country;
	String pinCode;
	
	public Address() {
		
	}

	public Address(Integer id, String houseName, String streetName, String state, String country, String pinCode) {
		super();
		this.id = id;
		this.houseName = houseName;
		this.streetName = streetName;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	public static AddressDTO getAddressDTO(Address address) {
		return new AddressDTO(address.getId(), address.getHouseName(), address.getStreetName(), address.getState(),
				address.getCountry(), address.getPinCode());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
