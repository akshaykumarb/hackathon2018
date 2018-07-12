package com.tesco.hackathon.repository;

import com.tesco.hackathon.model.Cart;
import com.tesco.hackathon.model.CartKey;
import com.tesco.hackathon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository

public class ProductRepositoryImpl implements ProductRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CartRepository cartRepository;


    @Override
    public void insertToCart(int cartId, String itemDesc) {

        String[] splitStr = itemDesc.split("\\s+");

        for (String product : splitStr) {
            List<Object[]> productList = entityManager.createQuery("select item_name, price from Product where item_description = :description").setParameter("description", product).getResultList();
            System.out.println("productList.size()......" + productList.size());
            productList.stream().forEach(row -> cartRepository.save(new Cart((String) row[0], (BigDecimal) row[1],cartId)));
        }
    }


    @Override
    public List<Cart> getCartItems(int cartId) {


            List<Cart> cartList = entityManager.createQuery("select * from Cart where cart_id = :description").setParameter("description", cartId).getResultList();
            System.out.println("productList.size()......" + cartList.size());
           // productList.stream().forEach(row -> cartRepository.save(new Cart((String) row[0], (BigDecimal) row[1],cartId)));
        return  cartList;

    }


}
