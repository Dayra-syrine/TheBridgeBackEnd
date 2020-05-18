package com.exp.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.exp.demo.model.PasswordResetToken;
import com.exp.demo.model.RoleEnum;
import com.exp.demo.model.User;
import com.exp.demo.repo.PasswordTokenRepository;
import com.exp.demo.repo.UserRepository;
import com.exp.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/users")

public class UserController {

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordTokenRepository ptr;
	
	List<RoleEnum> roles = new ArrayList<RoleEnum>();

	public static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	
	@PostMapping(path = "/signin", produces = "application/json")

	public String login(//
			@RequestParam String username, //
			@RequestParam String password) {
		return "{\"accessToken\":\"" + userService.signin(username, password) + "\"}";
	}
	
//	@PostMapping("/user/resetPassword")
//	public GenericResponse resetPassword(HttpServletRequest request, 
//	  @RequestParam("email") String userEmail) {
//	    User user = ur.findByMail(userEmail);
//	    if (user == null) {
//	       // throw new UserNotFoundException();
//	    }
//	    String token = UUID.randomUUID().toString();
//	    userService.createPasswordResetTokenForUser(user, token);
//	    mailSender.send(constructResetTokenEmail(getAppUrl(request), 
//	      request.getLocale(), token, user));
//	    return new GenericResponse(
//	      messages.getMessage("message.resetPasswordEmail", null, 
//	      request.getLocale()));
//	}

	@PostMapping(path = "/getMail", produces = "application/json")
	public ResponseEntity<User> getUserByMail2(@RequestParam String mail) {
		User user = ur.findByMail(mail);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(value = "/signup", produces = "application/json")
	public void addUsers(@RequestParam String fname, @RequestParam String lname, @RequestParam String mail,
			@RequestParam String password , @RequestParam String image ) {
		roles.add(RoleEnum.USER);

		User u = new User();
		u.setMail(mail);
		u.setPsw(password);
		u.setFname(fname);
		u.setLname(lname);
		u.setImage(image);
		u.setEtat(true);
		u.setRoles(roles);
		userService.signup(u);
	}

	@GetMapping(path = "/user", produces = "application/json")
	public List<User> getUsers() {

		return ur.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable(value = "id") Long userId) {
		Optional<User> user = ur.findById(userId);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
	public void addUser(@RequestBody User user) {
		ur.save(user);
	}

	/*
	 * @GetMapping("/user/{mail}") public ResponseEntity<User>
	 * getUserByMail(@PathVariable(value = "mail") String userMail){ User user =
	 * userService.search(userMail); return ResponseEntity.ok().body(user); }
	 */
	@GetMapping("/user/{mail}")
	public ResponseEntity<User> getUserByMail(@PathVariable(value = "mail") String userMail) {
		User user = ur.findByMail(userMail);
		return ResponseEntity.ok().body(user);
	}

	/*
	 * @GetMapping("/user/{mail}") public ResponseEntity<User>
	 * getUserByMail(@PathVariable(value = "mail") String userMail){ User user =
	 * ur.findByMail(userMail); return ResponseEntity.ok().body(user); }
	 */
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
		User u = ur.findById(userId).get();
		u.setMail(userDetails.getMail());
		u.setPsw(userDetails.getPsw());
		u.setFname(userDetails.getFname());
		u.setLname(userDetails.getLname());
		User updatedUser = ur.save(u);
		return updatedUser;
	}
	@PutMapping("/updatePassID")
	public User updatePswId(@RequestParam Long id_user, @RequestParam String nPass) {
		User u = ur.findById(id_user).get();
		u.setPsw( passwordEncoder.encode(nPass));
		User updatedPsw = ur.save(u);
		return updatedPsw;
	}
	@PutMapping("/updatePass")
	public User updatePsw(@RequestParam String mail, @RequestParam String nPass) {
		User u = ur.findByMail(mail);
		u.setPsw( passwordEncoder.encode(nPass));
		User updatedPsw = ur.save(u);
		
		PasswordResetToken PRToken = ptr.findByUser(u);
		PRToken.setValidity("false");
		ptr.save(PRToken);
		
		return updatedPsw;
		
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
