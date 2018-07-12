package com.tesco.hackathon.repository;

import com.tesco.hackathon.model.Cart;
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
    public List<Cart> getProduct(String description) {






        List<Object[]> productList = entityManager.createQuery("select item_name, price from Product where item_description = :description").setParameter("description", description).getResultList();
        List<Cart> result = new ArrayList<>(productList.size());
        //System.out.println("productList.size()>>> "+productList.size());
        for (Object[] row : productList) {
            result.add(new Cart((String) row[1], (BigDecimal) row[2]));
        }

        return result;



    }

    @Override
    public void insertToCart(String description) {

        List<Object[]> productList = entityManager.createQuery("select item_name, price from Product where item_description = :description").setParameter("description", description).getResultList();
        System.out.println("productList.size()......"+productList.size());
        productList.stream().forEach( row -> cartRepository.save(new Cart((String) row[0], (BigDecimal) row[1])));

    }
}
