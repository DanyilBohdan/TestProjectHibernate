package com.epam.homework.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TypeDto {

    private Integer id;

    private String name;

    private List<SubTypeDto> subTypeDtoList = new ArrayList<>();
}
