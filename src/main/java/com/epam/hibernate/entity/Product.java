package com.epam.hibernate.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @Column(length = 16)
    @GeneratedValue
    private UUID id;

    private String name;

    private Float price;

    private Integer count;

    private String brand;

    @ManyToOne
    private SubType subType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }
}
