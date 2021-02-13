package com.epam.hibernate.service;

import com.epam.hibernate.assembler.SubTypeAssembler;
import com.epam.hibernate.dao.ProductDao;
import com.epam.hibernate.dao.SubTypeDao;
import com.epam.hibernate.dto.SubTypeDto;
import com.epam.hibernate.entity.SubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SubTypeServiceImpl implements SubTypeService {

    private final SubTypeAssembler subTypeAssembler;

    private final SubTypeDao subTypeDao;

    private final ProductDao productDao;

    @Autowired
    public SubTypeServiceImpl(SubTypeAssembler subTypeAssembler, SubTypeDao subTypeDao,
                              ProductDao productDao) {
        this.subTypeAssembler = subTypeAssembler;
        this.subTypeDao = subTypeDao;
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public SubTypeDto create(SubTypeDto subTypeDto) {
        SubType subType = subTypeAssembler.assemble(subTypeDto);
        subType = subTypeDao.create(subType);
        return subTypeAssembler.assemble(subType);
    }

    @Override
    @Transactional(readOnly = true)
    public SubTypeDto get(UUID id) {
        SubType subType = subTypeDao.get(id);
        return subTypeAssembler.assemble(subType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubTypeDto> getAll() {
        List<SubType> subTypeList = subTypeDao.getAll();
        List<SubTypeDto> subTypeDtoList = new ArrayList<>(subTypeList.size());
        for (SubType subType : subTypeList) {
            subTypeDtoList.add(subTypeAssembler.assemble(subType));
        }
        return subTypeDtoList;
    }

    @Override
    @Transactional
    public SubTypeDto update(SubTypeDto subTypeDto) {
        SubType subType = subTypeDao.get(subTypeDto.getId());
        SubType updateSubType = subTypeAssembler.assemble(subTypeDto);

        subType.setId(updateSubType.getId());
        subType.setName(updateSubType.getName());
        subType.setType(updateSubType.getType());
        subType.setProductList(updateSubType.getProductList());

        return subTypeAssembler.assemble(subType);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        subTypeDao.delete(id);
    }
}
