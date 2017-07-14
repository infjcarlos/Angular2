package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.UserRepository;
import com.soft.chat.backend.service.UserService;
import com.soft.chat.backend.service.dto.UserDTO;
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

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDTO userDTO) {
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
    public User updateUser(UserDTO userDTO) {
        log.debug("Request to Update By user", userDTO);
        User user = userRepository.findOne(userDTO.getId());
        user.setFirstName(userDTO.getFirstName() );
        user.setLastName(userDTO.getLastName() );
        user.setUsername(userDTO.getUsername() );
        user.setPassword(userDTO.getPassword() );
        user.setEmail( userDTO.getEmail() );
        user.setStatus( userDTO.getStatus() );
        userRepository.save(user);
        return user;
    }
    @Override
    @Transactional(readOnly = true)
    public User findOneByUserName(String username) {
        log.debug("Request to get User : {}", username);
        User user = userRepository.findOneWithEagerUser(username);
        return user;
    }

    @Override
    public User updateUserById(UserDTO userDTO, Long id){
        log.debug("Request to Update By Id user", userDTO);
        User user = userRepository.findOne(id);
        user.setFirstName(userDTO.getFirstName() );
        user.setLastName(userDTO.getLastName() );
        user.setUsername(userDTO.getUsername() );
        user.setPassword(userDTO.getPassword() );
        user.setEmail( userDTO.getEmail() );
        user.setStatus( userDTO.getStatus() );
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        log.debug("Request to get all users");
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(Long id) {
        log.debug("Request to get User : {}", id);
        return userRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete User : {}", id);
        userRepository.delete(id);
    }

}
