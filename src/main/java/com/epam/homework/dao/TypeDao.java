package com.epam.homework.dao;

import com.epam.homework.entity.Type;

import java.util.List;
import java.util.UUID;

public interface TypeDao {

    Type create(Type type);

    List<Type> getAll();

    List<Type> getByIds(List<UUID> ids);

    Type get(UUID id);

    void delete(UUID id);
}
