package com.epam.hibernate;

import com.epam.hibernate.cfg.HibernateConfiguration;
import com.epam.hibernate.dto.SubTypeDto;
import com.epam.hibernate.service.SubTypeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.epam.hibernate.GenerateEntity.createSubTypeDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
public class SubTypeServiceTest {

    @Autowired
    private SubTypeService subTypeService;

    private List<SubTypeDto> subTypeDtoList = new ArrayList<>();

    @Before
    public void init(){
        subTypeDtoList = Arrays.asList(
                createSubTypeDto(RandomStringUtils.randomAlphabetic(15)),
                createSubTypeDto(RandomStringUtils.randomAlphabetic(15)),
                createSubTypeDto(RandomStringUtils.randomAlphabetic(15)),
                createSubTypeDto(RandomStringUtils.randomAlphabetic(15))
        );
    }

    @Test
    @Transactional
    public void getAll() {
        for (SubTypeDto subTypeDto : subTypeDtoList) {
            subTypeService.create(subTypeDto);
        }
        List<SubTypeDto> actualList = subTypeService.getAll();

        subTypeDtoList.sort(Comparator.comparing(SubTypeDto::getName));

        actualList.sort(Comparator.comparing(SubTypeDto::getName));

        for (int i = 0; i < subTypeDtoList.size(); i++) {
            Assert.assertEquals(subTypeDtoList.get(i).getName(), actualList.get(i).getName());
        }
    }

    @Test
    @Transactional
    public void createSubTypeTest() {
        SubTypeDto subTypeDto = createSubTypeDto(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto createdSubTypeDto = subTypeService.create(subTypeDto);
        Assert.assertEquals(subTypeDto.getName(), createdSubTypeDto.getName());
    }

    @Test
    @Transactional
    public void deleteSubTypeTest() {
        SubTypeDto subTypeDto = createSubTypeDto(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto createdSubTypeDto = subTypeService.create(subTypeDto);
        List<SubTypeDto> subTypeDtoList = subTypeService.getAll();
        subTypeService.delete(createdSubTypeDto.getId());
        List<SubTypeDto> expectedSubTypeDtoList = subTypeService.getAll();
        Assert.assertEquals(expectedSubTypeDtoList.size(), subTypeDtoList.size() - 1);
    }

    @Test
    @Transactional
    public void updateSubTypeTest() {
        SubTypeDto subTypeDto = createSubTypeDto(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto createdSubTypeDto = subTypeService.create(subTypeDto);
        createdSubTypeDto.setName(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto updatedSubTypeDto = subTypeService.update(createdSubTypeDto);
        subTypeDto = subTypeService.get(createdSubTypeDto.getId());
        Assert.assertEquals(subTypeDto.getName(), updatedSubTypeDto.getName());
    }
}
