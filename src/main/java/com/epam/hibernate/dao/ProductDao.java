package com.epam.hibernate.dao;

import com.epam.hibernate.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {

    Product create(Product product);

    List<Product> getAll();

    List<Product> getByIds(List<UUID> ids);

    Product get(UUID id);

    void delete(UUID id);
}
