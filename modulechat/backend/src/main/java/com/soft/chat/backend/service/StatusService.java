package com.soft.chat.backend.service;

import com.soft.chat.backend.domain.Status;
import com.soft.chat.backend.service.dto.StatusDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Created by jcori on 7/13/2017.
 */
public interface StatusService {
    Status save(StatusDTO statusDTO);
    Page<Status> findAll(Pageable pageable);
    Status findOne(Long id);
    Status update(StatusDTO statusDTO);
    Status updateById(StatusDTO statusDTO, Long id);
    void delete(Long id);
}
