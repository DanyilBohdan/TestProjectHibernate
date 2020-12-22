package com.epam.homework.dao;

import com.epam.homework.entity.Product;

import java.util.List;

public interface ProductDao {

    void create(Product product);

    List<Product> getAll();

    List<Product> getByIds(List<Integer> ids);

    Product get(Integer id);

    void delete(Integer id);
}
