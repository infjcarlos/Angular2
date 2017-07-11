
package com.soft.chat.backend.service.mapper;

import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.service.dto.UserDTO;
import org.mapstruct.*;

/**
 * Created by jcori on 7/10/2017.
 */
//@Mapper(componentModel = "spring", uses = {})
public interface UserMapper{
    @Mappings({
            @Mapping(target="id", source="user.id"),
            @Mapping(target="firstName", source="user.firstName"),
            @Mapping(target="lastName", source="user.lastName")
    })
    User toEntity(UserDTO dto);

    @Mappings({
            @Mapping(target="id", source="user.id"),
            @Mapping(target="firstName", source="user.firstName"),
            @Mapping(target="lastName", source="user.lastName")
    })
    UserDTO toDto(User user);
}