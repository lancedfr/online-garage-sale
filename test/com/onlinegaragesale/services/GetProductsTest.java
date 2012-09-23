package com.onlinegaragesale.services;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * File Name: GetProductsTest.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services
 * Author: Lance
 * Date: 23 Sep 2012
 * Edited: 23 Sep 2012
 */
public class GetProductsTest 
{
    private static Facade facade;
    private static GetProductsService getProductsService;
    private static UseraccountCrudService useraccountCrudService;

    public GetProductsTest() 
    {
    }

    @BeforeClass
    public static void setUpClass() 
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        getProductsService = facade.getGetProductsService();
        useraccountCrudService = facade.getUseraccountCrudService();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void GetProductsUserProductsTest() 
    {
        List<Product> userProducts = getProductsService.userProducts(new Useraccount(BigDecimal.valueOf(20124001)));
        Assert.assertEquals(3, userProducts.size());
    }
    
    @Test
    public void GetProductsUsersBidsTest() 
    {
        List<Product> usersBids = getProductsService.usersBids(new Useraccount(BigDecimal.valueOf(20124003)));
        Assert.assertEquals(4, usersBids.size());
    }
}