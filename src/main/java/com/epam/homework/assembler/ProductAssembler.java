package com.epam.homework.assembler;

import com.epam.homework.dto.ProductDto;
import com.epam.homework.entity.Product;

public interface ProductAssembler {

    Product assemble(ProductDto productDto);

    ProductDto assemble(Product product);
}
