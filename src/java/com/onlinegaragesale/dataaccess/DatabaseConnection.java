package com.onlinegaragesale.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 * File Name: DatabaseConnsection.java
 * Version:
 * Description:
 * Package: com.onlinegaragesale.dataaccess
 * Author: Lance
 * Date: Jun 16, 2012
 */
public class DatabaseConnection
{

    private static DatabaseConnection conn = null;
    private OracleDataSource oracleDataSource;
    private Connection connection;

    private DatabaseConnection() throws SQLException
    {
        try
        {
            Properties dataBaseProperties = new Properties();
            dataBaseProperties.load(new FileInputStream(new File(this.getClass().getClassLoader().getResource("database.properties").toURI())));
            String userName = dataBaseProperties.getProperty("database.username");
            String password = dataBaseProperties.getProperty("database.password");
            String databaseURL = dataBaseProperties.getProperty("database.url", "jdbc:oracle:thin:@localhost:1521:XE");

            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(databaseURL);
            oracleDataSource.setUser(userName);
            oracleDataSource.setPassword(password);
            connection = oracleDataSource.getConnection();
        }
        catch (URISyntaxException ex)
        {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns instance of DatabaseConnsection object
     *
     * jdbc:oracle:thin:
     *
     * @//127.0.0.1:1521/XE
     *
     * @return DatabaseConnsection
     * @throws SQLException
     */
    public static DatabaseConnection getInstance() throws SQLException
    {
        if (conn == null)
        {
            conn = new DatabaseConnection();
        }
        return conn;
    }

    /**
     * Return the database connection
     *
     * @return Connection
     */
    public Connection getConnection()
    {
        return connection;
    }

    /**
     * Use getOracleDataSource to recall username or password
     *
     * @return OracleDataSource
     */
    public OracleDataSource getOracleDataSource()
    {
        return oracleDataSource;
    }
}