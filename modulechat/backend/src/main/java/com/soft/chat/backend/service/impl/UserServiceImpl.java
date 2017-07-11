package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.UserRepository;
import com.soft.chat.backend.service.UserService;
import com.soft.chat.backend.service.dto.UserDTO;
import com.soft.chat.backend.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    //private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository/*, UserMapper userMapper */){
        this.userRepository = userRepository;
        //this.userMapper = userMapper;
    }
    /*
    @Override
    public UserDTO save(UserDTO userDTO) { //public UserDTO save(UserDTO userDTO)

        log.debug("Request to save user : {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        UserDTO result = userMapper.toDto(user);
        return result;
    }
    */
    @Override
    public User save(UserDTO userDTO) { //public UserDTO save(UserDTO userDTO)
        log.debug("Request to save user : {}", userDTO);
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.getStatus());
        user = userRepository.save(user);
        return user;
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        /*
        log.debug("Request to get all Cities");
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);
        */
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
