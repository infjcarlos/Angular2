package com.soft.chat.backend.service;

import com.soft.chat.backend.domain.Message;
import com.soft.chat.backend.service.dto.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jcori on 7/13/2017.
 */
public interface MessageService {
    Message save(MessageDTO messageDTO);
    Page<Message> findAll(Pageable pageable);
    Message findOne(Long id);
    Message update(MessageDTO messageDTO);
    Message updateById(MessageDTO messageDTO, Long id);
    void delete(Long id);
}
