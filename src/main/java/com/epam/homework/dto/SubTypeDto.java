package com.epam.homework.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubTypeDto {

    private Integer id;

    private String name;

    private Integer typeId;

    private List<ProductDto> productList = new ArrayList<>();
}
