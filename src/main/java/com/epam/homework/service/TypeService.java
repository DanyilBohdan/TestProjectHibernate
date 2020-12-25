package com.epam.homework.service;

import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.dto.TypeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface TypeService {

    TypeDto create(TypeDto typeDto);
    TypeDto get(UUID id);

    List<TypeDto> getAll();

    TypeDto update(TypeDto typeDto);
    void delete(UUID id);
}
