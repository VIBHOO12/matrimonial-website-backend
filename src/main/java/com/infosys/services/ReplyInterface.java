package com.infosys.services;

import java.util.List;
import java.util.Optional;

import com.infosys.entities.Reply;

public interface ReplyInterface {
    Reply saveReply(Reply reply);
    List<Reply> getAllReply();
    Optional<Reply> getReplyById(Integer id);
    List<Reply> getReplyByEmail(String email); // Updated return type
    Reply updateReply(Integer id, Reply reply);
    void deleteReply(Integer id);
}
