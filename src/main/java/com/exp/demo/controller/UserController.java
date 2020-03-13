package com.exp.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 
	 @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
	    public void addUser(@RequestBody User user) {
	         ur.save(user);
	    }
	 
	 @GetMapping("/user/{mail}")
		public ResponseEntity<User> getUserByMail(@PathVariable(value = "mail") String userMail){
			User user = ur.findByMail(userMail);
			return ResponseEntity.ok().body(user);
		}
	 
	/* @RequestMapping ( value = "/auth" , method = RequestMethod.POST )
		public String CheckAccount ( Model m , User user ) {
			User user_Check = ur.findByMail(user.getMail()) ; 
			if ( user_Check == null || user.getPsw().compareTo(user_Check.getPsw()) !=0 ) {
				m.addAttribute("erreur", "Email or Password Invalid") ;
				m.addAttribute("x",true) ; 
				return "prob.html" ; 
			} else  {
				return "index.html" ; 
				}
		}
		@RequestMapping(value="/log",method=RequestMethod.GET)
		public String ajoutArticle(Model model) {
			
			User u = new User();
			model.addAttribute("user", u);
			return "index.html";
		}*/

}
