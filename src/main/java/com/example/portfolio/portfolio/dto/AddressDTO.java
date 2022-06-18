package com.example.portfolio.portfolio.dto;

import com.example.portfolio.portfolio.entity.Address;

public class AddressDTO {

	Integer id;
	String houseName;
	String streetName;
	String state;
	String country;
	String pinCode;

	public AddressDTO() {

	}

	public AddressDTO(Integer id, String houseName, String streetName, String state, String country, String pinCode) {
		super();
		this.id = id;
		this.houseName = houseName;
		this.streetName = streetName;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	public static Address getAddress(AddressDTO addressDTO) {
		return new Address(addressDTO.getId(), addressDTO.getHouseName(), addressDTO.getStreetName(), addressDTO.getState(),
				addressDTO.getCountry(), addressDTO.getPinCode());
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
