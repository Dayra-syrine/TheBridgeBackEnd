package com.exp.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "registration")
@IdClass(RegistrationPK.class)
public class Registration {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "id_U")
    private User user;

	@Id
    @ManyToOne
    @JoinColumn(name = "id_C")
    private Cour cours;

	

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

}
