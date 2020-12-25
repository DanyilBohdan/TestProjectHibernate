package com.epam.homework.service;

import com.epam.homework.dto.SubTypeDto;

import java.util.List;
import java.util.UUID;

public interface SubTypeService {

    SubTypeDto create(SubTypeDto subTypeDto);

    SubTypeDto get(UUID id);

    List<SubTypeDto> getAll();

    SubTypeDto update(SubTypeDto subTypeDto);

    void delete(UUID id);
}
