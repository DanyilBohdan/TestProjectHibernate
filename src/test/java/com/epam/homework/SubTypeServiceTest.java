package com.epam.homework;

import com.epam.homework.cfg.HibernateConfiguration;
import com.epam.homework.dto.SubTypeDto;
import com.epam.homework.entity.Product;
import com.epam.homework.service.SubTypeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.epam.homework.GenerateEntity.createSubTypeDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
public class SubTypeServiceTest {

    @Autowired
    private SubTypeService subTypeService;

    @Test
    public void getAll() {
        System.out.println(subTypeService.getAll());
    }

    @Test
    @Transactional
    public void createSubTestTest() {
        SubTypeDto subTypeDto = createSubTypeDto(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto createdSubTypeDto = subTypeService.create(subTypeDto);
        Assert.assertEquals(subTypeDto.getName(), createdSubTypeDto.getName());
    }

    @Test
    public void deleteProductTest() {
        SubTypeDto subTypeDto = createSubTypeDto(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto createdSubTypeDto = subTypeService.create(subTypeDto);
        List<SubTypeDto> subTypeDtoList = subTypeService.getAll();
        subTypeService.delete(createdSubTypeDto.getId());
        List<SubTypeDto> expectedSubTypeDtoList = subTypeService.getAll();
        Assert.assertEquals(expectedSubTypeDtoList.size(), subTypeDtoList.size() - 1);
    }

    @Test
    @Transactional
    public void updateProductTest() {
        SubTypeDto subTypeDto = createSubTypeDto(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto createdSubTypeDto = subTypeService.create(subTypeDto);
        createdSubTypeDto.setName(RandomStringUtils.randomAlphabetic(15));
        SubTypeDto updatedSubTypeDto = subTypeService.update(createdSubTypeDto);
        subTypeDto = subTypeService.get(updatedSubTypeDto.getId());
        Assert.assertEquals(subTypeDto.getName(), updatedSubTypeDto.getName());
    }
}
