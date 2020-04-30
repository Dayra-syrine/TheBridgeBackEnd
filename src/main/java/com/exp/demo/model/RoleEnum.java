package com.exp.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority{
	USER,
    ADMINISTRATOR;

	@Override
	public String getAuthority() {
		return name();
	}
}
