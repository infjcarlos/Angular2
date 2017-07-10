package com.soft.chat.backend.service.mapper;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.service.dto.UserDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

/**
 * Created by jcori on 7/10/2017.
 */
@Service
public class UserMapper {

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            /*
            Set<Authority> authorities = this.authoritiesFromStrings(userDTO.getAuthorities());
            if(authorities != null) {
                user.setAuthorities(authorities);
            }
            */
            return user;
        }
    }
}