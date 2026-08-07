package com.infosys.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infosys.entities.Reply;
import com.infosys.services.ReplyService;

public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("/")
    public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
        Reply savedReply= replyService.saveReply(reply);
        return ResponseEntity.ok(savedReply);
    }

    @GetMapping("/get/")
    public ResponseEntity<List<Reply>> getAllReply() {
        List<Reply> replies = replyService.getAllReply();
        return ResponseEntity.ok(replies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reply> getReplyById(@PathVariable Integer id) {
        Optional<Reply> reply = replyService.getReplyById(id);
        return reply.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<List<Reply>> getReplyByEmail(@PathVariable String email) {
        List<Reply> replies = replyService.getReplyByEmail(email);
        if (replies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(replies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reply> updateReply(@PathVariable Integer id, @RequestBody Reply reply) {
        try {
            Reply updatedReply = replyService.updateReply(id, reply);
            return ResponseEntity.ok(updatedReply);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Integer id) {
        replyService.deleteReply(id);
        return ResponseEntity.noContent().build();
    }

}
