package com.exp.demo.controller;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")  
@RestController
public class ImageUploadController {
	
	List<String> files = new ArrayList<String>();
	@Value("${assestsFolder}")
	String assestsFolder ;	

	   @PostMapping("/savefile")
	   public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		// log.info(logo.getOriginalFilename());
		   String message;
		   try {			   
	           // Get the file and save it somewhere
	           byte[] bytes = file.getBytes();
	           Files.createDirectories(Paths.get(assestsFolder));
	           Path path = Paths.get(assestsFolder + file.getOriginalFilename());
	           Files.write(path, bytes);
	           System.out.println("Successfully uploaded!");
	           message = "Successfully uploaded!";
		       return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			 message = "Failed to upload!";
			 e.printStackTrace();
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
          
	   }
}
