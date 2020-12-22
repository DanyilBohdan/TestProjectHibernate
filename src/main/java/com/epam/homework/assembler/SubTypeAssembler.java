package com.epam.homework.assembler;

import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.entity.SubType;

public interface SubTypeAssembler {
    SubType assemble(SubTypeDto subTypeDto);

    SubTypeDto assemble(SubType subType);
}
