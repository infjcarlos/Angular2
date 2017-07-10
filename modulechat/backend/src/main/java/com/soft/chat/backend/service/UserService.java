package com.soft.chat.backend.service;

import com.soft.chat.backend.service.dto.UserDTO;

/**
 * Created by jcori on 6/30/2017.
 */
public interface UserService {
    UserDTO save(UserDTO userDTO);
    void delete(Long id);
}
