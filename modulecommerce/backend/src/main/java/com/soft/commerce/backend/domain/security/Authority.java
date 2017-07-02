package com.soft.commerce.backend.domain.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by jcori on 7/2/2017.
 */
public class Authority implements GrantedAuthority, Serializable {
    private static final Long serialVersionUID = 123123L;
    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
