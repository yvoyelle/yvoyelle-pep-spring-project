package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.*;

import javax.el.ELException;
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

    public Message createmessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> messageList() {
        return (List<Message>) messageRepository.findAll();
    }

    public Optional<Message> getMessageById(int messageId) {
        return messageRepository.findById(messageId);
    }

    public int deleteMessageById(int messageId) {
        
        if (messageRepository.existsById(messageId)) {
            return 1;
        }
        return 0;
    }

    public List<Message> getAllMessagesByUser(int userId) {
        return messageRepository.findByPostedBy(userId);
    }

    public Message patchMessage(int messageId, String newText) throws ELException {
        Message message = messageRepository.findById(messageId).orElseThrow(() -> new ELException());

        if (messageId > 0)
            message.setMessageText(newText);

        return messageRepository.save(message);
    }
}
