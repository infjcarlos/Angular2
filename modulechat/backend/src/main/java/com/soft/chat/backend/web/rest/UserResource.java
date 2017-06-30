package com.soft.chat.backend.web.rest;

import com.soft.chat.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jcori on 6/30/2017.
 */
@RestController
@RequestMapping("/api")
public class UserResource {
    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;
    public UserResource(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public String index(){
        return "car";
    }
}
