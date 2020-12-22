package com.epam.homework.service;

import com.epam.homework.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto productDto);
    ProductDto get(Integer id);

    List<ProductDto> getAll();

    ProductDto update(ProductDto productDto);
    void delete(Integer id);

}
