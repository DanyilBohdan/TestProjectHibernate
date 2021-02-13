package com.epam.hibernate.service;

import com.epam.hibernate.dto.TypeDto;

import java.util.List;
import java.util.UUID;

public interface TypeService {

    TypeDto create(TypeDto typeDto);
    TypeDto get(UUID id);

    List<TypeDto> getAll();

    TypeDto update(TypeDto typeDto);
    void delete(UUID id);
}
