package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.PasswordResetToken;



public interface passwordTokenRepository extends JpaRepository<PasswordResetToken, Long>{
	
	PasswordResetToken findByToken(String token);

}
