package com.soft.chat.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.soft.chat.backend.domain.User;
import com.soft.chat.backend.service.UserService;
import com.soft.chat.backend.service.dto.UserDTO;
import com.soft.chat.backend.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jcori on 6/30/2017.
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);
    private static final String ENTITY_NAME = "user";

    private final UserService userService;
    public UserResource(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public String index(){
        return "car";
    }

    @PostMapping("/users")
    @Timed
    public ResponseEntity<UserDTO> createBank(@Valid @RequestBody UserDTO bankDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", bankDTO);
        if (bankDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new user cannot already have an ID")).body(null);
        }
        User result = userService.save(bankDTO);
        return ResponseEntity.created(new URI("/api/users/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(bankDTO);/*result*/
    }
}
