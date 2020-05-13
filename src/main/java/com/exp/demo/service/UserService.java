package com.exp.demo.service;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exp.demo.customexceptions.CustomException;
import com.exp.demo.model.PasswordResetToken;
import com.exp.demo.model.User;
import com.exp.demo.repo.UserRepository;
import com.exp.demo.repo.passwordTokenRepository;
import com.exp.demo.security.JwtTokenProvider;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private passwordTokenRepository ptr;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  public String signin(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      String token = jwtTokenProvider.createToken(username, userRepository.findByMail(username).getRoles());
      return token;
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public String signup(User user) {
    if (userRepository.findByMail(user.getMail())==null) {
      user.setPsw(passwordEncoder.encode(user.getPsw()));
      userRepository.save(user);
      return jwtTokenProvider.createToken(user.getMail(), user.getRoles());
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

	/*
	 * public void delete(String username) {
	 * userRepository.deleteByUsername(username); }
	 */

  public User search(String username) {
    User user = userRepository.findByMail(username);
    if (user == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return user;
  }

  public User whoami(HttpServletRequest req) {
    return userRepository.findByMail(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userRepository.findByMail(username).getRoles());
  }

  public void createPasswordResetTokenForUser(User user, String token) {
	    PasswordResetToken myToken = new PasswordResetToken(token, user);
	    ptr.save(myToken);
	}
  
}
