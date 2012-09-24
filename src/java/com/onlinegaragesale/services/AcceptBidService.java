package com.onlinegaragesale.services;

import com.onlinegaragesale.model.Bid;

/**
 * File Name: AcceptBidService.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services
 * Author: Lance
 * Date: 22 Sep 2012
 * Edited: 22 Sep 2012
 */
public interface AcceptBidService
{

    /**
     * Changes the status of the provided bid to accepted and other bids related
     * to that product to declined.
     * Also changes the status of the product to sold
     *
     * @param bid
     */
    public void acceptBid(Bid bid);
}
