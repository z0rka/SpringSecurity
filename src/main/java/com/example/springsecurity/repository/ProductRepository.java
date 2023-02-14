package com.example.springsecurity.repository;

import com.example.springsecurity.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author z0rka 13.02.2023
 * Repository for {@link Product}
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
}
