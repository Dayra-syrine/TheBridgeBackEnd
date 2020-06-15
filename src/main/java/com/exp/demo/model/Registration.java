package com.exp.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
@IdClass(RegistrationPK.class)
public class Registration implements Serializable {
	@Id
    @ManyToOne
    @JoinColumn(name = "id_U")
    private User user;

	@Id
    @ManyToOne
    @JoinColumn(name = "id_C")
    private Cour cours;

	
	@Column(name = "isncription_date")
	private String isncription_date;
	
	
	@Column(name = "total_video")
	private int total_video;
	
	
	
	@Column(name = "video_seen")
	private int video_seen;
	
	@Column(name = "percentage")
	private float percentage;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cour getCours() {
		return cours;
	}

	public void setCours(Cour cours) {
		this.cours = cours;
	}

	public String getIsncription_date() {
		return isncription_date;
	}

	public void setIsncription_date(String isncription_date) {
		this.isncription_date = isncription_date;
	}

	public int getTotal_video() {
		return total_video;
	}

	public void setTotal_video(int total_video) {
		this.total_video = total_video;
	}

	public int getVideo_seen() {
		return video_seen;
	}

	public void setVideo_seen(int video_seen) {
		this.video_seen = video_seen;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}



	

	
	
	
    

}
