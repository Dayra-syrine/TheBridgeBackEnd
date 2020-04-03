package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Video;



public interface VideoRepository extends JpaRepository<Video, Long> {

}
