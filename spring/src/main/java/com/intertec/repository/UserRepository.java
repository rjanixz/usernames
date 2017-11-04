package com.intertec.repository;


import com.intertec.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    // Overriding this to allow cache
    @Cacheable("users")
    List<User> findAll();
}
