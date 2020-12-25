package com.epam.homework;

import com.epam.homework.cfg.HibernateConfiguration;
import com.epam.homework.dto.TypeDto;
import com.epam.homework.service.TypeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.epam.homework.GenerateEntity.createTypeDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
public class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    private List<TypeDto> typeDtoList = new ArrayList<>();

    @Before
    public void init(){
        typeDtoList = Arrays.asList(
                createTypeDto(RandomStringUtils.randomAlphabetic(15)),
                createTypeDto(RandomStringUtils.randomAlphabetic(15)),
                createTypeDto(RandomStringUtils.randomAlphabetic(15)),
                createTypeDto(RandomStringUtils.randomAlphabetic(15))
        );
    }

    @Test
    @Transactional
    public void getAll() {
        for (TypeDto typeDto : typeDtoList) {
            typeService.create(typeDto);
        }
        List<TypeDto> actualList = typeService.getAll();


        typeDtoList.sort(Comparator.comparing(TypeDto::getName));

        actualList.sort(Comparator.comparing(TypeDto::getName));

        for (int i = 0; i < typeDtoList.size(); i++) {
            Assert.assertEquals(typeDtoList.get(i).getName(), actualList.get(i).getName());
        }
    }

    @Test
    @Transactional
    public void createTypeTest() {
        TypeDto typeDto = createTypeDto(RandomStringUtils.randomAlphabetic(15));
        TypeDto createdTypeDto = typeService.create(typeDto);
        Assert.assertEquals(typeDto.getName(), createdTypeDto.getName());
    }

    @Test
    @Transactional
    public void deleteTypeTest() {
        TypeDto typeDto = createTypeDto(RandomStringUtils.randomAlphabetic(15));
        TypeDto createdTypeDto = typeService.create(typeDto);
        List<TypeDto> typeDtoList = typeService.getAll();
        typeService.delete(createdTypeDto.getId());
        List<TypeDto> expectedTypeDtoList = typeService.getAll();
        Assert.assertEquals(expectedTypeDtoList.size(), typeDtoList.size() - 1);
    }

    @Test
    @Transactional
    public void updateTypeTest() {
        TypeDto typeDto = createTypeDto(RandomStringUtils.randomAlphabetic(15));
        TypeDto createdTypeDto = typeService.create(typeDto);
        createdTypeDto.setName(RandomStringUtils.randomAlphabetic(15));
        TypeDto updatedTypeDto = typeService.update(createdTypeDto);
        typeDto = typeService.get(createdTypeDto.getId());
        Assert.assertEquals(typeDto.getName(), updatedTypeDto.getName());
    }
}
