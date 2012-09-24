package com.onlinegaragesale.services;

import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
import java.math.BigDecimal;
import java.util.List;

/**
 * File Name: GetProductsService.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.impl
 * Author: Lance
 * Date: 23 Sep 2012
 * Edited: 23 Sep 2012
 */
public interface GetProductsService
{

    /**
     *
     * @param useraccount
     * @return A List<Product> related to the provided user
     */
    public List<Product> userProducts(Useraccount useraccount);

    /**
     *
     * @param userId
     * @return A List<Product> related to the provided userId
     */
    public List<Product> userProducts(BigDecimal userId);

    /**
     *
     * @param useraccount
     * @return A List<Product> the provided user made bids on
     */
    public List<Product> usersBids(Useraccount useraccount);

    /**
     *
     * @param userId
     * @return A List<Product> the provided userId made bids on
     */
    public List<Product> usersBids(BigDecimal userId);

    /**
     *
     * @param useraccount
     * @return A List<Product> up for sale to the provided user
     */
    public List<Product> productsToBuy(Useraccount useraccount);

    /**
     *
     * @param userId
     * @return A List<Product> up for sale to the provided userId
     */
    public List<Product> productsToBuy(BigDecimal userId);
}
