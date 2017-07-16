package com.soft.chat.backend.service.dto;

import java.util.Date;

/**
 * Created by jcori on 7/15/2017.
 */
public class DestinationMessagesDTO {
    private Long id;
    //messages
    private String content;
    private Long statusId;
    private Date creationDate;
    private Long userOwnerId;
    //destination
    private Long userDestineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getUserDestineId() {
        return userDestineId;
    }

    public void setUserDestineId(Long userDestineId) {
        this.userDestineId = userDestineId;
    }

    public Long getUserOwnerId() {
        return userOwnerId;
    }

    public void setUserOwnerId(Long userOwnerId) {
        this.userOwnerId = userOwnerId;
    }
}
