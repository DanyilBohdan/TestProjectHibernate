package com.epam.homework.dao;

import com.epam.homework.entity.Type;

import java.util.List;

public interface TypeDao {

    Type create(Type type);

    List<Type> getAll();

    List<Type> getByIds(List<Integer> ids);

    Type get(Integer id);

    void delete(Integer id);
}
