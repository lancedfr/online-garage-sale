package com.onlinegaragesale.services;

import com.onlinegaragesale.dataaccess.DatabaseConnection;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;

/**
 * File Name: InitDatabase.java
 * Version:
 * Description:
 * Package: com.deliveryservicesystem.test
 * Author: Lance
 * Date: Jun 19, 2012
 * Editor:
 */
public class InitDatabase
{

    public InitDatabase()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
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
    public void testInitDatabase()
    {
        try
        {
            DatabaseConnection databaseConnsection = DatabaseConnection.getInstance();
            runScript(databaseConnsection.getConnection());
            runFuncScript(databaseConnsection.getConnection());
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "
                    + "C:\\Users\\Lance\\Documents\\NetBeansProjects\\InterProject\\online-garage-sale\\ScriptLog.txt");
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "
                    + "C:\\Users\\Lance\\Documents\\NetBeansProjects\\InterProject\\online-garage-sale\\ScriptErrorLog.txt");
        }
        catch (IOException ex)
        {
            Logger.getLogger(InitDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(InitDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void runScript(Connection connection) throws SQLException, IOException
    {
        ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
        scriptRunner.setDelimiter(";", false);
        Reader reader;

        FileOutputStream scriptLogFileOutputStream = new FileOutputStream("ScriptLog.txt", false);
        FileOutputStream scriptErrorLogFileOutputStream = new FileOutputStream("ScriptErrorLog.txt", false);
        scriptRunner.setLogWriter(new PrintWriter(scriptLogFileOutputStream));
        scriptRunner.setErrorLogWriter(new PrintWriter(scriptErrorLogFileOutputStream));
        reader = new FileReader("./src/java/com/onlinegaragesale/app/dbsql/INIT_DB_SCRIPT.sql");
        scriptRunner.runScript(reader);
    }

    private void runFuncScript(Connection connection) throws SQLException, IOException
    {
        ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
        scriptRunner.setDelimiter("/", false);
        Reader reader;

        FileOutputStream scriptLogFileOutputStream = new FileOutputStream("ScriptLog.txt", true);
        FileOutputStream scriptErrorLogFileOutputStream = new FileOutputStream("ScriptErrorLog.txt", true);
        scriptRunner.setLogWriter(new PrintWriter(scriptLogFileOutputStream));
        scriptRunner.setErrorLogWriter(new PrintWriter(scriptErrorLogFileOutputStream));
        reader = new FileReader("./src/java/com/onlinegaragesale/app/dbsql/INIT_DB_FUNC_SCRIPT.sql");
        scriptRunner.runScript(reader);
    }
}