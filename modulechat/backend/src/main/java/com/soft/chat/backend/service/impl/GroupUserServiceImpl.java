package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.GroupUser;
import com.soft.chat.backend.service.GroupUserService;
import com.soft.chat.backend.service.dto.GroupUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class GroupUserServiceImpl implements GroupUserService{
    @Override
    public GroupUser save(GroupUserDTO groupUserDTO) {
        return null;
    }

    @Override
    public Page<GroupUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public GroupUser findOne(Long id) {
        return null;
    }

    @Override
    public GroupUser update(GroupUserDTO groupUserDTO) {
        return null;
    }

    @Override
    public GroupUser updateById(GroupUserDTO groupUserDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
