package com.epam.homework.dao;

import com.epam.homework.entity.SubType;

import java.util.List;

public interface SubTypeDao {

    SubType create(SubType subType);

    List<SubType> getAll();

    List<SubType> getByIds(List<Integer> ids);

    SubType get(Integer id);

    void delete(Integer id);
}
