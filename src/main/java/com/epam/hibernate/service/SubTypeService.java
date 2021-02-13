package com.epam.hibernate.service;

import com.epam.hibernate.dto.SubTypeDto;

import java.util.List;
import java.util.UUID;

public interface SubTypeService {

    SubTypeDto create(SubTypeDto subTypeDto);

    SubTypeDto get(UUID id);

    List<SubTypeDto> getAll();

    SubTypeDto update(SubTypeDto subTypeDto);

    void delete(UUID id);
}
