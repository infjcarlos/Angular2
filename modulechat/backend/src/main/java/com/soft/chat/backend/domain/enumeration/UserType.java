package com.soft.chat.backend.domain.enumeration;

import java.util.*;
/**
 * Created by jcori on 7/15/2017.
 */
public enum UserType {
    STATUS_REMOVED("REMOVED"),
    STATUS_ACTIVE("ACTIVE");
    private String key;

    UserType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
