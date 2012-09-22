package com.onlinegaragesale.services;

import com.onlinegaragesale.dataaccess.DatabaseConnection;
import java.math.BigDecimal;
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

    private static BigDecimal getNewIdFromSequences(String sql)
    {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(sql);
        stringBuilder.append(".NEXTVAL FROM DUAL");
        BigDecimal newId = null;
        try
        {
            DatabaseConnection instance = DatabaseConnection.getInstance();
            Connection connection = instance.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(stringBuilder.toString());
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();
            newId = resultSet.getBigDecimal(1);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CreateNewId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newId;
    }
    
    private static BigDecimal getNewIdFromFunction(String sql)
    {
        StringBuilder stringBuilder = new StringBuilder("BEGIN ? := ");
        stringBuilder.append(sql);
        stringBuilder.append("; END;");
        BigDecimal newUserAccountId = null;
        try
        {
            DatabaseConnection instance = DatabaseConnection.getInstance();
            Connection connection = instance.getConnection();
            CallableStatement prepareCall = connection.prepareCall(stringBuilder.toString());
            prepareCall.registerOutParameter(1, OracleTypes.NUMBER);
            prepareCall.execute();
            newUserAccountId = prepareCall.getBigDecimal(1);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CreateNewId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newUserAccountId;
    }

    public static BigDecimal bid()
    {
        return getNewIdFromSequences("BID_ID_SEQ");
    }

    public static BigDecimal category()
    {
        return getNewIdFromSequences("CATEGORY_ID_SEQ");
    }

    public static BigDecimal garage()
    {
        return getNewIdFromSequences("GARAGE_ID_SEQ");
    }

    public static BigDecimal product()
    {
        return getNewIdFromSequences("PRODUCT_ID_SEQ");
    }

    public static BigDecimal productSales()
    {
        return getNewIdFromSequences("PRODUCTSALES_ID_SEQ");
    }

    public static BigDecimal salesHistory()
    {
        return getNewIdFromSequences("SALESHISTORY_ID_SEQ");
    }

    public static BigDecimal userAccount()
    {
        return getNewIdFromFunction("CREATE_USERACCOUNT_ID");
    }
}
