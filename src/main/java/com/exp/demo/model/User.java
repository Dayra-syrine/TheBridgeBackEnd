package com.exp.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_U;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "psw")
	private String psw;

	@Column(name = "Fname")
	private String Fname;

	@Column(name = "Lname")
	private String Lname;
	
	@Column(name = "etat")
	private Boolean etat;
	
	@Column(name = "image")
	private String image;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "roles")
	private List<RoleEnum> roles;
	
	
	
		public User() {
		super();
	}
	public User(String mail) {

		super();
		
		this.mail=mail;	
	}
	
	public User(Long id,String mail,String psw,String fname,String lname) {

		super();
		this.id_U=id;
		this.mail=mail;
		this.psw=psw;
		this.Fname=fname;
		this.Lname=lname;
		
	}
	
	public User(String mail,String psw,String fname,String lname) {

		super();
		
		this.mail=mail;
		this.psw=psw;
		this.Fname=fname;
		this.Lname=lname;
		
	}
	public User(String mail,String psw,String fname,String lname,Boolean etat,List<RoleEnum> roles) {

		super();
		
		this.mail=mail;
		this.psw=psw;
		this.Fname=fname;
		this.Lname=lname;
		this.etat=etat;
		this.roles = roles;
		
	}
	
	public User(String mail,String fname,String lname,Boolean etat,List<RoleEnum> roles) {

		super();
		
		this.mail=mail;
		this.Fname=fname;
		this.Lname=lname;
		this.etat=etat;
		this.roles = roles;
		
	}
	
	public User(String mail,String psw,String fname,String lname,Boolean etat) {

		super();
		
		this.mail=mail;
		this.psw=psw;
		this.Fname=fname;
		this.Lname=lname;
		this.etat=etat;
		
		
	}
	
	public User(String mail,String psw,String fname,String lname,String image,Boolean etat,List<RoleEnum> roles) {

		super();
		
		this.mail=mail;
		this.psw=psw;
		this.Fname=fname;
		this.Lname=lname;
		this.image=image;
		this.etat=etat;
		this.roles = roles;
		
	}

	public long getId_U() {
		return id_U;
	}

	public void setId_U(long id_U) {
		this.id_U = id_U;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public List<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEnum> role) {
		this.roles = role;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	


	

}
