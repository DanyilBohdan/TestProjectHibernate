package com.epam.homework.assembler;

import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.dto.TypeDto;
import com.epam.homework.entity.SubType;
import com.epam.homework.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeAssemblerImpl implements TypeAssembler {

    private final SubTypeAssembler subTypeAssembler;

    @Autowired
    public TypeAssemblerImpl(SubTypeAssembler subTypeAssembler) {
        this.subTypeAssembler = subTypeAssembler;
    }

    @Override
    public Type assemble(TypeDto typeDto) {
        Type type = new Type();
        type.setId(typeDto.getId());
        type.setName(typeDto.getName());

        List<SubTypeDto> subTypeDtoList = typeDto.getSubTypeDtoList();
        List<SubType> subTypeList = new ArrayList<>(subTypeDtoList.size());
        for (SubTypeDto subTypeDto : subTypeDtoList) {
            subTypeList.add(subTypeAssembler.assemble(subTypeDto));
        }
        type.setSubTypes(subTypeList);
        return type;
    }

    @Override
    public TypeDto assemble(Type type) {
        TypeDto typeDto = new TypeDto();
        typeDto.setId(type.getId());
        typeDto.setName(type.getName());

        List<SubType> subTypeList = type.getSubTypes();
        List<SubTypeDto> subTypeDtoList = new ArrayList<>(subTypeList.size());
        for (SubType subType : subTypeList){
            subTypeDtoList.add(subTypeAssembler.assemble(subType));
        }
        typeDto.setSubTypeDtoList(subTypeDtoList);
        return typeDto;
    }
}
