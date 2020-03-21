package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

}
