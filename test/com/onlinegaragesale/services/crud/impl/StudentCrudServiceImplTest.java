package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.services.ObjectId;
import com.onlinegaragesale.services.crud.StudentCrudService;
import java.math.BigDecimal;
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
public class StudentCrudServiceImplTest
{

    private static BigDecimal studentID;
    private static ApplicationContext ctx;
    private static Facade facade;
    private StudentCrudService studentCrudService;

    public StudentCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
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
    public void aTest()
    {
        BigDecimal currectUserAccountId = ObjectId.getNewUserAccountId();
        Assert.assertEquals(new BigDecimal("20124006"), currectUserAccountId);
    }

    @Test
    public void testStudentCrud()
    {
        Student createStudent = AppFactory.createSampleStudent(null);
        GetContext.setApplicationContext(new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml"));

        facade = new Facade();
        studentCrudService = facade.getSampleCrudService();
        studentCrudService.persist(createStudent);
        studentID = createStudent.getId();
        Assert.assertNotNull(createStudent);

//        studentCrudService.removeById(studentID);
//        createStudent = studentCrudService.findById(studentID);
//        Assert.assertNull(createStudent);
    }
}
