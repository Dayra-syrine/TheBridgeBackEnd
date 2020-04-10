package com.exp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.exp.demo.model.*;
import com.exp.demo.repo.*;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PlateformeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PlateformeApplication.class, args);
		UserRepository ur = ctx.getBean(UserRepository.class);
		CourRepository cr = ctx.getBean(CourRepository.class);
		SectionRepository sr = ctx.getBean(SectionRepository.class);
		VideoRepository vr = ctx.getBean(VideoRepository.class);
	
		User u1 = new User("syrinedayra@gmail.com","17Syrine","Dayra","Syrine","user");
		User u2 = new User("dayrasyrine@gmail.com","17Syrine","Dayra","Syrine","admin");
		User u3 = new User("tets@gmail.com","test","test","test","user");
		
		Cour c1 = new Cour("Fullstack Social iOS NodeJS REST","Swift 5.1, SailsMVC, UIKit","500","c1.png","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c2 = new Cour("Maps UIKit SwiftUI","Swift 5.1, MapKit, Google Places","120","c2.png","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c3 = new Cour("Twitter Slide Out Menu","Swift 5.1, Google Places","150","c3.png","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c4 = new Cour("Fullstack Social iOS NodeJS REST","Swift 5.1, SailsMVC, UIKit","500","c1.png","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c5 = new Cour("Maps UIKit SwiftUI","Swift 5.1, MapKit, Google Places","120","c4.png","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c6 = new Cour("Twitter Slide Out Menu","Swift 5.1, Google Places","150","c2.png","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		
		cr.save(c1);
		cr.save(c2);
		cr.save(c3);
		cr.save(c4);
		cr.save(c5);
		cr.save(c6);
		ur.save(u1);
		ur.save(u2);
		ur.save(u3);
		
		Section s1 = new Section("Section #1 - Register and Login","s.jpeg",c1);
		Section s2 = new Section("Section #2 - Preview Oriented Programming with LBTATools","s.jpeg",c1);
		Section s3 = new Section("Section #3 - Stories Header and CAGradientLayer","s.jpeg",c1);
		Section s4 = new Section("Section #3 - Stories Header and CAGradientLayer","s.jpeg",c2);
		Section s5 = new Section("Section #3 - Stories Header and CAGradientLayer","s.jpeg",c3);
		Section s6 = new Section("Section #3 - Stories Header and CAGradientLayer","s.jpeg",c2);

		sr.save(s1);
		sr.save(s2);
		sr.save(s3);
		sr.save(s4);
		sr.save(s5);
		sr.save(s6);
		
		
	
		
		Video v1 = new Video("Course Outline","https://www.youtube.com/embed/ma6bDuaxETo","v1.PNG","33:30",1,s1);
		Video v2 = new Video("Course Preparation and Expectations","https://www.youtube.com/embed/ma6bDuaxETo","v2.PNG","15:30",2,s1);
		Video v3 = new Video("SailsMVC Setup and mLab MongoDB Atlas Sessions","https://www.youtube.com/embed/ma6bDuaxETo","v3.PNG","10:12",3,s1);
		Video v4 = new Video("Course Outline","https://www.youtube.com/embed/ma6bDuaxETo","v1.PNG","33:30",1,s2);
		Video v5 = new Video("Course Preparation and Expectations","https://www.youtube.com/embed/ma6bDuaxETo","v2.PNG","15:30",2,s2);
		Video v6 = new Video("SailsMVC Setup and mLab MongoDB Atlas Sessions","https://www.youtube.com/embed/ma6bDuaxETo","v3.PNG","10:12",1,s3);
		
		vr.save(v1);
		vr.save(v2);
		vr.save(v3);
		vr.save(v4);
		vr.save(v5);
		vr.save(v6);
		
		
	}

}
