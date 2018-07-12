package com.tesco.hackathon.controller;


import com.sun.tools.javap.TypeAnnotationWriter;
import com.tesco.hackathon.Exception.ResourceNotFoundException;
import com.tesco.hackathon.model.Product;
import com.tesco.hackathon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllNotes() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Product getNoteById(@PathVariable(value = "id") Long productID) {
        return productRepository.findById(productID)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productID));
    }

}
