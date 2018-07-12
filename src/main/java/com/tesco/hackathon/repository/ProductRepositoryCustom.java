package com.tesco.hackathon.repository;

import com.tesco.hackathon.model.Cart;
import com.tesco.hackathon.model.CartDTO;


import java.util.List;
import java.util.Set;

public interface ProductRepositoryCustom {


    public void insertToCart(int cartId, String itemDesc);

    public Set<CartDTO> getCartItems(int cartId);

}
