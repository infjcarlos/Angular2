package com.soft.chat.backend.service;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jcori on 6/30/2017.
 */
public interface UserService {
    User save(UserDTO userDTO);
    Page<User> findAll(Pageable pageable);
    User findOne(Long id);
    User findOneByUserName(String username);
    User updateUser(UserDTO userDTO);
    User updateUserById(UserDTO userDTO, Long id);
    void delete(Long id);
}
