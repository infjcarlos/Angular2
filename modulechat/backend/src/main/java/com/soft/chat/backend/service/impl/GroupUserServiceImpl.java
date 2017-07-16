package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.Group;
import com.soft.chat.backend.domain.GroupUser;
import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.repository.GroupRepository;
import com.soft.chat.backend.repository.GroupUserRepository;
import com.soft.chat.backend.repository.UserRepository;
import com.soft.chat.backend.service.GroupUserService;
import com.soft.chat.backend.service.dto.GroupUserDTO;
import com.soft.chat.backend.service.dto.GroupUsersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class GroupUserServiceImpl implements GroupUserService{

    private final Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);
    private final GroupUserRepository groupUserRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public GroupUserServiceImpl(GroupUserRepository groupUserRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.groupUserRepository = groupUserRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupUser save(GroupUserDTO groupUserDTO) {
        log.debug("Request to save group user : {}", groupUserDTO);
        GroupUser groupUser = new GroupUser();

        User user = userRepository.findOne(groupUserDTO.getUserId());
        Group group = groupRepository.findOne(groupUserDTO.getGroupId());

        groupUser.setUser(user);
        groupUser.setGroup(group);

        groupUser = groupUserRepository.save(groupUser);
        return groupUser;
    }

    @Override
    public GroupUser saveGroup(GroupUsersDTO groupUsersDTO) {
        log.debug("Request to save group user all : {}", groupUsersDTO);
        GroupUser groupUser = new GroupUser();
        User owner = userRepository.findOne(groupUsersDTO.getOwnerId());
        groupUser.setUser(owner);

        ///////////create group
        Group group = new Group();
        group.setName(groupUsersDTO.getName());
        group.setLogo(groupUsersDTO.getLogo());
        group.setCreationDate(new Date());
        group.setOwner(owner);
        group = groupRepository.save(group);
        ///////////
        groupUser.setGroup(group);
        groupUserRepository.save(groupUser);
        return groupUser;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GroupUser> findAll(Pageable pageable) {
        log.debug("Request to get all group user");
        return groupUserRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupUser findOne(Long id) {
        log.debug("Request to get Group User: {}", id);
        return groupUserRepository.findOne(id);
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
        log.debug("Request to delete group user: {}", id);
        groupUserRepository.delete(id);
    }

    @Override
    public void deleteAllGroupT(Long ownerId) {
        log.debug("Request to delete Group ALL : {}", ownerId);
        List<Group> group = groupRepository.findAllGroup(ownerId);
        for(Group msg : group){
            groupRepository.delete(msg.getId());
        }
    }
}
