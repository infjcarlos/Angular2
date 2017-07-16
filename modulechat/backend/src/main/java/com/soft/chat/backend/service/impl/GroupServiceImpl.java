package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.Group;
import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.GroupRepository;
import com.soft.chat.backend.repository.UserRepository;
import com.soft.chat.backend.service.GroupService;
import com.soft.chat.backend.service.dto.GroupDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService{

    private final Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Group save(GroupDTO groupDTO) {
        log.debug("Request to save group : {}", groupDTO);
        Group group = new Group();
        group.setName(groupDTO.getName());
        group.setLogo(groupDTO.getLogo());
        group.setCreationDate(new Date());

        User userOwer = userRepository.findOne(groupDTO.getOwnerId());
        group.setOwner(userOwer);
        group = groupRepository.save(group);
        return group;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Group> findAll(Pageable pageable) {
        log.debug("Request to get all group");
        return groupRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Group findOne(Long id) {
        log.debug("Request to get Group : {}", id);
        return groupRepository.findOne(id);
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
        log.debug("Request to delete group : {}", id);
        groupRepository.delete(id);
    }
}
