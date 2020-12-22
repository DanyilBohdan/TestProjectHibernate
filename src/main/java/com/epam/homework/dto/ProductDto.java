package com.epam.homework.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;

    private String name;

    private Float price;

    private Integer count;

    private String brand;

    private Integer subTypeId;
}
