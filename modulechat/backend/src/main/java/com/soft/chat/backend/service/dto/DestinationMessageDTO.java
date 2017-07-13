package com.soft.chat.backend.service.dto;

import java.io.Serializable;

/**
 * Created by jcori on 7/13/2017.
 */
public class DestinationMessageDTO implements Serializable {
    private Long messageId;
    private Long userId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
