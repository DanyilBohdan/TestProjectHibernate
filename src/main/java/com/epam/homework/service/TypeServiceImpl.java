package com.epam.homework.service;

import com.epam.homework.assembler.TypeAssembler;
import com.epam.homework.dao.TypeDao;
import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.dto.TypeDto;
import com.epam.homework.entity.SubType;
import com.epam.homework.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    private final TypeAssembler typeAssembler;
    
    private final TypeDao typeDao;

    @Autowired
    public TypeServiceImpl(TypeAssembler typeAssembler, TypeDao typeDao) {
        this.typeAssembler = typeAssembler;
        this.typeDao = typeDao;
    }

    @Override
    public TypeDto create(TypeDto typeDto) {
        Type type = typeAssembler.assemble(typeDto);
        type = typeDao.create(type);
        return typeAssembler.assemble(type);
    }

    @Override
    @Transactional
    public TypeDto get(Integer id) {
        return typeAssembler.assemble(typeDao.get(id));
    }

    @Override
    @Transactional
    public List<TypeDto> getAll() {
        List<Type> typeList = typeDao.getAll();
        List<TypeDto> typeDtoList = new ArrayList<>(typeList.size());
        for (Type subType : typeList) {
            typeDtoList.add(typeAssembler.assemble(subType));
        }
        return typeDtoList;
    }

    @Override
    public TypeDto update(TypeDto typeDto) {
        Type type = typeDao.get(typeDto.getId());
        Type updateType = typeAssembler.assemble(typeDto);

        typeDao.delete(type.getId());

        type.setId(updateType.getId());
        type.setName(updateType.getName());
        type.setSubTypes(updateType.getSubTypes());

        type = typeDao.create(type);

        return typeAssembler.assemble(type);
    }

    @Override
    public void delete(Integer id) {
        typeDao.delete(id);
    }
}
