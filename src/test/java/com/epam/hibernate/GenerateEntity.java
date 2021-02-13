package com.epam.hibernate;

import com.epam.hibernate.dto.ProductDto;
import com.epam.hibernate.dto.SubTypeDto;
import com.epam.hibernate.dto.TypeDto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.UUID;

public class GenerateEntity {

    public static TypeDto createTypeDto(String name){
        TypeDto typeDto = new TypeDto();
        typeDto.setName(name);

        return typeDto;
    }

    public static SubTypeDto createSubTypeDto(String name){
        SubTypeDto subTypeDto = new SubTypeDto();
        subTypeDto.setName(name);
        subTypeDto.setTypeId(UUID.randomUUID());
        subTypeDto.setProductList(Arrays.asList(createProductDto(RandomStringUtils.randomAlphabetic(15)),
                createProductDto(RandomStringUtils.randomAlphabetic(15))));

        return subTypeDto;
    }

    public static ProductDto createProductDto(String name) {
        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        productDto.setPrice(1200f);
        productDto.setBrand("BrandTest");
        productDto.setCount(4);
        productDto.setSubTypeId(UUID.randomUUID());

        return productDto;
    }
}
