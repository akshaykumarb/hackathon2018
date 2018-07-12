package com.tesco.hackathon.controller;




import com.tesco.hackathon.exception.ResourceNotFoundException;
import com.tesco.hackathon.model.Cart;
import com.tesco.hackathon.model.CartKey;
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


    @GetMapping("/cart")
    @ResponseBody
    public List<Cart> getCart() {
        System.out.println("*** gettting all products****");
        return cartRepository.findAll();
    }

    @GetMapping("/products/{cartKey}")
    @ResponseBody
    public void searchProduct(@PathVariable CartKey cartKey) {
// search the product in product table for description and insert to cart table
      productRepository.insertToCart(cartKey);


    }



}