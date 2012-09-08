package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.services.crud.StudentCrudService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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

    private static Long studentID;
    private static ApplicationContext ctx;
    private static Facade facade;
    private StudentCrudService studentCrudService;

    public StudentCrudServiceImplTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
        ctx = new ClassPathXmlApplicationContext("classpath:com/onlinegaragesale/app/conf/applicationContext-*.xml");
        facade = new Facade();
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
    public void testStudentCrud()
    {
        Student createStudent = AppFactory.createSampleStudent(null);

        studentCrudService = facade.getSampleCrudService();
        studentCrudService.persist(createStudent);
        studentID = createStudent.getId();
        Assert.assertNotNull(createStudent);

        studentCrudService.removeById(studentID);
        createStudent = studentCrudService.findById(studentID);
        Assert.assertNull(createStudent);
    }
//    /**
//     * Test of setDao method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testStudentCrud()
//    {
//        System.out.println("setDao");
//        GenericDAO<Student> daoToSet = null;
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        instance.setDao(daoToSet);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testFindById()
//    {
//        System.out.println("findById");
//        Long id = null;
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        Student expResult = null;
//        Student result = instance.findById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testFindAll()
//    {
//        System.out.println("findAll");
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        List expResult = null;
//        List result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of persist method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testPersist()
//    {
//        System.out.println("persist");
//        Student entity = null;
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        instance.persist(entity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of merge method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testMerge()
//    {
//        System.out.println("merge");
//        Student entity = null;
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        instance.merge(entity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testRemove()
//    {
//        System.out.println("remove");
//        Student entity = null;
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        instance.remove(entity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeById method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testRemoveById()
//    {
//        System.out.println("removeById");
//        Long entityId = null;
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        instance.removeById(entityId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findInRange method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testFindInRange()
//    {
//        System.out.println("findInRange");
//        int firstResult = 0;
//        int maxResults = 0;
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        List expResult = null;
//        List result = instance.findInRange(firstResult, maxResults);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testCount()
//    {
//        System.out.println("count");
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        long expResult = 0L;
//        long result = instance.count();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getByPropertyName method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testGetByPropertyName()
//    {
//        System.out.println("getByPropertyName");
//        String name = "";
//        String value = "";
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        Student expResult = null;
//        Student result = instance.getByPropertyName(name, value);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEntitiesByProperName method, of class StudentCrudServiceImpl.
//     */
//    @Test
//    public void testGetEntitiesByProperName()
//    {
//        System.out.println("getEntitiesByProperName");
//        String name = "";
//        String value = "";
//        StudentCrudServiceImpl instance = new StudentCrudServiceImpl();
//        List expResult = null;
//        List result = instance.getEntitiesByProperName(name, value);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
