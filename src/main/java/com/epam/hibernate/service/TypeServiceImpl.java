package com.epam.hibernate.service;

import com.epam.hibernate.assembler.TypeAssembler;
import com.epam.hibernate.dao.TypeDao;
import com.epam.hibernate.dto.TypeDto;
import com.epam.hibernate.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @Transactional
    public TypeDto create(TypeDto typeDto) {
        Type type = typeAssembler.assemble(typeDto);
        type = typeDao.create(type);
        return typeAssembler.assemble(type);
    }

    @Override
    @Transactional
    public TypeDto get(UUID id) {
        return typeAssembler.assemble(typeDao.get(id));
    }

    @Override
    @Transactional
    public List<TypeDto> getAll() {
        List<Type> typeList = typeDao.getAll();
        List<TypeDto> typeDtoList = new ArrayList<>(typeList.size());
        for (Type type : typeList) {
            typeDtoList.add(typeAssembler.assemble(type));
        }
        return typeDtoList;
    }

    @Override
    @Transactional
    public TypeDto update(TypeDto typeDto) {
        Type type = typeDao.get(typeDto.getId());
        Type updateType = typeAssembler.assemble(typeDto);

        type.setId(updateType.getId());
        type.setName(updateType.getName());

        return typeAssembler.assemble(type);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        typeDao.delete(id);
    }
}
