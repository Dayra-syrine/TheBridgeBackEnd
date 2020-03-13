package com.exp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.exp.demo.model.Cour;
import com.exp.demo.model.Section;
import com.exp.demo.model.User;
import com.exp.demo.model.Video;
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
	
		User u1 = new User("syrinedayra@gmail.com","17Syrine","Dayra","Syrine");
		Cour c1 = new Cour("algo","algorthme et programmation","free","https://breizhfunding.bzh/wp-content/uploads/2016/02/logo-algo.jpg","url","descV");
		Cour c2 = new Cour("java","algorthme et programmation","free","https://breizhfunding.bzh/wp-content/uploads/2016/02/logo-algo.jpg","url","descV");
		cr.save(c1);
		cr.save(c2);
		
		ur.save(u1);
		
		
		Section s1 = new Section("section1","image",c1);
		Section s2 = new Section("section2","image",c2);
		Section s3 = new Section("section3","image",c2);
		sr.save(s1);
		sr.save(s2);
		sr.save(s3);
		
		
	
		
		Video v1 = new Video("video sur une application mobile1","url","image","dure",s1);
		Video v2 = new Video("video sur une application mobile2","url","image","dure",s1);
		Video v3 = new Video("video sur une application mobile3","url","image","dure",s1);
		vr.save(v1);
		vr.save(v2);
		vr.save(v3);
		
		
	}

}
