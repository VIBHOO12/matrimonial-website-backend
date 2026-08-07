package com.infosys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Reply;
import com.infosys.repositories.ReplyRepository;

@Service
public class ReplyService implements ReplyInterface{
	 @Autowired
	 private ReplyRepository replyRepository;

	    @Override
	    public Reply saveReply(Reply reply) {
	        return this.replyRepository.save(reply);
	    }

	    @Override
	    public List<Reply> getAllReply() {
	        return replyRepository.findAll();
	    }

	    @Override
	    public Optional<Reply> getReplyById(Integer id) {
	        return replyRepository.findById(id);
	    }
	    @Override
	    public List<Reply> getReplyByEmail(String email) {
	        return replyRepository.findByEmail(email); // Updated method implementation
	    }

	    @Override
	    public Reply updateReply(Integer id, Reply reply) {
	        if (replyRepository.existsById(id)) {
	            reply.setReplyId(id);
	            return replyRepository.save(reply);
	        }
	        throw new RuntimeException("Contact not found");
	    }

	    @Override
	    public void deleteReply(Integer id) {
	        replyRepository.deleteById(id);
	    }
}
