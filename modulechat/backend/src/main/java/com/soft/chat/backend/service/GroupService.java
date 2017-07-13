package com.soft.chat.backend.service;

import com.soft.chat.backend.domain.Group;
import com.soft.chat.backend.service.dto.GroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Created by jcori on 7/13/2017.
 */
public interface GroupService {
    Group save(GroupDTO groupDTO);
    Page<Group> findAll(Pageable pageable);
    Group findOne(Long id);
    Group update(GroupDTO groupDTO);
    Group updateById(GroupDTO groupDTO, Long id);
    void delete(Long id);
}
