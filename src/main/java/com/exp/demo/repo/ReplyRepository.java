package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
