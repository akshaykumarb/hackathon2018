package com.tesco.hackathon.repository;

import com.tesco.hackathon.model.Cart;
import com.tesco.hackathon.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository

public class ProductRepositoryImpl implements ProductRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Cart getProduct(String description) {

//        Query query = entityManager.createQuery("SELECT em.item_name FROM product_details as em WHERE em.item_description= ?", Product.class);
//        query.setParameter(1, description);
//        return (Cart) query.getParameterValue("item_name");


        return (Cart) entityManager.createQuery("select item_name, price from Product where item_description = :description").setParameter("description", description)
                .getSingleResult();

    }
}
