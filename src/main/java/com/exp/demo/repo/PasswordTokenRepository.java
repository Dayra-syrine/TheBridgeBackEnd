package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.PasswordResetToken;
import com.exp.demo.model.User;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long>{
	
	PasswordResetToken findByToken(String token);
	
	PasswordResetToken findByUser(User user);

}
