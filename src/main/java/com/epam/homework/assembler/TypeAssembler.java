package com.epam.homework.assembler;

import com.epam.homework.dto.TypeDto;
import com.epam.homework.entity.Type;

public interface TypeAssembler {

    Type assemble(TypeDto typeDto);

    TypeDto assemble(Type type);
}
