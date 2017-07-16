package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.Message;
import com.soft.chat.backend.domain.Status;
import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.MessageRepository;
import com.soft.chat.backend.repository.StatusRepository;
import com.soft.chat.backend.repository.UserRepository;
import com.soft.chat.backend.service.MessageService;
import com.soft.chat.backend.service.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final MessageRepository messageRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    public MessageServiceImpl(MessageRepository messageRepository, StatusRepository statusRepository, UserRepository userRepository){
        this.messageRepository = messageRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Message save(MessageDTO messageDTO) {
        log.debug("Request to save message : {}", messageDTO);
        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setCreationDate(new Date());

        Status status = statusRepository.findOne(messageDTO.getStatusId() );
        message.setStatus(status);

        User user = userRepository.findOne(messageDTO.getUserId());
        message.setUser(user);

        message = messageRepository.save(message);
        return message;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Message> findAll(Pageable pageable) {
        log.debug("Request to get all message");
        return messageRepository.findAll(pageable);
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
        log.debug("Request to Update By Id message", messageDTO);
        Message message = messageRepository.findOne(id);
        message.setContent(messageDTO.getContent());
        message = messageRepository.save(message);
        return message;
    }

    @Override
    public void delete(Long id) {

    }
}
