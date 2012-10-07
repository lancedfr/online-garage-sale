package com.onlinegaragesale.services;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.SaleshistoryCrudService;
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
 * File Name: CreateUserTest.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud
 * Author: Lance
 * Date: 07 Oct 2012
 * Edited: 07 Oct 2012
 */
public class CreateUserTest
{

    private BigDecimal userID;
    private BigDecimal garageid;
    private static Facade facade;
    private static UseraccountCrudService useraccountCrudService;
    private static GarageCrudService garageCrudService;
    private static SaleshistoryCrudService saleshistoryCrudService;

    public CreateUserTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        useraccountCrudService = facade.getUseraccountCrudService();
        garageCrudService = facade.getGarageCrudService();
        saleshistoryCrudService = facade.getSaleshistoryCrudService();
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
    public void createNewUserTest()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("age", "22");
        values.put("dob", new Date());
        values.put("firstName", "TestFName");
        values.put("lastName", "TestLName");
        values.put("middleName", "TestMName");
        values.put("pasword", "TestPassword");
        values.put("address", "TestAddress");
        values.put("areacode", "TestAddressLine");
        values.put("city", "TestCity");
        values.put("country", "TestCountry");
        values.put("road", "TestRoad");
        values.put("suberb", "TestSuberb");
        values.put("cell", "TestCell");
        values.put("email", "TestEmail");
        values.put("homeTell", "TestHomeTell");
        values.put("workTell", "TestWorkTell");

        Useraccount useraccount = AppFactory.createUserAccount(values);

        useraccountCrudService.persist(useraccount);
        userID = useraccount.getUserid();
        Assert.assertNotNull(useraccount);
    }

    @Test
    public void createNewGarageTest()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("closeDate", new Date());
        values.put("garageType", "small");
        values.put("openDate", new Date());
        values.put("userId", useraccountCrudService.findById(userID));
        Garage garage = AppFactory.createGarage(values);

        garageCrudService.persist(garage);
        garageid = garage.getGarageid();
        Assert.assertNotNull(garage);
    }

    @Test
    public void createNewSalesHistoryTest()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("bidAmount", "55.99");


    }
}