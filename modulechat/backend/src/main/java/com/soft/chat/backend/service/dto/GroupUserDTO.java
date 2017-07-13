package com.soft.chat.backend.service.dto;

import java.io.Serializable;

/**
 * Created by jcori on 7/13/2017.
 */
public class GroupUserDTO implements Serializable {

    private Long id;
    private Long userId;
    private Long groupId;

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
