package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.DestinationMessage;
import com.soft.chat.backend.domain.Message;
import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.DestinationMessageRepository;
import com.soft.chat.backend.repository.MessageRepository;
import com.soft.chat.backend.repository.UserRepository;
import com.soft.chat.backend.service.DestinationMessageService;
import com.soft.chat.backend.service.dto.DestinationMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class DestinationMessageServiceImpl implements DestinationMessageService {

    private final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final DestinationMessageRepository destinationMessageRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public DestinationMessageServiceImpl(DestinationMessageRepository destinationMessageRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.destinationMessageRepository = destinationMessageRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public DestinationMessage save(DestinationMessageDTO destinationMessageDTO) {
        log.debug("Request to save destination message : {}", destinationMessageDTO);
        DestinationMessage destinationMessage = new DestinationMessage();

        User user = userRepository.findOne(destinationMessageDTO.getUserId());
        destinationMessage.setUser(user);

        Message message = messageRepository.findOne(destinationMessageDTO.getMessageId());
        destinationMessage.setMessage(message);

        destinationMessage = destinationMessageRepository.save(destinationMessage);
        return destinationMessage;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DestinationMessage> findAll(Pageable pageable) {
        log.debug("Request to get all destination message");
        return destinationMessageRepository.findAll(pageable);
    }

    @Override
    public DestinationMessage findOne(Long id) {
        return null;
    }

    @Override
    public DestinationMessage update(DestinationMessageDTO destinationMessageDTO) {
        return null;
    }

    @Override
    public DestinationMessage updateById(DestinationMessageDTO destinationMessageDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
