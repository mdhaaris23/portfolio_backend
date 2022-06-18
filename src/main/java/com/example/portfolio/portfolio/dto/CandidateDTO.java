package com.example.portfolio.portfolio.dto;

import java.util.List;

import com.example.portfolio.portfolio.entity.Candidate;

public class CandidateDTO {

	Integer id;
	String name;
	String emailId;
	AddressDTO address;
	String contactNumber;
	String description;
	List<String> hobbies;
	List<String> skillTags;
	String fbLink;
	String linkedInLink;
	String leetCodeLink;

	public CandidateDTO() {

	}

	public CandidateDTO(Integer id, String name, String emailId, AddressDTO address, String contactNumber,
			String description, List<String> hobbies, List<String> skillTags, String fbLink, String linkedInLink,
			String leetCodeLink) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.address = address;
		this.contactNumber = contactNumber;
		this.description = description;
		this.hobbies = hobbies;
		this.skillTags = skillTags;
		this.fbLink = fbLink;
		this.linkedInLink = linkedInLink;
		this.leetCodeLink = leetCodeLink;
	}

	public static Candidate getCandidate(CandidateDTO candidateDTO) {
		return new Candidate(candidateDTO.getId(), candidateDTO.getName(), candidateDTO.getEmailId(),
				AddressDTO.getAddress(candidateDTO.getAddress()), candidateDTO.getContactNumber(),
				candidateDTO.getDescription(), candidateDTO.getHobbies(), candidateDTO.getSkillTags(),
				candidateDTO.getFbLink(), candidateDTO.getLinkedInLink(), candidateDTO.getLeetCodeLink());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getSkillTags() {
		return skillTags;
	}

	public void setSkillTags(List<String> skillTags) {
		this.skillTags = skillTags;
	}

	public String getFbLink() {
		return fbLink;
	}

	public void setFbLink(String fbLink) {
		this.fbLink = fbLink;
	}

	public String getLinkedInLink() {
		return linkedInLink;
	}

	public void setLinkedInLink(String linkedInLink) {
		this.linkedInLink = linkedInLink;
	}

	public String getLeetCodeLink() {
		return leetCodeLink;
	}

	public void setLeetCodeLink(String leetCodeLink) {
		this.leetCodeLink = leetCodeLink;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
