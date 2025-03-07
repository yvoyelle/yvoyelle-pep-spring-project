package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
import com.example.entity.Message;
import java.util.*;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

  List<Message> findByPostedBy(int postedBy);

}
