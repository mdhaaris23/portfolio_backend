package com.example.portfolio.portfolio.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.portfolio.portfolio.dto.CandidateDTO;

@Entity
@Table(name = "candidate_details")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;

	String emailId;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	Address address;

	String contactNumber;
	String description;

	@ElementCollection
	@CollectionTable(name = "hobbies_list", joinColumns = @JoinColumn(name = "id"))
	@Column(name="hobbies")
	List<String> hobbies;

	@ElementCollection
	@CollectionTable(name = "stilltag_list", joinColumns = @JoinColumn(name = "id"))
	@Column(name="skill_tags")
	List<String> skillTags;

/*	
	-- table sample
	CREATE TABLE sample (
	  id bigint(20) NOT NULL AUTO_INCREMENT,
	  PRIMARY KEY (id)
	);

	-- table my_list
	CREATE TABLE IF NOT EXISTS my_list (
	  id bigint(20) NOT NULL,
	  list varchar(255) DEFAULT NULL,
	  FOREIGN KEY (id) REFERENCES sample (id)
	);*/
	
	String fbLink;
	String linkedInLink;
	String leetCodeLink;

	public Candidate() {
		
	}

	public Candidate(Integer id, String name, String emailId, Address address, String contactNumber,
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
	
	public static CandidateDTO getCandidateDTO(Candidate candidate) {
		return new CandidateDTO(candidate.getId(), candidate.getName(), candidate.getEmailId(),
				Address.getAddressDTO(candidate.getAddress()), candidate.getContactNumber(),
				candidate.getDescription(), candidate.getHobbies(), candidate.getSkillTags(),
				candidate.getFbLink(), candidate.getLinkedInLink(), candidate.getLeetCodeLink());
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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
	
	
}
