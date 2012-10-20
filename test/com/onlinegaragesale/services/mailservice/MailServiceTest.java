package com.onlinegaragesale.services.mailservice;

import com.onlinegaragesale.services.mail.MailService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * File Name: MailServiceTest.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.mailservice
 * Author: Lance
 * Date: 19 Oct 2012
 * Edited: 19 Oct 2012
 */
public class MailServiceTest
{

    public MailServiceTest()
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void MailServiceTestTest()
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/com/onlinegaragesale/app/conf/Spring-Mail.xml");
        //C:\Users\Lance\Documents\NetBeansProjects\InterProject\online-garage-sale\src\java\com\onlinegaragesale\app\conf\Spring-Mail.xml
        MailService mailService = (MailService) context.getBean("mailService");
        
        mailService.sendMail("myusername@gmail.com", "myusername@gmail.com", "Testing123", "Testing only \n\n Hello Spring Email Sender");
        mailService.sendAlertMail("Exception occurred");
    }
}