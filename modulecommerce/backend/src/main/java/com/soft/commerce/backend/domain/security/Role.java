package com.soft.commerce.backend.domain.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jcori on 7/2/2017.
 */
@Entity
public class Role implements Serializable{
    private static final Long serialVersionUID = 789456L;
    @Id
    private Long roleId;
    private String name;
    private Set<UserRole> userRoleSet = new HashSet<>();

    public Role() { }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
