package com.tesco.hackathon.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartDTO implements Serializable {
    private String item_name;

    private BigDecimal price;

    private int  cart_id;

    private String item_description;

    public CartDTO(String item_name, BigDecimal price, int cart_id, String item_description) {
        this.item_name = item_name;
        this.price = price;
        this.cart_id = cart_id;
        this.item_description = item_description;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    @Override
    public boolean equals(Object obj) {
        CartDTO dto = (CartDTO) obj;
        return item_name.equals(((CartDTO) obj).getItem_name());
    }

    @Override
    public int hashCode() {
        return item_name.toLowerCase().hashCode();
    }
}
