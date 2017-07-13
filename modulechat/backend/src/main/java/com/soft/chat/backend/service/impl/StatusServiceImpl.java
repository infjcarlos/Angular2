package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.Status;
import com.soft.chat.backend.service.StatusService;
import com.soft.chat.backend.service.dto.StatusDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class StatusServiceImpl implements StatusService{
    @Override
    public Status save(StatusDTO statusDTO) {
        return null;
    }

    @Override
    public Page<Status> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Status findOne(Long id) {
        return null;
    }

    @Override
    public Status update(StatusDTO statusDTO) {
        return null;
    }

    @Override
    public Status updateById(StatusDTO statusDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
