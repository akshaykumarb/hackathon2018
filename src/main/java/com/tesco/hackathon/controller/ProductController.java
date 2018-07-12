package com.tesco.hackathon.controller;


import com.sun.tools.javap.TypeAnnotationWriter;
import com.tesco.hackathon.Exception.ResourceNotFoundException;

import com.tesco.hackathon.model.Cart;
import com.tesco.hackathon.model.Product;
import com.tesco.hackathon.repository.CartRepository;
import com.tesco.hackathon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    CartRepository cartRepository;


    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllNotes() {
        System.out.println("*** gettting all products****");
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @ResponseBody

    public Product getProductId(@PathVariable(value = "id") Long productId) {
        System.out.println("*** gettting single  products****" + productId);

        searchProduct("Tea");
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    }

    public void searchProduct(String desc) {

        insertToCart(productRepository.getProduct(desc));
        // search the product in product table for description and return cart object

    }


    // insert product to cart
    public void insertToCart(Cart cart) {
        cart.setItem_name("tea");
        cart.setPrice(BigDecimal.valueOf(30.00));
        cartRepository.save(cart);


    }

}