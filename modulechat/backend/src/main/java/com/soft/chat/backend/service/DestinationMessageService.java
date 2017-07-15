package com.soft.chat.backend.service;

import com.soft.chat.backend.domain.DestinationMessage;
import com.soft.chat.backend.service.dto.DestinationMessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Created by jcori on 7/13/2017.
 */
public interface DestinationMessageService {
    DestinationMessage save(DestinationMessageDTO destinationMessageDTO);
    Page<DestinationMessage> findAll(Pageable pageable);
    DestinationMessage findOne(Long id);
    DestinationMessage update(DestinationMessageDTO destinationMessageDTO);
    DestinationMessage updateById(DestinationMessageDTO destinationMessageDTO, Long id);
    void delete(Long id);
}
