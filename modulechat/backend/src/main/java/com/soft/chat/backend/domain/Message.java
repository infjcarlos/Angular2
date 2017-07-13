package com.soft.chat.backend.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jcori on 7/12/2017.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @ManyToOne
    private Status status;

    private Date creationDate;

    @ManyToOne
    private User User;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public com.soft.chat.backend.domain.User getUser() {
        return User;
    }

    public void setUser(com.soft.chat.backend.domain.User user) {
        User = user;
    }
}

