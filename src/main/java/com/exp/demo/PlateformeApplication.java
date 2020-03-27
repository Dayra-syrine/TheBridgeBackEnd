package com.exp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.exp.demo.model.Commentaire;
import com.exp.demo.model.Cour;
import com.exp.demo.model.Section;
import com.exp.demo.model.User;
import com.exp.demo.model.Video;
import com.exp.demo.repo.CommentaireRepository;
import com.exp.demo.repo.CourRepository;
import com.exp.demo.repo.SectionRepository;
import com.exp.demo.repo.UserRepository;
import com.exp.demo.repo.VideoRepository;

@SpringBootApplication
public class PlateformeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PlateformeApplication.class, args);
		UserRepository ur = ctx.getBean(UserRepository.class);
		CourRepository cr = ctx.getBean(CourRepository.class);
		SectionRepository sr = ctx.getBean(SectionRepository.class);
		VideoRepository vr = ctx.getBean(VideoRepository.class);
		CommentaireRepository ccrr=ctx.getBean(CommentaireRepository.class);
	
		User u1 = new User("syrinedayra@gmail.com","17Syrine","Dayra","Syrine","user");
		User u3 = new User("dayrasyrine@gmail.com","17Syrine","Dayra","Syrine","admin");
		User u2 = new User("maryemwaddani@gmail.com","123456789","Waddani","Maryem","user");
		Cour c1 = new Cour("Fullstack Social iOS NodeJS REST","Swift 5.1, SailsMVC, UIKit","500","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/f8dcb0af-34cb-4ac7-bf51-e285cc83f4b5","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c2 = new Cour("Maps UIKit SwiftUI","Swift 5.1, MapKit, Google Places","120","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/f96b3a9c-72b4-4ba4-a7e0-c12913bb5408","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c3 = new Cour("Twitter Slide Out Menu","Swift 5.1, Google Places","150","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/f96b3a9c-72b4-4ba4-a7e0-c12913bb5408","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c4 = new Cour("Fullstack Social iOS NodeJS REST","Swift 5.1, SailsMVC, UIKit","500","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/f8dcb0af-34cb-4ac7-bf51-e285cc83f4b5","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c5 = new Cour("Maps UIKit SwiftUI","Swift 5.1, MapKit, Google Places","120","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/f96b3a9c-72b4-4ba4-a7e0-c12913bb5408","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		Cour c6 = new Cour("Twitter Slide Out Menu","Swift 5.1, Google Places","150","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/f96b3a9c-72b4-4ba4-a7e0-c12913bb5408","https://www.youtube.com/embed/ma6bDuaxETo","descV");
		
		cr.save(c1);
		cr.save(c2);
		cr.save(c3);
		cr.save(c4);
		cr.save(c5);
		cr.save(c6);
		ur.save(u1);
		ur.save(u2);
		ur.save(u3);
		Commentaire comm= new Commentaire("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa","7");
		
		ccrr.save(comm);
		Section s1 = new Section("Section #1 - Register and Login","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/a972d2c1-0ebd-4b11-be2f-216904421c86 ",c1);
		Section s2 = new Section("Section #2 - Preview Oriented Programming with LBTATools","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/a972d2c1-0ebd-4b11-be2f-216904421c86",c2);
		Section s3 = new Section("Section #3 - Stories Header and CAGradientLayer","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/a972d2c1-0ebd-4b11-be2f-216904421c86",c2);
		sr.save(s1);
		sr.save(s2);
		sr.save(s3);
		
		
	
		
		Video v1 = new Video("1. Course Outline","https://www.youtube.com/embed/ma6bDuaxETo","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/28d11ecb-d204-4855-a8d8-a6bfa7aec2af_medium","33:30",s1);
		Video v2 = new Video("2. Course Preparation and Expectations","https://www.youtube.com/embed/ma6bDuaxETo","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/28d11ecb-d204-4855-a8d8-a6bfa7aec2af_medium","15:30",s1);
		Video v3 = new Video("3. SailsMVC Setup and mLab MongoDB Atlas Sessions","https://www.youtube.com/embed/ma6bDuaxETo","https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/28d11ecb-d204-4855-a8d8-a6bfa7aec2af_medium","10:12",s1);
		vr.save(v1);
		vr.save(v2);
		vr.save(v3);
		
		
	}

}
