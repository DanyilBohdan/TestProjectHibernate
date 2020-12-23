package com.epam.homework.service;

import com.epam.homework.assembler.SubTypeAssembler;
import com.epam.homework.dao.ProductDao;
import com.epam.homework.dao.SubTypeDao;
import com.epam.homework.dto.ProductDto;
import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.entity.Product;
import com.epam.homework.entity.SubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public SubTypeDto create(SubTypeDto subTypeDto) {
        SubType subType = subTypeAssembler.assemble(subTypeDto);
        subType = subTypeDao.create(subType);
        return subTypeAssembler.assemble(subType);
    }

    @Override
    @Transactional(readOnly = true)
    public SubTypeDto get(Integer id) {
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
    public SubTypeDto update(SubTypeDto subTypeDto) {
        SubType subType = subTypeDao.get(subTypeDto.getId());
        SubType updateSubType = subTypeAssembler.assemble(subTypeDto);

        for (Product product : subType.getProductList()) {
            productDao.delete(product.getId());
        }
        subTypeDao.delete(subType.getId());

        subType.setId(updateSubType.getId());
        subType.setName(updateSubType.getName());
        subType.setType(updateSubType.getType());
        subType.setProductList(updateSubType.getProductList());

        subType = subTypeDao.create(subType);

        return subTypeAssembler.assemble(subType);
    }

    @Override
    public void delete(Integer id) {
        subTypeDao.delete(id);
    }
}
