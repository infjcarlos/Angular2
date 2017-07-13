package com.soft.chat.backend.service.dto;

import java.io.Serializable;

/**
 * Created by jcori on 7/13/2017.
 */
public class StatusDTO implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
