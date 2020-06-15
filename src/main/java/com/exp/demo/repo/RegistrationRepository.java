package com.exp.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
/*	List<Registration> findByIdUser(Long idU);
	List<Registration> findByIdCour(Long idC);
	
	Registration findByIdUserAndCour(Long idU, Long idC);*/
	

}
