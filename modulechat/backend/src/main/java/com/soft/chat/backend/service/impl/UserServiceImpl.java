package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.UserRepository;
import com.soft.chat.backend.service.UserService;
import com.soft.chat.backend.service.dto.UserDTO;
import com.soft.chat.backend.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jcori on 6/30/2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save user : {}", userDTO);
        User user = userMapper.userDTOToUser(userDTO);
        user = userRepository.save(user);
        return userDTO;
    }

    @Override
    public void delete(Long id) {

    }
}
