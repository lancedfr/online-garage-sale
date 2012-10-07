package com.onlinegaragesale.services;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.services.crud.BidCrudService;
import java.math.BigDecimal;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * File Name: AcceptBidTest.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services
 * Author: Lance
 * Date: 22 Sep 2012
 * Edited: 22 Sep 2012
 */
public class AcceptBidTest
{

    private static Facade facade;
    private static AcceptBidService acceptBidService;
    private static BidCrudService bidCrudService;

    public AcceptBidTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        acceptBidService = facade.getAcceptBidService();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void acceptBidTestTest()
    {
        Bid bid = bidCrudService.findById(new BigDecimal("6"));
        acceptBidService.acceptBid(bid);
        Bid findById = bidCrudService.findById(new BigDecimal("5"));
        Character bidstatus = findById.getBidstatus();
        Assert.assertEquals('0', bidstatus.charValue());
    }
}