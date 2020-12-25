package com.epam.homework.assembler;

import com.epam.homework.dto.ProductDto;
import com.epam.homework.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductAssemblerImpl implements ProductAssembler {


    @Override
    public Product assemble(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCount(productDto.getCount());
        product.setBrand(productDto.getBrand());

        return product;
    }

    @Override
    public ProductDto assemble(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCount(product.getCount());
        productDto.setBrand(product.getBrand());

        return productDto;
    }
}
