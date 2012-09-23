package com.onlinegaragesale.services;

import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
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

    public List<Product> userProducts(Useraccount useraccount);

    public List<Product> usersBids(Useraccount useraccount);

    public List<Product> userBuys(Useraccount useraccount);
}
