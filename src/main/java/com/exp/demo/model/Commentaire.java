package com.exp.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Commentaire")
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Com;
	
	
	@Column(name = "desccom")
	private String desccom;
	
	@Column(name = "user")
	private String user;
	
	public Commentaire(long id_Com, String desccom, String user) {
		super();
		this.id_Com = id_Com;
		this.desccom = desccom;
		this.user = user;
	}

	public Commentaire(String desccom, String user) {
		super();
		this.desccom = desccom;
		this.user = user;
	}
	public Commentaire() {
		super();
		
	}

	public long getId_Com() {
		return id_Com;
	}

	public void setId_Com(long id_Com) {
		this.id_Com = id_Com;
	}

	public String getDesccom() {
		return desccom;
	}

	public void setDesccom(String desccom) {
		this.desccom = desccom;
	}

	public String getuser() {
		return user;
	}

	public void setuser(String user) {
		this.user = user;
	}

	

}
