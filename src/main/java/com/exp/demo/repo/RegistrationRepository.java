package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
