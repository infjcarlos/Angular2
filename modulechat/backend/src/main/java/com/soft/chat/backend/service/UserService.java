package com.soft.chat.backend.service;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jcori on 6/30/2017.
 */
public interface UserService {
    //UserDTO save(UserDTO userDTO);
    User save(UserDTO userDTO);
    Page<UserDTO> findAll(Pageable pageable);
    void delete(Long id);
}
