package com.exp.demo.model;

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
	
	
	public User() {
		super();
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
	
	

}
