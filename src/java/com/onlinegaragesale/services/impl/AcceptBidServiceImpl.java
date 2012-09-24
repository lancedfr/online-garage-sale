package com.onlinegaragesale.services.impl;

import com.onlinegaragesale.dataaccess.DatabaseConnection;
import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.services.AcceptBidService;
import com.onlinegaragesale.services.crud.BidCrudService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: AcceptBidServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.impl
 * Author: Lance
 * Date: 22 Sep 2012
 * Edited: 22 Sep 2012
 */
@Service("acceptBidService")
public class AcceptBidServiceImpl implements AcceptBidService
{

    @Autowired
    private BidCrudService bidCrudService;

    @Override
    public void acceptBid(Bid bid)
    {
        try
        {
            DatabaseConnection instance = DatabaseConnection.getInstance();
            Connection connection = instance.getConnection();
            Statement createStatement = connection.createStatement();
            createStatement.executeUpdate("UPDATE BID SET BIDSTATUS = '0' WHERE PRODID  = " + bid.getProdid().getProdid());
            createStatement.executeUpdate("UPDATE BID SET BIDSTATUS = '1' WHERE BIDID = " + bid.getBidid().toString());
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AcceptBidServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
