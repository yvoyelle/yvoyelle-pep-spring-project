package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.transaction.Transactional;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.MessageRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class MessageService {

@Autowired
    private  MessageRepository messageRepository;

@Autowired
    public void MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;

    }
    @Transactional
    public Message  createmessage( Message message){
        return messageRepository.save(message);
    }

  public List <Message> messageList (){
    return messageRepository.findAll();
  }

 

}
