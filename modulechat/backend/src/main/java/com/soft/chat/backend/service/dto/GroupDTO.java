package com.soft.chat.backend.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jcori on 7/13/2017.
 */
public class GroupDTO implements Serializable {

    private Long ownerId;
    private String name;
    private String logo;
    private Date creationDate;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
