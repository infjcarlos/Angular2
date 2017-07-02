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
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public UserRole() { }

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }
}
