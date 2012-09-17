package com.onlinegaragesale.services.crud;

import com.onlinegaragesale.services.crud.impl.BitCrudServiceImplTest;
import com.onlinegaragesale.services.crud.impl.CategoryCrudServiceImplTest;
import com.onlinegaragesale.services.crud.impl.GarageCrudServiceImplTest;
import com.onlinegaragesale.services.crud.impl.ProductCrudServiceImplTest;
import com.onlinegaragesale.services.crud.impl.UseraccountCrudServiceImplTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * File Name: AllCrudTests.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud
 * Author: Lance
 * Date: 17 Sep 2012
 * Edited: 17 Sep 2012
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    UseraccountCrudServiceImplTest.class,
    GarageCrudServiceImplTest.class,
    CategoryCrudServiceImplTest.class,
    ProductCrudServiceImplTest.class,
    BitCrudServiceImplTest.class
})
public class AllCrudTests
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
}