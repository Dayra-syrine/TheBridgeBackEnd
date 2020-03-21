package com.exp.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.User;
import com.exp.demo.repo.UserRepository;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping(path="/users")

public class UserController {
	
	@Autowired
	 UserRepository ur;
	
	 @GetMapping(path="/user", produces = "application/json")
	    public List<User> getUsers() 
	    {
		  
	        return  ur.findAll();
	    }
	 
	 @GetMapping(path="/users/{id}")
		public ResponseEntity<Optional<User>> getUserById(@PathVariable(value = "id") Long userId){
			Optional<User> user = ur.findById(userId);
			return ResponseEntity.ok().body(user);
		}
	 
	 @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
	    public void addUser(@RequestBody User user) {
	         ur.save(user);
	    }
	 
	 @GetMapping("/user/{mail}")
		public ResponseEntity<User> getUserByMail(@PathVariable(value = "mail") String userMail){
			User user = ur.findByMail(userMail);
			return ResponseEntity.ok().body(user);
		}
	 @PutMapping("/user/{id}")
	  public User updateUser(@PathVariable(value = "id") Long userId,@Valid @RequestBody User userDetails) {
		User u = ur.findById(userId).get();
	      u.setMail(userDetails.getMail());
	      u.setPsw(userDetails.getPsw());
	      u.setFname(userDetails.getFname());
	      u.setLname(userDetails.getLname());
	      User updatedUser = ur.save(u);
	      return updatedUser;
	  }
	 @DeleteMapping("/user/{id}")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
	    try {
	      ur.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
		
	

	 
	 
}
