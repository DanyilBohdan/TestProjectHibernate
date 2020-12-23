package com.epam.homework;

import com.epam.homework.dto.ProductDto;
import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.dto.TypeDto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

public class GenerateEntity {

    public static TypeDto createTypeDto(String name){
        TypeDto typeDto = new TypeDto();
        typeDto.setName(name);
        typeDto.setSubTypeDtoList(Arrays.asList(createSubTypeDto(RandomStringUtils.randomAlphabetic(15)),
                createSubTypeDto(RandomStringUtils.randomAlphabetic(15))));

        return typeDto;
    }

    public static SubTypeDto createSubTypeDto(String name){
        SubTypeDto subTypeDto = new SubTypeDto();
        subTypeDto.setName(name);
        subTypeDto.setTypeId(1);
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
        productDto.setSubTypeId(1);

        return productDto;
    }
}
