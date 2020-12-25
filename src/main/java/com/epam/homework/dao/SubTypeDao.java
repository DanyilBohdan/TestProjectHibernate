package com.epam.homework.dao;

import com.epam.homework.entity.SubType;

import java.util.List;
import java.util.UUID;

public interface SubTypeDao {

    SubType create(SubType subType);

    List<SubType> getAll();

    List<SubType> getByIds(List<UUID> ids);

    SubType get(UUID id);

    void delete(UUID id);
}
