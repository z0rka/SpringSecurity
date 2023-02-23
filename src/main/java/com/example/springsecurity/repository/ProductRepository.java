package com.example.springsecurity.repository;

import com.example.springsecurity.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for {@link Product} to work with database
 *
 * @author z0rka 13.02.2023
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    /**
     * Method to look for all the products in database
     *
     * @return List of {@link Product}
     */
    List<Product> findAll();
}
