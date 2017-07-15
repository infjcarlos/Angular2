package com.soft.chat.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.soft.chat.backend.domain.DestinationMessage;
import com.soft.chat.backend.domain.Message;
import com.soft.chat.backend.service.DestinationMessageService;
import com.soft.chat.backend.service.dto.DestinationMessageDTO;
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
public class DestinationMessageResource {
    private final Logger log = LoggerFactory.getLogger(DestinationMessageResource.class);
    private static final String ENTITY_NAME = "destinationMessage";

    private final DestinationMessageService destinationMessageService;

    public DestinationMessageResource(DestinationMessageService destinationMessageService) {
        this.destinationMessageService = destinationMessageService;
    }

    @PostMapping("/destination_messages")
    @Timed
    public ResponseEntity<DestinationMessage> createDestinationMessage(@Valid @RequestBody DestinationMessageDTO destinationMessageDTO) throws URISyntaxException {
        log.debug("REST request to save Destination Message : {}", destinationMessageDTO);
        if (destinationMessageDTO.getId() != 0) { //null
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new destination messages cannot already have an ID")).body(null);
        }
        DestinationMessage result = destinationMessageService.save(destinationMessageDTO);
        return ResponseEntity.created(new URI("/api/destination_messages/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @GetMapping("/destination_messages")
    @Timed
    public ResponseEntity<List<DestinationMessage>> getAllMessage(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of Destination Message");
        Page<DestinationMessage> page = destinationMessageService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/destination_messages");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
