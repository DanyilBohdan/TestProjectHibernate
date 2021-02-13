package com.epam.hibernate.assembler;

import com.epam.hibernate.dto.TypeDto;
import com.epam.hibernate.entity.Type;

public interface TypeAssembler {

    Type assemble(TypeDto typeDto);

    TypeDto assemble(Type type);
}
