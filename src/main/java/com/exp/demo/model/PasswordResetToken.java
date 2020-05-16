package com.exp.demo.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class PasswordResetToken {
  
    private static final int EXPIRATION = 60 * 24;
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    private String token;
  
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    
    private String validity = "true";
  
    private Date expiryDate;

    public PasswordResetToken() {
    	super();
    }
    public PasswordResetToken(String token,User user) {
    	super();
    	this.token=token;
    	this.user=user;
    	
    }
    
    public PasswordResetToken(String token,User user,Date expiryDate, String validity) {
    	super();
    	this.token=token;
    	this.user=user;
    	this.expiryDate=expiryDate;
    	this.validity=validity;
    }
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}

	
    
    
    
}
