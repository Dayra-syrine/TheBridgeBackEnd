package com.exp.demo.model;

import java.io.Serializable;

public class HistoriquePK implements Serializable {
	
	
//	private Long cours;
    private Long user;
    private Long video;
    

	/*
	 * public Long getCours() { return cours; } public void setCours(Long cours) {
	 * this.cours = cours; }
	 */
    
    
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getVideo() {
		return video;
	}
	public void setVideo(Long video) {
		this.video = video;
	}
    

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
    

}
