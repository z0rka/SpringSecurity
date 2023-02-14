package com.example.springsecurity.service;

import com.example.springsecurity.dto.ProductDto;
import com.example.springsecurity.model.Product;
import com.example.springsecurity.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author z0rka 13.02.2023
 * ProductRepository service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    /**
     * Method to parse Product to ProductDTO
     */
    private ProductDto parseProduct(Product product) {
        log.info("Parsing product");
        return objectMapper.convertValue(product, ProductDto.class);
    }

    /**
     * Method to add Product
     *
     * @param name- name
     * @param cost  - cost
     */
    @Transactional
    public void add(String name, float cost) {
        log.info("Add product method invoked");

        if (name == null) {
            log.error("Name of the product is null");
            return;
        }

        Product product = new Product();
        product.setName(name);
        product.setCost(cost);

        productRepository.save(product);

        log.info("Add product method ended");
    }

    /**
     * Method to delete product by id
     *
     * @param id - users id
     */
    @Transactional
    public void deleteById(int id) {
        log.info("Delete product method invoked");

        productRepository.deleteById(id);

        log.info("Delete product method ended");
    }

    /**
     * Method to get all products
     *
     * @return List<ProductDto>
     */

    public List<ProductDto> getAll() {
        log.info("Get all method invoked");

        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map(this::parseProduct).toList();
    }


    /**
     * Method to get  product by id
     *
     * @param id - product id
     * @return ProductDto
     */
    public ProductDto getById(int id) {
        log.info("Get by id method invoked");

        Optional<Product> product = productRepository.findById(id);
        return parseProduct(product.orElseThrow(() -> new EntityNotFoundException("Product is null")));
    }
}
