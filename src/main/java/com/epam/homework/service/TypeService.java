package com.epam.homework.service;

import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.dto.TypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypeService {

    TypeDto create(TypeDto typeDto);
    TypeDto get(Integer id);

    List<TypeDto> getAll();

    TypeDto update(TypeDto typeDto);
    void delete(Integer id);
}
