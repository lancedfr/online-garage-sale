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
    public void getUserProductsTest()
    {
        List<Product> userProducts = getProductsService.userProducts(BigDecimal.valueOf(20124001));
        Assert.assertEquals(3, userProducts.size());

        Useraccount useraccount = useraccountCrudService.findById(BigDecimal.valueOf(20124001));
        List<Product> userProducts2 = getProductsService.userProducts(useraccount);
        Assert.assertEquals(3, userProducts2.size());
    }

    @Test
    public void getUsersBidsTest()
    {
        List<Product> usersBids = getProductsService.usersBids(BigDecimal.valueOf(20124003));
        Assert.assertEquals(4, usersBids.size());

        Useraccount useraccount = useraccountCrudService.findById(BigDecimal.valueOf(20124003));
        List<Product> usersBids2 = getProductsService.usersBids(useraccount);
        Assert.assertEquals(4, usersBids2.size());
    }

    @Test
    public void getProductsToBuyTest()
    {
        List<Product> productsToBuy = getProductsService.productsToBuy(BigDecimal.valueOf(20124001));
        Assert.assertEquals(1, productsToBuy.size());

        Useraccount useraccount = useraccountCrudService.findById(BigDecimal.valueOf(20124001));
        List<Product> productsToBuy2 = getProductsService.productsToBuy(useraccount);
        Assert.assertEquals(1, productsToBuy2.size());
    }
}