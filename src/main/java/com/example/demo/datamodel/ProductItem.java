package com.example.demo.datamodel;

import java.time.LocalDate;

public class ProductItem {

    private String name;
    private String details;

    private String price;
    private int quantity;


    public ProductItem(String name, String details, String price, int quantity) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
