package com.example.springsecurity.repository;

import com.example.springsecurity.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for {@link UserInfo} to work with database
 *
 * @author z0rka 13.02.2023
 */
@Repository
public interface UserRepository extends CrudRepository<UserInfo, Integer> {

    /**
     * Method to look for all the users in database
     *
     * @return List of {@link UserInfo}
     */

    List<UserInfo> findAll();

    /**
     * Method to look for user with exact name in database
     *
     * @return List of {@link UserInfo}
     */
    Optional<UserInfo> findFirstByName(String name);
}
