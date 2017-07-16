package com.soft.chat.backend.service;

import com.soft.chat.backend.domain.GroupUser;
import com.soft.chat.backend.service.dto.GroupUserDTO;
import com.soft.chat.backend.service.dto.GroupUsersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jcori on 7/13/2017.
 */
public interface GroupUserService {

    GroupUser save(GroupUserDTO groupUserDTO);
    GroupUser saveGroup(GroupUsersDTO groupUsersDTO);
    Page<GroupUser> findAll(Pageable pageable);
    GroupUser findOne(Long id);
    GroupUser update(GroupUserDTO groupUserDTO);
    GroupUser updateById(GroupUserDTO groupUserDTO, Long id);
    void delete(Long id);
    void deleteAllGroupT(Long ownerId);
}
