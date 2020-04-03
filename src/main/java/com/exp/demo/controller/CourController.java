package com.exp.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import org.springframework.web.multipart.MultipartFile;

import com.exp.demo.model.Cour;
import com.exp.demo.model.Section;
import com.exp.demo.repo.CourRepository;
import com.exp.demo.repo.SectionRepository;

@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping(path="/cours")

public class CourController {
	
	@Autowired
	CourRepository cr;
	@Autowired
	SectionRepository sr ;
	private static final String UPLOADED_FOLDER = "./assets/img/";
	
	@GetMapping(path="/cour/getidCours/{id}", produces = "application/json")
	public Optional<Cour> getCourById(@PathVariable(value = "id") Long courId) 
    {return cr.findById(courId);    }
	
	@GetMapping(path="/cour", produces = "application/json")
    public List<Cour> getCours() 
    {
	  
        return  cr.findAll();
    }
	
	
	 @PostMapping(value = "/cour", consumes = "application/json", produces = "application/json")
	    public void addCour(@RequestBody Cour cour) {
	         cr.save(cour);
	    }

	
	 @GetMapping("/cour/{id}")
		public List<Section> getSectionByCoursId(@PathVariable(value = "id") Long courId){
			List<Section> ls = sr.findAll();
			List<Section> nls =new  ArrayList<Section>();
			for(int i=0;i<ls.size();i++) {
				if(ls.get(i).getCour().getId_C()==courId) {
					nls.add(ls.get(i));
				}
				
			}
			return ls;
		}
	 
	 @DeleteMapping("/cour/{id}")
	  public ResponseEntity<HttpStatus> deleteCour(@PathVariable("id") long id) {
	    try {
	      cr.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	 
	 @PutMapping("/cour/{id}")
	  public Cour updateCour(@PathVariable(value = "id") Long courId,
	                                          @Valid @RequestBody Cour courDetails) {

	      Cour cour = cr.findById(courId).get();

	      cour.setTitre(courDetails.getTitre());
	      cour.setDescription(courDetails.getDescription());
	      cour.setPrix(courDetails.getPrix());
	      cour.setImage(courDetails.getImage());
	      cour.setVideo(courDetails.getVideo());
	      cour.setDescV(courDetails.getDescV());

	      Cour updatedCour = cr.save(cour);
	      return updatedCour;
	  }
	 @PostMapping("/course/upload") // //new annotation since 4.3
	    public String singleFileUpload(@RequestParam("image") MultipartFile image,@RequestParam("courseID") String courseID) {
	       // log.info("going to try upload1");
	        if (image.isEmpty()) {
	            return "File is Empty";
	        }
	      //  log.info("going to try upload");
	        try {
	            /* File directory = new File(UPLOADED_FOLDER);
	            if (!directory.exists()) {
	                directory.mkdir();
	                // If you require it to make the entire directory path including parents,
	                // use directory.mkdirs(); here instead.
	            } */
	            // Get the file and save it somewhere
	           // log.info(previewImage.getOriginalFilename());
	            // Get the file and save it somewhere
	            byte[] bytes = image.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + "login2.png");
	            Files.write(path, bytes);
	            Cour c = cr.getOne(Long.parseLong(courseID));
	            c.setImage(UPLOADED_FOLDER + "course_" + courseID + "_preview_img.png");
	            cr.save(c);
	            return "Success";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return "Done";
	    }
		
}
