package com.example.springsecurity.repository;

import com.example.springsecurity.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author z0rka 13.02.2023
 * Repository for {@link UserInfo}
 */
@Repository
public interface UserRepository extends CrudRepository<UserInfo, Integer> {
    List<UserInfo> findAll();

    Optional<UserInfo> findFirstByName(String name);
}
