package com.infosys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entities.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	List<Reply> findByEmail(String email); // New method
}
