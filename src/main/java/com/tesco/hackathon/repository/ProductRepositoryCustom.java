package com.tesco.hackathon.repository;

import com.tesco.hackathon.model.Cart;


import java.util.List;

public interface ProductRepositoryCustom {


    public void insertToCart(int cartId, String itemDesc);

    public List<Cart> getCartItems(int cartId);

}
