package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Useraccount;
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
public class UseraccountCrudServiceImplTest
{

    private BigDecimal userID;
    private static Facade facade;
    private static UseraccountCrudService useraccountCrudService;

    public UseraccountCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
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

    @Test
    public void testUseraccountCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("age", "22");
        values.put("dob", new Date());
        values.put("firstName", "TestFName");
        values.put("lastName", "TestLName");
        values.put("middleName", "TestMName");
        values.put("pasword", "user");
        values.put("address", "TestAddress");
        values.put("areacode", "TestAddressLine");
        values.put("city", "TestCity");
        values.put("country", "TestCountry");
        values.put("road", "TestRoad");
        values.put("suberb", "TestSuberb");
        values.put("cell", "TestCell");
        values.put("email", "user");
        values.put("homeTell", "TestHomeTell");
        values.put("workTell", "TestWorkTell");

        Useraccount useraccount = AppFactory.createUserAccount(values);

        useraccountCrudService.persist(useraccount);
        userID = useraccount.getUserid();
        Assert.assertNotNull(useraccount);
        //useraccountCrudService.removeById(userID);
        //useraccount = useraccountCrudService.findById(userID);
        //Assert.assertNull(useraccount);
    }
}
