package com.onlinegaragesale.app.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * File Name: ApplicationContextProvider.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.app.conf
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class ApplicationContextProvider implements ApplicationContextAware
{

    /**
     * Sets the ApplicationContext for springs ApplicationContextAware
     * NB: not necessarily called manually
     *
     * @param ctx
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException
    {
        GetContext.setApplicationContext(ctx);
    }
}