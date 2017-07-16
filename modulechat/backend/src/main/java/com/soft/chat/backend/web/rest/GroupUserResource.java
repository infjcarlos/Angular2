package com.soft.chat.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.soft.chat.backend.domain.GroupUser;
import com.soft.chat.backend.service.GroupUserService;
import com.soft.chat.backend.service.dto.GroupUserDTO;
import com.soft.chat.backend.web.rest.util.PaginationUtil;
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
 * Created by jcori on 7/13/2017.
 */
@RestController
@RequestMapping("/api")
public class GroupUserResource {
    private final Logger log = LoggerFactory.getLogger(GroupUserResource.class);
    private static final String ENTITY_NAME = "group_user";

    private final GroupUserService groupUserService;
    public GroupUserResource(GroupUserService groupUserService) {
        this.groupUserService = groupUserService;
    }

    @PostMapping("/groupusers")
    @Timed
    public ResponseEntity<GroupUser> createUser(@Valid @RequestBody GroupUserDTO groupUserDTO) throws URISyntaxException {
        log.debug("REST request to save Group User : {}", groupUserDTO);
        if (groupUserDTO.getId() != 0) { //null
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new group user cannot already have an ID")).body(null);
        }
        GroupUser result = groupUserService.save(groupUserDTO);
        return ResponseEntity.created(new URI("/api/groupusers/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    /*
    @PutMapping("/groupusers")
    @Timed
    public ResponseEntity<GroupUser> updateGroupUser(@Valid @RequestBody GroupUserDTO groupUserDTO) throws URISyntaxException {
        log.debug("REST request to update Group User : {}", groupUserDTO);
        if (groupUserDTO.getId() == 0) {//null
            return createUser(groupUserDTO);
        }
        GroupUser result = groupUserService.update(groupUserDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, groupUserDTO.getId().toString()))
                .body(result);
    }

    @PutMapping("/groupusers/{id}")
    @Timed
    public ResponseEntity<GroupUser> updateGroupUserById(@Valid @RequestBody GroupUserDTO userDTO, @PathVariable Long id) throws URISyntaxException {
        log.debug("REST request to update Group User with Id: {}", userDTO);
        GroupUser result = groupUserService.updateById(userDTO, id);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userDTO.getId().toString()))
                .body(result);
    }
    */

    @GetMapping("/groupusers")
    @Timed
    public ResponseEntity<List<GroupUser>> getAllGroupUsers(@ApiParam Pageable pageable) throws URISyntaxException {
        log.debug("REST request to get a page of Group Users");
        Page<GroupUser> page = groupUserService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/groupusers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    @GetMapping("/groupusers/{id}")
    @Timed
    public ResponseEntity<GroupUser> getFindOneGroupUser(@PathVariable Long id) {
        log.debug("REST request to get Group User : {}", id);
        GroupUser groupUser = groupUserService.findOne(id);
        return Optional.ofNullable(groupUser)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/groupusers/{id}")
    @Timed
    public ResponseEntity<Void> deleteGroupUser(@PathVariable Long id) {
        log.debug("REST request to delete Group User : {}", id);
        groupUserService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
