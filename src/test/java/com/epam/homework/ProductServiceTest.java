package com.epam.homework;

import com.epam.homework.cfg.HibernateConfiguration;
import com.epam.homework.dto.ProductDto;
import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.service.ProductService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.epam.homework.GenerateEntity.createProductDto;
import static com.epam.homework.GenerateEntity.createSubTypeDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private List<ProductDto> productDtoList = new ArrayList<>();

    @Before
    public void init(){
        productDtoList = Arrays.asList(
                createProductDto(RandomStringUtils.randomAlphabetic(15)),
                createProductDto(RandomStringUtils.randomAlphabetic(15)),
                createProductDto(RandomStringUtils.randomAlphabetic(15)),
                createProductDto(RandomStringUtils.randomAlphabetic(15))
        );
    }

    @Test
    @Transactional
    public void getAllProductTest() {
        for (ProductDto productDto : productDtoList) {
            productService.create(productDto);
        }
        List<ProductDto> actualList = productService.getAll();

        productDtoList.sort(Comparator.comparing(ProductDto::getName));

        actualList.sort(Comparator.comparing(ProductDto::getName));

        for (int i = 0; i < productDtoList.size(); i++) {
            Assert.assertEquals(productDtoList.get(i).getName(), actualList.get(i).getName());
            Assert.assertEquals(productDtoList.get(i).getPrice(), actualList.get(i).getPrice());
            Assert.assertEquals(productDtoList.get(i).getCount(), actualList.get(i).getCount());
            Assert.assertEquals(productDtoList.get(i).getBrand(), actualList.get(i).getBrand());
        }
    }

    @Test
    @Transactional
    public void createProductTest() {
        ProductDto productDto = createProductDto(RandomStringUtils.randomAlphabetic(15));
        ProductDto createdProduct = productService.create(productDto);
        Assert.assertEquals(productDto.getName(), createdProduct.getName());
        Assert.assertEquals(productDto.getPrice(), createdProduct.getPrice());
        Assert.assertEquals(productDto.getCount(), createdProduct.getCount());
        Assert.assertEquals(productDto.getBrand(), createdProduct.getBrand());
    }

    @Test
    @Transactional
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
