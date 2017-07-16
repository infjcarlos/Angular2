package com.soft.chat.backend.repository;

import com.soft.chat.backend.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jcori on 7/13/2017.
 */
public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("select group from Group group where group.owner.id =:ownerId")
    List<Group> findAllGroup(@Param("ownerId") Long ownerId);
}
