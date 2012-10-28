package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.math.BigDecimal;
import java.util.Date;
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
public class GarageCrudServiceImplTest
{

    private static Facade facade;
    private static UseraccountCrudService useraccountCrudService;
    private static GarageCrudService garageCrudService;
    private BigDecimal garageid;

    public GarageCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        useraccountCrudService = facade.getUseraccountCrudService();
        garageCrudService = facade.getGarageCrudService();
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
    public void testGarageCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("closeDate", new Date());
        values.put("garageType", "small");
        values.put("openDate", new Date());
        values.put("userId", useraccountCrudService.findById(new BigDecimal(20124031)));
        Garage garage = AppFactory.createGarage(values);

        garageCrudService.persist(garage);
        garageid = garage.getGarageid();
        Assert.assertNotNull(garage);

//        garageCrudService.removeById(new Long(1));
//        Garage g = garageCrudService.findById(new Long(1));
//        Assert.assertNull(g);
    }
}
