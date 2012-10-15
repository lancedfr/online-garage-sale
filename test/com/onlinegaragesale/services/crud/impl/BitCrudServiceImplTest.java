package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.services.crud.BidCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
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
public class BitCrudServiceImplTest
{

    private static Facade facade;
    private static UseraccountCrudService useraccountCrudService;
    private static ProductCrudService productCrudService;
    private static BidCrudService bidCrudService;

    public BitCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        useraccountCrudService = facade.getUseraccountCrudService();
        productCrudService = facade.getProductCrudService();
        bidCrudService = facade.getBidCrudService();
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
    public void testBidCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("bidAmount", "55.99");
        values.put("prodId", productCrudService.findById(new BigDecimal(1)));
        values.put("userId", useraccountCrudService.findById(new BigDecimal(20124004)).getUserid());
        Bid bid = AppFactory.createBid(values);

        bidCrudService.persist(bid);
        Bid b = bidCrudService.findById(new BigDecimal(1));
        Assert.assertNotNull(b);
    }
}
