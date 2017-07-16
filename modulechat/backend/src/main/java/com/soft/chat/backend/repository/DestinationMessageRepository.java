package com.soft.chat.backend.repository;

import com.soft.chat.backend.domain.DestinationMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jcori on 7/13/2017.
 */
public interface DestinationMessageRepository extends JpaRepository<DestinationMessage,Long>{

    @Query("select dm from DestinationMessage dm where dm.message.id =:messageId")
    DestinationMessage getAllDM(@Param("messageId") Long messageId);

}
