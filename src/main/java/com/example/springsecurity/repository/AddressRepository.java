package com.example.springsecurity.repository;

import com.example.springsecurity.model.Address;
import com.example.springsecurity.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for table address
 *
 * @author z0rka 23.02.2023
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    /**
     * Method to find by user
     */
    Optional<Address> findFirstByUserInfo(UserInfo userInfo);
}
