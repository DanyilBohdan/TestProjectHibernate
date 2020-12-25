package com.epam.homework.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class SubTypeDto {

    private UUID id;

    private String name;

    private UUID typeId;

    private List<ProductDto> productList = new ArrayList<>();
}
