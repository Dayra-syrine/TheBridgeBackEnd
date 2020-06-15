package com.exp.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coach")
public class Coach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Coach;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "description")
	private String description;
	
	//web or mobile
	@Column(name = "domaine")
	private String domaine;
		
	@Column(name = "cvfile")
	private String cvfile;
	
	@Column(name = "facbookaccount")
	private String facebookaccount;
	
	@Column(name = "linkedinaccount")
	private String linkedinaccount;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "etat")
	private List<CoachEtatEnum> etat;
	
	public Coach() {super();}

	public Coach(long id_Coach, String email, String firstname, String lastname, String picture, String adress,
			String description, String domaine, String cvfile, String facebookaccount, String linkedinaccount) {
		super();
		this.id_Coach = id_Coach;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.adress = adress;
		this.description = description;
		this.domaine = domaine;
		this.cvfile = cvfile;
		this.facebookaccount = facebookaccount;
		this.linkedinaccount = linkedinaccount;
	}
	
	public Coach(String email, String firstname, String lastname, String picture, String adress,
			String description, String domaine, String cvfile, String facebookaccount, String linkedinaccount) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.adress = adress;
		this.description = description;
		this.domaine = domaine;
		this.cvfile = cvfile;
		this.facebookaccount = facebookaccount;
		this.linkedinaccount = linkedinaccount;
	}

	public long getId_Coach() {
		return id_Coach;
	}

	public void setId_Coach(long id_Coach) {
		this.id_Coach = id_Coach;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getCvfile() {
		return cvfile;
	}

	public void setCvfile(String cvfile) {
		this.cvfile = cvfile;
	}

	public String getFacebookaccount() {
		return facebookaccount;
	}

	public void setFacebookaccount(String facebookaccount) {
		this.facebookaccount = facebookaccount;
	}

	public String getLinkedinaccount() {
		return linkedinaccount;
	}

	public void setLinkedinaccount(String linkedinaccount) {
		this.linkedinaccount = linkedinaccount;
	}

	public List<CoachEtatEnum> getEtat() {
		return etat;
	}

	public void setEtat(List<CoachEtatEnum> etat) {
		this.etat = etat;
	}
	
	
}
