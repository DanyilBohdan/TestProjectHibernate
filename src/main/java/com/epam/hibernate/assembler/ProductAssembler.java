package com.epam.hibernate.assembler;

import com.epam.hibernate.dto.ProductDto;
import com.epam.hibernate.entity.Product;

public interface ProductAssembler {

    Product assemble(ProductDto productDto);

    ProductDto assemble(Product product);
}
