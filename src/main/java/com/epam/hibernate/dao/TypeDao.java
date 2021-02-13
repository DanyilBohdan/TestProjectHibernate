package com.epam.hibernate.dao;

import com.epam.hibernate.entity.Type;

import java.util.List;
import java.util.UUID;

public interface TypeDao {

    Type create(Type type);

    List<Type> getAll();

    List<Type> getByIds(List<UUID> ids);

    Type get(UUID id);

    void delete(UUID id);
}
