package com.onlinegaragesale.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * File Name: PersistenceDbManager.java
 * Version:
 * Description:
 * Package: com.deliveryservicesystem.app.conf
 * Author: Lance
 * Date: Jun 19, 2012
 * Editor:
 */
public class PersistenceDbManager
{

    private static PersistenceDbManager persistenceManager;
    private String userName;
    private String password;
    private String databaseURL;
    private String jdbcDriver;
    private String databasePropertiesFilePath = "classpath:database.properties";

    private PersistenceDbManager()
    {
        Properties dataBaseProperties = new Properties();
        try
        {
            dataBaseProperties.load(new FileInputStream(new File(databasePropertiesFilePath)));
            userName = dataBaseProperties.getProperty("userName");
            password = dataBaseProperties.getProperty("password");
            databaseURL = dataBaseProperties.getProperty("dbUrl");
            jdbcDriver = dataBaseProperties.getProperty("jdbcDriver", "oracle.jdbc.OracleDriver");
        }
        catch (IOException ex)
        {
        }
    }

    /**
     *
     * @return PersistenceDbManager
     */
    public static PersistenceDbManager getInstance()
    {
        if (persistenceManager == null)
        {
            persistenceManager = new PersistenceDbManager();
        }
        return persistenceManager;
    }

    /**
     *
     * @return EntityManager
     */
    public EntityManager getEntityManager()
    {
        EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
        return entityManagerFactory.createEntityManager();
    }

    /**
     *
     * @return EntityManagerFactory
     */
    public EntityManagerFactory getEntityManagerFactory()
    {
        Map<String, String> dbProps = new HashMap<String, String>();

        dbProps.put("javax.persistence.jdbc.url", databaseURL);
        dbProps.put("javax.persistence.jdbc.password", password);
        dbProps.put("javax.persistence.jdbc.driver", jdbcDriver);
        dbProps.put("javax.persistence.jdbc.user", userName);

        return Persistence.createEntityManagerFactory("deliverysystemPU", dbProps);
    }
}