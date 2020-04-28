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

import com.exp.demo.model.Section;
import com.exp.demo.model.Video;
import com.exp.demo.repo.SectionRepository;
import com.exp.demo.repo.VideoRepository;
@CrossOrigin(origins="*")  
@RestController
@RequestMapping(path="/videos")

public class VideoController {
	
	@Autowired
	VideoRepository vr;
	@Autowired
	SectionRepository sr;
	
	@GetMapping(path="/video", produces = "application/json")
    public List<Video> getVideos() 
    {return  vr.findAll();}
	
	
	@GetMapping("/video/{id}")
	public Optional<Video> getVideoById(@PathVariable(value = "id") Long videoId) {
		return vr.findById(videoId);
	}
	
	 /* @GetMapping("/video/{id}")
	public List<Video> getVideoById(@PathVariable(value = "id") Long videoId){
		Video video = vr.findById(videoId);
		List<Video> videoSection=new ArrayList<Video>();
		for(int i=0;i<video.size();i++) {
			if(video.get(i).getSection().getId_S()==sectionId) {
				videoSection.add(video.get(i));
			}
		}
		return videoSection;
	}  */
	
	
	@DeleteMapping("/video/{id}")
	  public ResponseEntity<HttpStatus> deleteVideo(@PathVariable("id") long id) {
	    try {
	      vr.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	@PutMapping("/video/{id}")
	  public Video updateVideo(@PathVariable(value = "id") Long videoId,
	                                          @Valid @RequestBody Video videoDetails) {

		Video v = vr.findById(videoId).get();

	      v.setImage(videoDetails.getImage());
	      v.setDesc(videoDetails.getDesc());
	      v.setDure(videoDetails.getDure());
	      v.setUrl(videoDetails.getUrl());


	      Video updatedVideo = vr.save(v);
	      return updatedVideo;
	  }
	@PostMapping("/video/{id_section}")
	public Video createVideo(@PathVariable Long id_section, @Valid @RequestBody Video video) {
	System.out.println(id_section);
		Optional<Section> section = sr.findById(id_section);
		video.setSection(section.get());
		return vr.save(video);

	}

}
