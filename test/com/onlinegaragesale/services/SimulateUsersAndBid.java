package com.onlinegaragesale.services;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.model.Category;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Saleshistory;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.crud.BidCrudService;
import com.onlinegaragesale.services.crud.CategoryCrudService;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
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
 * File Name: SimulateUsersAndBid.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud
 * Author: Lance
 * Date: 07 Oct 2012
 * Edited: 07 Oct 2012
 */
public class SimulateUsersAndBid
{

    private BigDecimal userID;
    private BigDecimal garageid;
    private BigDecimal categoryid;
    private BigDecimal prodid;
    private BigDecimal bidid;
    private static Facade facade;
    private static UseraccountCrudService useraccountCrudService;
    private static GarageCrudService garageCrudService;
    private static SaleshistoryCrudService saleshistoryCrudService;
    private static CategoryCrudService categoryCrudService;
    private static ProductCrudService productCrudService;
    private static BidCrudService bidCrudService;
    private static AcceptBidService acceptBidService;

    public SimulateUsersAndBid()
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
        categoryCrudService = facade.getCategoryCrudService();
        productCrudService = facade.getProductCrudService();
        bidCrudService = facade.getBidCrudService();
        acceptBidService = facade.getAcceptBidService();
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
        createUser();
        createGarage();
        createSalesHistory();
        createCategory();
        createProduct();
        createCategory();
        createProduct();
        
        createUser();           //bummy user to create a bid
        createBid();
        createUser();           //bummy user to create a bid
        createBid();
        acceptBid();
    }

    private void createUser()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("age", "22");
        values.put("dob", new Date());
        values.put("firstName", "CreateFName");
        values.put("lastName", "CreateLName");
        values.put("middleName", "CreateMName");
        values.put("pasword", "CreatePassword");
        values.put("address", "CreateAddress");
        values.put("areacode", "CreateAddressLine");
        values.put("city", "CreateCity");
        values.put("country", "CreateCountry");
        values.put("road", "CreateRoad");
        values.put("suberb", "CreateSuberb");
        values.put("cell", "CreateCell");
        values.put("email", "CreateEmail");
        values.put("homeTell", "CreateHomeTell");
        values.put("workTell", "CreateWorkTell");

        Useraccount useraccount = AppFactory.createUserAccount(values);

        useraccountCrudService.persist(useraccount);
        userID = useraccount.getUserid();
        Assert.assertNotNull(useraccount);
    }

    private void createGarage()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("closeDate", new Date());
        values.put("garageType", "CreateSmall");
        values.put("openDate", new Date());
        values.put("userId", useraccountCrudService.findById(userID));
        Garage garage = AppFactory.createGarage(values);

        garageCrudService.persist(garage);
        garageid = garage.getGarageid();
        Assert.assertNotNull(garage);
    }

    private void createSalesHistory()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("Useraccount", useraccountCrudService.findById(userID));
        Saleshistory createSalesHistory = AppFactory.createSalesHistory(values);

        saleshistoryCrudService.persist(createSalesHistory);
    }
    
    private void createCategory()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("categoryType", "Lighting");
        Category createCategory = AppFactory.createCategory(values);
        categoryid = createCategory.getCategoryid();
        categoryCrudService.persist(createCategory);
    }
    
    private void createProduct()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("garageId", garageCrudService.findById(garageid));
        values.put("prodCondition", "GREAT");
        values.put("prodDesc", "Green Lamp");
        values.put("prodPrice", "234.66");
        values.put("prodStatus", "Not Sold");
        values.put("categoryId", categoryCrudService.findById(categoryid));
        Product product = AppFactory.createProduct(values);

        productCrudService.persist(product);
        prodid = product.getProdid();
        Product p = productCrudService.findById(prodid);
        Assert.assertNotNull(p);
    }
    
    private void createBid()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("bidAmount", "55.99");
        values.put("prodId", productCrudService.findById(prodid));
        values.put("userId", userID);
        Bid bid = AppFactory.createBid(values);

        bidCrudService.persist(bid);
        bidid = bid.getBidid();
        Bid b = bidCrudService.findById(bidid);
        Assert.assertNotNull(b);
    }
    
    private void acceptBid()
    {
        Bid bid = bidCrudService.findById(bidid);
        acceptBidService.acceptBid(bid);
    }
}