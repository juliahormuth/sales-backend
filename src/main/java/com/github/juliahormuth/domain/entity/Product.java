package com.github.juliahormuth.domain.entity;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String discretion;
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscretion() {
        return discretion;
    }

    public void setDiscretion(String discretion) {
        this.discretion = discretion;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
