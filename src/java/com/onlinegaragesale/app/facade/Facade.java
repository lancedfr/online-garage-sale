package com.onlinegaragesale.app.facade;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.services.crud.StudentCrudService;
import java.io.Serializable;
import org.springframework.context.ApplicationContext;

/**
 * File Name: Facade.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.app.facade
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class Facade implements Serializable
{

    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private StudentCrudService studentCrudService;

    public StudentCrudService getSampleCrudService()
    {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        return studentCrudService;
    }
}
