package com.onlinegaragesale.services;

import com.onlinegaragesale.dataaccess.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 * File Name: CreateNewId.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services
 * Author: Lance
 * Date: 17 Sep 2012
 * Edited: 17 Sep 2012
 */
public class CreateNewId
{

    private static Long getNewIdFromSequences(String sql)
    {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(sql);
        stringBuilder.append(".NEXTVAL FROM DUAL");
        Long newId = null;
        try
        {
            DatabaseConnection instance = DatabaseConnection.getInstance();
            Connection connection = instance.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(stringBuilder.toString());
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();
            newId = resultSet.getLong(1);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CreateNewId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newId;
    }
    
    private static Long getNewIdFromFunction(String sql)
    {
        StringBuilder stringBuilder = new StringBuilder("BEGIN ? := ");
        stringBuilder.append(sql);
        stringBuilder.append("; END;");
        Long newUserAccountId = null;
        try
        {
            DatabaseConnection instance = DatabaseConnection.getInstance();
            Connection connection = instance.getConnection();
            CallableStatement prepareCall = connection.prepareCall(stringBuilder.toString());
            prepareCall.registerOutParameter(1, OracleTypes.NUMBER);
            prepareCall.execute();
            newUserAccountId = prepareCall.getLong(1);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CreateNewId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newUserAccountId;
    }

    public static Long bid()
    {
        return getNewIdFromSequences("BID_ID_SEQ");
    }

    public static Long category()
    {
        return getNewIdFromSequences("CATEGORY_ID_SEQ");
    }

    public static Long garage()
    {
        return getNewIdFromSequences("GARAGE_ID_SEQ");
    }

    public static Long product()
    {
        return getNewIdFromSequences("PRODUCT_ID_SEQ");
    }

    public static Long productSales()
    {
        return getNewIdFromSequences("PRODUCTSALES_ID_SEQ");
    }

    public static Long salesHistory()
    {
        return getNewIdFromSequences("SALESHISTORY_ID_SEQ");
    }

    public static Long userAccount()
    {
        return getNewIdFromFunction("CREATE_USERACCOUNT_ID");
    }
}
