package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.transaction.Transactional;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // ***************************************************************************************
    // -----Injection messageRepository----
    // *************************************************************************************
    @Autowired
    public void MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;

    }

    // ***************************************************************************************
    // -----I used transitional for modifical row in the DB----
    // *************************************************************************************
    @Transactional
    public Message createmessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> messageList() {
        return (List<Message>) messageRepository.findAll();
    }

    public Optional<Message> getMessageById(int messageId) {
        return messageRepository.findById(messageId);
    }

    // ***************************************************************************************
    // -----I used transitional for modifical row in the DB----
    // ***************************************************************************************
    @Transactional
    public int deleteMessageById(int messageId) {
        if (messageRepository.existsById(messageId)) {
            return 1;
        }
        return 0;
    }

    // ***************************************************************************************
    // -----list all message based in id provide----
    // *************************************************************************************
    public List<Message> getAllMessagesByUser(int userId) {
        return messageRepository.findByPostedBy(userId);
    }

    // ***************************************************************************************
    // -----I used transitional for modifical row in the DB----
    // *************************************************************************************
    @Transactional
    public int updateMessage(int messageId, String newText) {
        return messageRepository.updateMessageTextById( newText,messageId);
    }
}
