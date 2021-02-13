package com.epam.hibernate.assembler;

import com.epam.hibernate.dto.SubTypeDto;
import com.epam.hibernate.entity.SubType;

public interface SubTypeAssembler {
    SubType assemble(SubTypeDto subTypeDto);

    SubTypeDto assemble(SubType subType);
}
