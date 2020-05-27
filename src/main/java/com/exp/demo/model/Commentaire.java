package com.exp.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Commentaire")
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Com;
	
	@Column(name = "desccom")
	private String desccom;
		
	@ManyToOne          
	@JsonIgnore
	@JoinColumn(name="id_video")
	private Video video;
	
	@OneToMany(mappedBy = "commentaire",cascade = CascadeType.ALL)   
	private Set<Reply> Reply;
	
	@ManyToOne          
	@JsonIgnore
	@JoinColumn(name="id_user")
	private User User;
	
	public Commentaire(long id_Com, String desccom, User user,Video v) {
		super();
		this.id_Com = id_Com;
		this.desccom = desccom;
		this.User = user;
		this.video=v;
	}

	public Commentaire(String desccom, User user,Video v) {
		super();
		this.desccom = desccom;
		this.User = user;
		this.video=v;

	}
	public Commentaire(String desccom,Video v) {
		super();
		this.desccom = desccom;
		this.video=v;

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

	
	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public User getUser() {
		return User;
	}

	public Set<Reply> getReply() {
		return Reply;
	}

	public void setReply(Set<Reply> reply) {
		Reply = reply;
	}

	public void setUser(User user) {
		User = user;
	}

	

}
