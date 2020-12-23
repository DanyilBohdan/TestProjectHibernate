package com.epam.homework.assembler;

import com.epam.homework.dao.TypeDao;
import com.epam.homework.dto.ProductDto;
import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.entity.Product;
import com.epam.homework.entity.SubType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTypeAssemblerImpl implements SubTypeAssembler {

    private final TypeDao typeDao;
    private final ProductAssembler productAssembler;

    @Autowired
    public SubTypeAssemblerImpl(TypeDao typeDao, ProductAssembler productAssembler) {
        this.typeDao = typeDao;
        this.productAssembler = productAssembler;
    }

    @Override
    public SubType assemble(SubTypeDto subTypeDto) {
        SubType subType = new SubType();
        subType.setId(subTypeDto.getId());
        subType.setName(subTypeDto.getName());
        subType.setType(typeDao.get(subTypeDto.getTypeId()));
        List<ProductDto> productDtoList = subTypeDto.getProductList();
        List<Product> products = new ArrayList<>(productDtoList.size());
        for (ProductDto productDto : productDtoList) {
            products.add(productAssembler.assemble(productDto));
        }
        subType.setProductList(products);
        return subType;
    }

    @Override
    public SubTypeDto assemble(SubType subType) {
        SubTypeDto subTypeDto = new SubTypeDto();
        subTypeDto.setId(subType.getId());
        subTypeDto.setName(subType.getName());
        subTypeDto.setTypeId(subType.getType().getId());
        List<Product> products = subType.getProductList();
        List<ProductDto> productDtoList = new ArrayList<>(products.size());
        for (Product product : products) {
            productDtoList.add(productAssembler.assemble(product));
        }
        subTypeDto.setProductList(productDtoList);
        return subTypeDto;
    }
}
