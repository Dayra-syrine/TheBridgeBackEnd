package com.exp.demo.model;


import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RegistrationPK implements Serializable{
    private Long cours;

    private Long user;
     


	public Long getCours() {
		return cours;
	}

	public void setCours(Long cours) {
		this.cours = cours;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
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
