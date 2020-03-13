package com.exp.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Video;
import com.exp.demo.repo.VideoRepository;
@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping(path="/videos")

public class VideoController {
	
	@Autowired
	VideoRepository vr;
	
	
	@GetMapping(path="/video", produces = "application/json")
    public List<Video> getVideos() 
    {
	  
        return  vr.findAll();
    }
	
	/*  @GetMapping("/video/{id}")
	public List<Video> getVideoByIdSection(@PathVariable(value = "id") Long sectionId){
		List<Video> video = vr.findAll();
		List<Video> videoSection=new ArrayList<Video>();
		for(int i=0;i<video.size();i++) {
			if(video.get(i).getSection().getId_S()==sectionId) {
				videoSection.add(video.get(i));
			}
		}
		return videoSection;
	}  */

}
