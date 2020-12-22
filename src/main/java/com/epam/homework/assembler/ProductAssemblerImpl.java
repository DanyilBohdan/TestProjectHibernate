package com.epam.homework.assembler;

import com.epam.homework.dao.SubTypeDao;
import com.epam.homework.dto.ProductDto;
import com.epam.homework.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAssemblerImpl implements ProductAssembler {

    private final SubTypeDao subTypeDao;

    @Autowired
    public ProductAssemblerImpl(SubTypeDao subTypeDao) {
        this.subTypeDao = subTypeDao;
    }

    @Override
    public Product assemble(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCount(productDto.getCount());
        product.setBrand(productDto.getBrand());

        product.setSubType(subTypeDao.get(productDto.getSubTypeId()));

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

        productDto.setSubTypeId(product.getSubType().getId());

        return productDto;
    }
}
