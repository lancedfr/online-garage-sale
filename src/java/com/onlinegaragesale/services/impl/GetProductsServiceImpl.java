package com.onlinegaragesale.services.impl;

import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.GetProductsService;
import com.onlinegaragesale.services.crud.BidCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: GetProductsServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.impl
 * Author: Lance
 * Date: 23 Sep 2012
 * Edited: 23 Sep 2012
 */
@Service("getProductsService")
public class GetProductsServiceImpl implements GetProductsService
{

    @Autowired
    private UseraccountCrudService useraccountCrudService;
    @Autowired
    private BidCrudService bidCrudService;

    @Override
    public List<Product> userProducts(Useraccount useraccount)
    {
        List<Product> products = new ArrayList<Product>();
        BigDecimal userid = useraccount.getUserid();
        Useraccount useraccountById = useraccountCrudService.findById(userid);
        List<Garage> garageList = useraccountById.getGarageList();
        for (Garage garage : garageList)
        {
            List<Product> productList = garage.getProductList();
            for (Product product : productList)
            {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> usersBids(Useraccount useraccount)
    {
        List<Product> products = new ArrayList<Product>();
        Useraccount useraccountById = useraccountCrudService.findById(useraccount.getUserid());
        final BigDecimal userid = useraccountById.getUserid();
        List<Bid> bids = bidCrudService.findAll();
        for (Bid bid : bids)
        {
            if (bid.getUserid().equals(userid))
            {
                products.add(bid.getProdid());
            }
        }
        return products;
    }

    @Override
    public List<Product> userBuys(Useraccount useraccount)
    {
        throw new UnsupportedOperationException("GetProducts.userBuys Not supported yet.");
//        List<Product> products = new ArrayList<Product>();
//        Useraccount useraccountById = useraccountCrudService.findById(useraccount.getUserid());
//        List<Bid> bids = bidCrudService.findAll();
//        for (Bid bid : bids)
//        {
//            if (bid.getUserid() == useraccountById.getUserid())
//            {
//                products.add(bid.getProdid());
//            }
//        }
//        return products;
    }
}
