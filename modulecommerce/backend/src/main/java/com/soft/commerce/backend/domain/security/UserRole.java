package com.soft.commerce.backend.domain.security;

import com.soft.commerce.backend.domain.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jcori on 7/2/2017.
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable{
    private static final Long serialVersionUID = 789456L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() { }

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
