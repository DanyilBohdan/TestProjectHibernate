package com.epam.homework.service;

import com.epam.homework.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto create(ProductDto productDto);

    ProductDto get(UUID id);

    List<ProductDto> getAll();

    ProductDto update(ProductDto productDto);

    void delete(UUID id);

}
