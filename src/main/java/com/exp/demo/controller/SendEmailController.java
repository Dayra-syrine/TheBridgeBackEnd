package com.exp.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.PasswordResetToken;
import com.exp.demo.model.User;
import com.exp.demo.repo.PasswordTokenRepository;
import com.exp.demo.repo.UserRepository;
import com.exp.demo.security.JwtTokenProvider;
import com.exp.demo.service.EmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/sendmail")
public class SendEmailController {
	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRepository ur;

	@Autowired
	private PasswordTokenRepository ptr;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Value("${SERVER_HOST}")
	private String SERVER_HOST;

	public static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

	@PostMapping(value = "/sendmail")
	public String sendmail(@RequestParam String mail) {

		String token = jwtTokenProvider.createPSWToken(mail, ur.findByMail(mail).getRoles());
		String subject = "TheBridge password reset";
		String URL = SERVER_HOST+"/restpassword/";
		String msg = "Dear user \r\n \r\n For your account a password reset was requested, please click on the URL below to reset it:\r\n \r\n";
		String signature = "\r\n \r\n Regards,\r\n" + "TheBridge Team.";
		emailService.sendMail(mail, subject, msg + URL + token + signature);

		User u = ur.findByMail(mail);
		PasswordResetToken PRToken = new PasswordResetToken(token, u);
		ptr.save(PRToken);

		return "{\"Token\":\"" + token + "\"}";
	}

	@PostMapping(value = "/getValidity")
	public String getValidity(@RequestParam String token) {


		PasswordResetToken PRToken = ptr.findByToken(token);

		String validation = PRToken.getValidity();

		return validation;
	}
	
	@PostMapping(value = "/getTimeOut")
	public Boolean getTimeOut(@RequestParam String token) {

		
		Boolean val = jwtTokenProvider.validatePSWToken(token);

		return val;
	}

	@PostMapping(value = "/getMail")
	public String getMail(@RequestParam String token) {

		String username = jwtTokenProvider.getUsername(token);

		return "{\"username\":\"" + username + "\"}";
	}

	@PostMapping(value = "/sendmail1")
	public User sendmail1(@RequestParam String mail) {

		String newPassword = rendomPassword();
		emailService.sendMail(mail, "TheBridge password reset",
				" Dear user \r\n For your account a password reset was requested,this is your New Password : "
						+ newPassword + "\r\n Regards,\r\n" + "TheBridge Team.");

		User u = ur.findByMail(mail);
		u.setPsw(passwordEncoder.encode(newPassword));
		User updatedPsw = ur.save(u);

		return updatedPsw;
	}

	public String rendomPassword() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

}
