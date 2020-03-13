package com.exp.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByMail ( String mail ) ;

}
