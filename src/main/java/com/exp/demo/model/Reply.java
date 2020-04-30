package com.exp.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Reply")
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Reply;
	
	@Column(name = "desccom")
	private String desccom;
	
	@Column(name = "user")
	private String user;
	
	@ManyToOne          
	@JsonIgnore
	@JoinColumn(name="id_Commentaire")
	private Commentaire commentaire;

		
	public Reply() {
		super();
	}

	public Reply( String desccom, String user, Commentaire commentaire) {
		super();
		this.desccom = desccom;
		this.user = user;
		this.commentaire = commentaire;
	}
	

	public Reply(long id_Reply, String desccom, String user) {
		super();
		this.id_Reply = id_Reply;
		this.desccom = desccom;
		this.user = user;
	}
	

	public Reply(long id_Reply, String desccom) {
		super();
		this.id_Reply = id_Reply;
		this.desccom = desccom;
	}

	public long getId_Reply() {
		return id_Reply;
	}

	public void setId_Reply(long id_Reply) {
		this.id_Reply = id_Reply;
	}

	public String getDesccom() {
		return desccom;
	}

	public void setDesccom(String desccom) {
		this.desccom = desccom;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	
	
	

}
