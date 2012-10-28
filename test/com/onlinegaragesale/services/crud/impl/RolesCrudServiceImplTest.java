package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Roles;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.crud.RolesCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.math.BigDecimal;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * File Name: RolesCrudServiceImplTest.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 15 Oct 2012
 * Edited: 15 Oct 2012
 */
public class RolesCrudServiceImplTest
{

    private static BigDecimal roleID;
    private static ApplicationContext ctx;
    private static Facade facade;
    private static RolesCrudService rolesCrudService;
    private static UseraccountCrudService useraccountCrudService;

    public RolesCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));
        facade = new Facade();
        rolesCrudService = facade.getRolesCrudService();
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
    public void rolesCrudServiceImplTestTest()
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("roleid", "1");
        values.put("email", "user");
        values.put("rolename", "user");
        values.put("userid", useraccountCrudService.findById(new BigDecimal(20124031)));

        Roles role = AppFactory.createRole(values);

        rolesCrudService.persist(role);
        roleID = role.getRoleid();
        Assert.assertNotNull(roleID);
    }
}