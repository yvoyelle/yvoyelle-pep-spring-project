package com.example.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.MessageRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class MessageService {

    private  MessageRepository messageRepository;


    public void MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;

    }

    public Message  createmessage( Message message){
        return messageRepository.save(message);
    }

  

 

}
