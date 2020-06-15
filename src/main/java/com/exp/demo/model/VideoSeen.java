package com.exp.demo.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class VideoSeen {
	
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

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	

}
