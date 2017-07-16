package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.DestinationMessage;
import com.soft.chat.backend.domain.Message;
import com.soft.chat.backend.domain.Status;
import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.DestinationMessageRepository;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private final DestinationMessageRepository destinationMessageRepository;

    public MessageServiceImpl(MessageRepository messageRepository, StatusRepository statusRepository, UserRepository userRepository, DestinationMessageRepository destinationMessageRepository) {
        this.messageRepository = messageRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
        this.destinationMessageRepository = destinationMessageRepository;
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

    @Override
    public void deleteAllMessage(Long ownerId) {
        log.debug("Request to delete Message : {}", ownerId);
        List<Message> messages = messageRepository.findAllMessage(ownerId);
        List<DestinationMessage> dm = new ArrayList<>();

        for(Message msg: messages){
            System.out.println(" - "+msg.getId());

            DestinationMessage destinationMessage = new DestinationMessage();
            destinationMessage = destinationMessageRepository.getAllDM( msg.getId() ) ;

            dm.add(destinationMessage);
            System.out.println("-----------");

        }
        for(DestinationMessage destinationMessage : dm){
            destinationMessageRepository.delete(destinationMessage.getId());
        }
        for(Message msg : messages){
            messageRepository.delete(msg.getId());
        }

        //Message message = messageRepository.findOne(ownerId);
        System.out.println(messages.size());
    }

    @Override
    public void deleteAllMessageT(Long ownerId) {
        log.debug("Request to delete Message ALL : {}", ownerId);
        List<Message> messages = messageRepository.findAllMessage(ownerId);
        for(Message msg : messages){
            messageRepository.delete(msg.getId());
        }
    }
}
