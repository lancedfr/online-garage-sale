package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.services.crud.CategoryCrudService;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
import java.math.BigDecimal;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * File Name: StudentCrudServiceImplTest.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class ProductCrudServiceImplTest
{

    private static Facade facade;
    private static GarageCrudService garageCrudService;
    private static ProductCrudService productCrudService;
    private static CategoryCrudService categoryCrudService;

    public ProductCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        garageCrudService = facade.getGarageCrudService();
        productCrudService = facade.getProductCrudService();
        categoryCrudService = facade.getCategoryCrudService();
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testProductCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("garageId", garageCrudService.findById(new BigDecimal(4)));
        values.put("prodCondition", "GREAT");
        values.put("prodDesc", "Green Lamp");
        values.put("prodPrice", "234.66");
        values.put("prodStatus", "Not Sold");
        values.put("categoryId", categoryCrudService.findById(new BigDecimal(5)));
        Product product = AppFactory.createProduct(values);
        
        productCrudService.persist(product);
        Product p = productCrudService.findById(new BigDecimal(6));
        Assert.assertNotNull(p);
    }
}
