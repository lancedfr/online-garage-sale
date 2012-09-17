package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.model.Category;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.crud.BidCrudService;
import com.onlinegaragesale.services.crud.CategoryCrudService;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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

    private static ApplicationContext ctx;
    private static Facade facade;
    private static UseraccountCrudService useraccountCrudService;
    private static GarageCrudService garageCrudService;
    private static ProductCrudService productCrudService;
    private static CategoryCrudService categoryCrudService;
    private static BidCrudService bidCrudService;
    private Long userID;
    private Long garageid;

    public BitCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        useraccountCrudService = facade.getUseraccountCrudService();
        garageCrudService = facade.getGarageCrudService();
        productCrudService = facade.getProductCrudService();
        categoryCrudService = facade.getCategoryCrudService();
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

    @Ignore
    public void testUseraccountCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("age", "22");
        values.put("dob", new Date());
        values.put("firstName", "TestFName");
        values.put("lastName", "TestLName");
        values.put("middleName", "TestMName");
        values.put("pasword", "TestPassword");
        values.put("address", "TestAddress");
        values.put("addressLine", "TestAddressLine");
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

        //useraccountCrudService.removeById(userID);
        //useraccount = useraccountCrudService.findById(userID);
        //Assert.assertNull(useraccount);
    }

    @Ignore
    public void testGarageCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("closeDate", new Date());
        values.put("garageType", "small");
        values.put("openDate", new Date());
        values.put("userId", useraccountCrudService.findById(new Long(20124001)));
        Garage garage = AppFactory.createGarage(values);
        
        garageCrudService.persist(garage);
        garageid = garage.getGarageid();
        Assert.assertNotNull(garage);
        
//        garageCrudService.removeById(new Long(1));
//        Garage g = garageCrudService.findById(new Long(1));
//        Assert.assertNull(g);
    }
    
    @Ignore
    public void testCategoryCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("categoryType", "Lighting");
        Category createCategory = AppFactory.createCategory(values);
        categoryCrudService.persist(createCategory);
    }
    
    
    @Ignore
    public void testProductCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("garageId", garageCrudService.findById(new Long(1)));
        values.put("prodCondition", "GREAT");
        values.put("prodDesc", "Green Lamp");
        values.put("prodPrice", "234.66");
        values.put("categoryType", "Lighting");
        Product product = AppFactory.createProduct(values);
        
        productCrudService.persist(product);
        Product p = productCrudService.findById(new Long(1));
        Assert.assertNotNull(p);
    }
    
    @Test
    public void testBidCrud()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("bidAmount", "55.99");
        values.put("prodId", productCrudService.findById(new Long(1)));
        values.put("userId", useraccountCrudService.findById(new Long(20124001)).getUserid());
        Bid bid = AppFactory.createBid(values);
        
        bidCrudService.persist(bid);
        Bid b = bidCrudService.findById(new Long(1));
        Assert.assertNotNull(b);
    }

}
