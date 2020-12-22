package com.epam.homework;

import com.epam.homework.cfg.HibernateConfiguration;
import com.epam.homework.dao.ProductDao;
import com.epam.homework.dao.SubTypeDao;
import com.epam.homework.dao.TypeDao;
import com.epam.homework.entity.SubType;
import com.epam.homework.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private SubTypeDao subTypeDao;

    @Before
    public void init(){

    }

    @Test
    public void getAllProductTest(){
        System.out.println(typeDao.get(1));
        System.out.println(subTypeDao.get(1));
        System.out.println(productDao.get(1));
    }

}
