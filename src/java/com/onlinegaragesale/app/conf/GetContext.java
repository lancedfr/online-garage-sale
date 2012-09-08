package com.onlinegaragesale.app.conf;

import org.springframework.context.ApplicationContext;

/**
 * File Name: GetContext.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.app.conf
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class GetContext
{

    private static ApplicationContext ctx;

    public static void setApplicationContext(ApplicationContext applicationContext)
    {
        ctx = applicationContext;
    }

    public static ApplicationContext getApplicationContext()
    {
        return ctx;
    }
}
