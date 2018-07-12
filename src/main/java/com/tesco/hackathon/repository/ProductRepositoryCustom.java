package com.tesco.hackathon.repository;

import com.tesco.hackathon.model.Cart;

import java.util.List;

public interface ProductRepositoryCustom {


    public List<Cart> getProduct(String desc);

    public void insertToCart(String desc);

}
