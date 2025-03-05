package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
import com.example.entity.Message;
import java.util.*;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Repository
public interface MessageRepository extends JpaRepository <Message,Long> {

    //Optional<Message> findByPostid(int post_id);


}
