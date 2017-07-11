
package com.soft.chat.backend.service.mapper;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.service.dto.UserDTO;
import org.mapstruct.*;

/**
 * Created by jcori on 7/10/2017.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper <UserDTO, User> {

    UserDTO toDto(User user);
}