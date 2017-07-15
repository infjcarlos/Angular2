package com.soft.chat.backend.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jcori on 7/13/2017.
 */
public class MessageDTO implements Serializable {

    private Long id;
    private String content;
    private Long statusId;
    private Date creationDate;
    private Long UserId;

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

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
}
