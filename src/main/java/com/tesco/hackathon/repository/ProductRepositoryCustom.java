package com.tesco.hackathon.repository;

import com.tesco.hackathon.model.Cart;
import com.tesco.hackathon.model.CartKey;

import java.util.List;

public interface ProductRepositoryCustom {


    public void insertToCart(CartKey cartKey);

}
