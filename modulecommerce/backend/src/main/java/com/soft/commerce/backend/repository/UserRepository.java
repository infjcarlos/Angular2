package com.soft.commerce.backend.repository;

import com.soft.commerce.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jcori on 6/30/2017.
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
