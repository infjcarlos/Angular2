package com.soft.chat.backend.repository;

import com.soft.chat.backend.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jcori on 7/13/2017.
 */
public interface StatusRepository extends JpaRepository<Status,Long>{
}
