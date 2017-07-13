package com.soft.chat.backend.service.impl;

import com.soft.chat.backend.domain.DestinationMessage;
import com.soft.chat.backend.service.DestinationMessageService;
import com.soft.chat.backend.service.dto.DestinationMessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jcori on 7/13/2017.
 */
@Service
@Transactional
public class DestinationMessageServiceImpl implements DestinationMessageService {
    @Override
    public DestinationMessage save(DestinationMessageDTO messageDTO) {
        return null;
    }

    @Override
    public Page<DestinationMessage> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public DestinationMessage findOne(Long id) {
        return null;
    }

    @Override
    public DestinationMessage update(DestinationMessageDTO messageDTO) {
        return null;
    }

    @Override
    public DestinationMessage updateById(DestinationMessageDTO messageDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
