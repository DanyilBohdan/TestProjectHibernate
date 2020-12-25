package com.epam.homework.service;

import com.epam.homework.assembler.ProductAssembler;
import com.epam.homework.dao.ProductDao;
import com.epam.homework.dto.ProductDto;
import com.epam.homework.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductAssembler productAssembler;
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductAssembler productAssembler, ProductDao productDao) {
        this.productAssembler = productAssembler;
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public ProductDto create(ProductDto productDto) {
        Product product = productAssembler.assemble(productDto);
        product = productDao.create(product);
        return productAssembler.assemble(product);
    }

    @Override
    @Transactional
    public ProductDto get(UUID id) {
        Product product = productDao.get(id);
        return productAssembler.assemble(product);
    }

    @Override
    @Transactional
    public List<ProductDto> getAll() {
        List<Product> productList = productDao.getAll();
        List<ProductDto> productDtoList = new ArrayList<>(productList.size());
        for (Product product : productList) {
            productDtoList.add(productAssembler.assemble(product));
        }
        return productDtoList;
    }

    @Override
    @Transactional
    public ProductDto update(ProductDto productDto) {
        Product product = productDao.get(productDto.getId());
        Product updateProduct = productAssembler.assemble(productDto);

        productDao.delete(product.getId());

        product.setId(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setCount(updateProduct.getCount());
        product.setBrand(updateProduct.getBrand());
        product.setSubType(updateProduct.getSubType());

        product = productDao.create(product);

        return productAssembler.assemble(product);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        productDao.delete(id);
    }
}
