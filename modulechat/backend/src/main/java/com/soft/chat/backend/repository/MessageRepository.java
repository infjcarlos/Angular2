package com.soft.chat.backend.repository;

import com.soft.chat.backend.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jcori on 7/13/2017.
 */
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query("select message from Message message where message.user =:ownerId")
    List<Message> findAllMessage(@Param("ownerId") Long ownerId);
}
