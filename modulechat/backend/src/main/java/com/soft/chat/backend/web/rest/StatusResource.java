package com.soft.chat.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.soft.chat.backend.domain.Status;
import com.soft.chat.backend.service.StatusService;
import com.soft.chat.backend.service.dto.StatusDTO;
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
public class StatusResource {
    private final Logger log = LoggerFactory.getLogger(StatusResource.class);
    private static final String ENTITY_NAME = "status";
    private final StatusService statusService;
    public StatusResource(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/status")
    @Timed
    public ResponseEntity<Status> createStatus(@Valid @RequestBody StatusDTO statusDTO) throws URISyntaxException {
        log.debug("REST request to save Status : {}", statusDTO);
        if (statusDTO.getId() != 0) { //null
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new status cannot already have an ID")).body(null);
        }
        Status result = statusService.save(statusDTO);
        return ResponseEntity.created(new URI("/api/status/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @GetMapping("/status")
    @Timed
    public ResponseEntity<List<Status>> getAllStatus(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of Status");
        Page<Status> page = statusService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/status");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/status/{id}")
    @Timed
    public ResponseEntity<Status> getFindOneStatus(@PathVariable Long id) {
        log.debug("REST request to get Status : {}", id);
        Status status = statusService.findOne(id);
        return Optional.ofNullable(status)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/status/{id}")
    @Timed
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        log.debug("REST request to delete Status : {}", id);
        statusService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
