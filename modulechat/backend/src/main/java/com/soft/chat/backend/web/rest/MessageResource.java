package com.soft.chat.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.soft.chat.backend.domain.Message;
import com.soft.chat.backend.service.MessageService;
import com.soft.chat.backend.service.dto.MessageDTO;
import com.soft.chat.backend.web.rest.util.PaginationUtil;
import com.soft.chat.backend.web.rest.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import com.soft.chat.backend.web.rest.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
/**
 * Created by jcori on 7/15/2017.
 */
@RestController
@RequestMapping("/api")
public class MessageResource {
    private final Logger log = LoggerFactory.getLogger(MessageResource.class);
    private static final String ENTITY_NAME = "message";
    private final MessageService messageService;
    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    @Timed
    public ResponseEntity<Message> createMessage(@Valid @RequestBody MessageDTO messageDTO) throws URISyntaxException {
        log.debug("REST request to save Message : {}", messageDTO);
        if (messageDTO.getId() != 0) { //null
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new messages cannot already have an ID")).body(null);
        }
        Message result = messageService.save(messageDTO);
        return ResponseEntity.created(new URI("/api/messages/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @GetMapping("/messages")
    @Timed
    public ResponseEntity<List<Message>> getAllMessage(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of Message");
        Page<Message> page = messageService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/messages");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
