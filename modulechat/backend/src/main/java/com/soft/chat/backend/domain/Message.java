package com.soft.chat.backend.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private User user;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<DestinationMessage> destinationMessages;

    public Message() { }

    public Message(List<DestinationMessage> destinationMessages) {
        this.destinationMessages = destinationMessages;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

