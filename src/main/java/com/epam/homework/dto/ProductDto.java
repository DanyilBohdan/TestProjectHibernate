package com.epam.homework.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDto {

    private UUID id;

    private String name;

    private Float price;

    private Integer count;

    private String brand;

    private UUID subTypeId;
}
