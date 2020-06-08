package com.exp.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum CoachEtatEnum implements GrantedAuthority {
	ACCEPTED,REFUSED,WAITING;
	
	@Override
	public String getAuthority() {
		return name();
	}

}
