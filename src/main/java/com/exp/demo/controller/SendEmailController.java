package com.exp.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.User;
import com.exp.demo.repo.UserRepository;
import com.exp.demo.service.EmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/sendmail")
public class SendEmailController {
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private UserRepository ur;

	public static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	
    @PostMapping(value = "/sendmail")
    public User sendmail(@RequestParam String mail) {
    	
      String newPassword=rendomPassword();
        emailService.sendMail(mail, "TheBridge password reset", " Dear user \r\n For your account a password reset was requested,this is your New Password : "+newPassword+"\r\n Regards,\r\n" + 
        		"TheBridge Team.");
        
        User u = ur.findByMail(mail);
		u.setPsw( passwordEncoder.encode(newPassword));
		User updatedPsw = ur.save(u);
        
        return updatedPsw;
    }
    public String rendomPassword() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
     
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
     
       return generatedString;
    }

}
