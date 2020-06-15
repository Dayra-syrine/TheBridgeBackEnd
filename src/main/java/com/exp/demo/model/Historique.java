package com.exp.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Historique")
@IdClass(HistoriquePK.class)
public class Historique implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "id_U")
	private User user;



	@Id
	@ManyToOne
	@JoinColumn(name = "id_V")
	private Video video;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Cour getCours() {
//		return cours;
//	}
//
//	public void setCours(Cour cours) {
//		this.cours = cours;
//	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}
