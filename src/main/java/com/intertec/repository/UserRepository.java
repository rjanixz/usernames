package com.intertec.repository;


import com.intertec.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//TODO extends from JpaRepository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUsername(String username);
}
