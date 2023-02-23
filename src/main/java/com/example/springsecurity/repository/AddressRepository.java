package com.example.springsecurity.repository;

import com.example.springsecurity.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for table address
 *
 * @author z0rka 23.02.2023
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
