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

  // ***************************************************************************************
  // -----I fund this query in Stack OverFlow but what they expalin is number 1 is
  // for the first value and 2 for the segun value----
  // *************************************************************************************
  @Modifying
  @Query("UPDATE Message SET messageText = ?1 WHERE messageId = ?2")
  int updateMessageTextById(String messageText, int messageId);
}
