package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.Message;
import com.soft.chat.backend.service.MessageService;
import com.soft.chat.backend.service.dto.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Override
    public Message save(MessageDTO messageDTO) {
        return null;
    }

    @Override
    public Page<Message> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Message findOne(Long id) {
        return null;
    }

    @Override
    public Message update(MessageDTO messageDTO) {
        return null;
    }

    @Override
    public Message updateById(MessageDTO messageDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
