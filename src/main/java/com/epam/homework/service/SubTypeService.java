package com.epam.homework.service;

import com.epam.homework.dto.ProductDto;
import com.epam.homework.dto.SubTypeDto;

import java.util.List;

public interface SubTypeService {

    SubTypeDto create(SubTypeDto subTypeDto);
    SubTypeDto get(Integer id);

    List<SubTypeDto> getAll();

    SubTypeDto update(SubTypeDto subTypeDto);
    void delete(Integer id);
}
