package com.epam.hibernate.assembler;

import com.epam.hibernate.dto.TypeDto;
import com.epam.hibernate.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return type;
    }

    @Override
    public TypeDto assemble(Type type) {
        TypeDto typeDto = new TypeDto();
        typeDto.setId(type.getId());
        typeDto.setName(type.getName());

        return typeDto;
    }
}
