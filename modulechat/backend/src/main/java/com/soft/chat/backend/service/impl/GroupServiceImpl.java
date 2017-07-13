package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.Group;
import com.soft.chat.backend.service.GroupService;
import com.soft.chat.backend.service.dto.GroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService{
    @Override
    public Group save(GroupDTO groupDTO) {
        return null;
    }

    @Override
    public Page<Group> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Group findOne(Long id) {
        return null;
    }

    @Override
    public Group update(GroupDTO groupDTO) {
        return null;
    }

    @Override
    public Group updateById(GroupDTO groupDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
