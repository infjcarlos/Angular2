package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.Status;
import com.soft.chat.backend.repository.StatusRepository;
import com.soft.chat.backend.service.StatusService;
import com.soft.chat.backend.service.dto.StatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }
    @Override
    public Status save(StatusDTO statusDTO) {
        log.debug("Request to save status : {}", statusDTO);
        Status status = new Status();
        status.setName(statusDTO.getName());
        status = statusRepository.save(status);
        return status;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Status> findAll(Pageable pageable) {
        log.debug("Request to get all status");
        return statusRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Status findOne(Long id) {
        log.debug("Request to get Status : {}", id);
        return statusRepository.findOne(id);
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
        log.debug("Request to delete Status : {}", id);
        statusRepository.delete(id);

    }
}
