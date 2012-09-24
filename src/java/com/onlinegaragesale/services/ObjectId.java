package com.onlinegaragesale.services;

import com.onlinegaragesale.dataaccess.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 * File Name: ObjectId.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services
 * Author: Lance
 * Date: 17 Sep 2012
 * Edited: 17 Sep 2012
 */
public class ObjectId
{

    private static BigDecimal getIdFromSequences(String sql)
    {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(sql);
        stringBuilder.append(" FROM DUAL");
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
            Logger.getLogger(ObjectId.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ObjectId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newUserAccountId;
    }

    /**
     *
     * @return Current
     */
    public static BigDecimal getCurrentBidId()
    {
        return getIdFromSequences("BID_ID_SEQ.CURRVAL");
    }

    /**
     *
     * @return Currect Category Id
     */
    public static BigDecimal getCurrentCategoryId()
    {
        return getIdFromSequences("CATEGORY_ID_SEQ.CURRVAL");
    }

    /**
     *
     * @return Current Garage Id
     */
    public static BigDecimal getCurrentGarageId()
    {
        return getIdFromSequences("GARAGE_ID_SEQ.CURRVAL");
    }

    /**
     *
     * @return Current Product Id
     */
    public static BigDecimal getCurrentProductId()
    {
        return getIdFromSequences("PRODUCT_ID_SEQ.CURRVAL");
    }

    /**
     *
     * @return Current ProductSales Id
     */
    public static BigDecimal getCurrentProductSalesId()
    {
        return getIdFromSequences("PRODUCTSALES_ID_SEQ.CURRVAL");
    }

    /**
     *
     * @return Current SalesHistory Id
     */
    public static BigDecimal getCurrentSalesHistoryId()
    {
        return getIdFromSequences("SALESHISTORY_ID_SEQ.CURRVAL");
    }

    /**
     *
     * @return Current UserAccount Id
     */
    public static BigDecimal getCurrentUserAccountId()
    {
        BigDecimal idFromSequences = getIdFromSequences("USERACCOUNT_ID_SEQ.CURRVAL");
        Calendar calendar = Calendar.getInstance();
        int weekYear = calendar.getWeekYear();
        return new BigDecimal(String.valueOf(weekYear) + idFromSequences.toString());
    }

    /**
     *
     * @return New Bid Id
     */
    public static BigDecimal getNewBidId()
    {
        return getIdFromSequences("BID_ID_SEQ.NEXTVAL");
    }

    /**
     *
     * @return New Category Id
     */
    public static BigDecimal getNewCategoryId()
    {
        return getIdFromSequences("CATEGORY_ID_SEQ.NEXTVAL");
    }

    /**
     *
     * @return New Garage Id
     */
    public static BigDecimal getNewGarageId()
    {
        return getIdFromSequences("GARAGE_ID_SEQ.NEXTVAL");
    }

    /**
     *
     * @return New Product Id
     */
    public static BigDecimal getNewProductId()
    {
        return getIdFromSequences("PRODUCT_ID_SEQ.NEXTVAL");
    }

    /**
     *
     * @return New ProductSales Id
     */
    public static BigDecimal getNewProductSalesId()
    {
        return getIdFromSequences("PRODUCTSALES_ID_SEQ.NEXTVAL");
    }

    /**
     *
     * @return New SalesHistory Id
     */
    public static BigDecimal getNewSalesHistoryId()
    {
        return getIdFromSequences("SALESHISTORY_ID_SEQ.NEXTVAL");
    }

    /**
     *
     * @return New UserAccount Id
     */
    public static BigDecimal getNewUserAccountId()
    {
        return getNewIdFromFunction("CREATE_USERACCOUNT_ID");
    }
}
