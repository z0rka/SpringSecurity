package com.example.springsecurity.controller;


import com.example.springsecurity.dto.ProductDto;
import com.example.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller of the products
 *
 * @author z0rka 06.02.2023;
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    /**
     * Method to get product by id
     *
     * @param id - id of the product
     * @return Product
     */
    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable int id) {
        log.info("Get product method invoked");

        return productService.getById(id);
    }

    /**
     * Method to add product to the store
     *
     * @param productName - product name
     * @param price       - product price
     */
    @PostMapping("")
    public String addProduct(@RequestParam String productName, @RequestParam float price) {
        log.info("Add product to store method invoked");

        productService.add(productName, price);

        log.info("Add product to store method ended");
        return "Product to the store successfully added";
    }

    /**
     * Method to delete product from the store by id
     *
     * @param id - product id
     */
    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable int id) {
        log.info("Delete product from store by id method invoked");

        productService.deleteById(id);

        log.info("Delete product from store by id method ended");
        return "Product  successfully deleted ";
    }

    @GetMapping("")
    public List<ProductDto> getAll() {
        log.info("Get all products method invoked");
        return productService.getAll();
    }
}