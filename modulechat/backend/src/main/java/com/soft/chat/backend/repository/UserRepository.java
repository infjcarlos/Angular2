package com.soft.chat.backend.repository;

import com.soft.chat.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jcori on 6/30/2017.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("select user from User user where user.username =:login")
    User findOneWithEagerUser(@Param("login") String login);
}
