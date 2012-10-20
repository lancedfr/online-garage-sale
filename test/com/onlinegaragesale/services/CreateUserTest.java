package com.onlinegaragesale.services;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Saleshistory;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.SaleshistoryCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
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

    private static Facade facade;
    private static CreateUser createUser;
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
        createUser = facade.getCreateUserService();

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
    public void createUserTestTest()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("age", "22");
        values.put("dob", new Date());
        values.put("firstName", "CreateFName");
        values.put("lastName", "CreateLName");
        values.put("middleName", "CreateMName");
        values.put("pasword", "user");
        values.put("address", "CreateAddress");
        values.put("areacode", "CreateAddressLine");
        values.put("city", "CreateCity");
        values.put("country", "CreateCountry");
        values.put("road", "CreateRoad");
        values.put("suberb", "CreateSuberb");
        values.put("cell", "CreateCell");
        values.put("email", "user");
        values.put("homeTell", "CreateHomeTell");
        values.put("workTell", "CreateWorkTell");
        createUser.createNewUser(values);

        Useraccount useraccount = useraccountCrudService.findById(ObjectId.getCurrentUserAccountId());
        Assert.assertNotNull(useraccount);

        Garage garage = garageCrudService.findById(ObjectId.getCurrentGarageId());
        Assert.assertNotNull(garage);

        Saleshistory saleshistory = saleshistoryCrudService.findById(ObjectId.getCurrentSalesHistoryId());
        Assert.assertNotNull(saleshistory);
    }
}