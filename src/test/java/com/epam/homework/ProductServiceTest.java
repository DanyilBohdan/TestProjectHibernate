package com.epam.homework;

import com.epam.homework.cfg.HibernateConfiguration;
import com.epam.homework.dto.ProductDto;
import com.epam.homework.service.ProductService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.epam.homework.GenerateEntity.createProductDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void getAllProductTest() {
        System.out.println(productService.getAll());
    }

    @Test
    @Transactional
    public void createProductTest() {
        ProductDto productDto = createProductDto(RandomStringUtils.randomAlphabetic(15));
        ProductDto createdProduct = productService.create(productDto);
        Assert.assertEquals(productDto.getName(), createdProduct.getName());
    }

    @Test
    public void deleteProductTest() {
        ProductDto productDto = createProductDto(RandomStringUtils.randomAlphabetic(15));
        ProductDto createdProduct = productService.create(productDto);
        List<ProductDto> productDtoList = productService.getAll();
        productService.delete(createdProduct.getId());
        List<ProductDto> expectedProductDtoList = productService.getAll();
        Assert.assertEquals(expectedProductDtoList.size(), productDtoList.size() - 1);
    }

    @Test
    @Transactional
    public void updateProductTest() {
        ProductDto productDto = createProductDto(RandomStringUtils.randomAlphabetic(15));
        ProductDto createdProduct = productService.create(productDto);
        createdProduct.setCount(createdProduct.getCount() + 10);
        ProductDto updateProduct = productService.update(createdProduct);
        productDto = productService.get(updateProduct.getId());
        Assert.assertEquals(productDto.getCount(), updateProduct.getCount());
    }

}
