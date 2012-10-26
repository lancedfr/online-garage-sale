package com.onlinegaragesale.services.impl;

import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.GetProductsService;
import com.onlinegaragesale.services.crud.BidCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
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
    @Autowired
    private ProductCrudService productCrudService;

    @Override
    public List<Product> userProducts(Useraccount useraccount)
    {
        List<Product> productList = new ArrayList<Product>();
        Garage garage = useraccount.getGarageList().get(0);
        productList = garage.getProductList();
        return productList;
    }

    @Override
    public List<Product> userProducts(BigDecimal userId)
    {
        List<Product> productList = new ArrayList<Product>();
        Useraccount useraccountById = useraccountCrudService.findById(userId);
        Garage garage = useraccountById.getGarageList().get(0);
        productList = garage.getProductList();
        return productList;
    }

    @Override
    public List<Product> userProducts(String userEmail)
    {
        List<Product> productList = new ArrayList<Product>();
        Useraccount useraccountByEmail = useraccountCrudService.getByPropertyName("email", userEmail);
        Garage garage = useraccountByEmail.getGarageList().get(0);
        productList = garage.getProductList();
        return productList;
    }

    @Override
    public Product userProduct(String userEmail, String pridId)
    {
        List<Product> productList = new ArrayList<Product>();
        Product foundProduct = new Product();
        BigDecimal pridIdBigDecimal = new BigDecimal(pridId);
        Useraccount useraccountByEmail = useraccountCrudService.getByPropertyName("email", userEmail);
        Garage garage = useraccountByEmail.getGarageList().get(0);
        productList = garage.getProductList();
        for (Product product : productList)
        {
            if (product.getProdid().equals(pridIdBigDecimal))
            {
                foundProduct = product;
                break;
            }
        }
        return foundProduct;
    }

    @Override
    public List<Product> usersBids(Useraccount useraccount)
    {
        List<Product> products = new ArrayList<Product>();
        final BigDecimal userid = useraccount.getUserid();
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
    public List<Product> usersBids(BigDecimal userId)
    {
        List<Product> products = new ArrayList<Product>();
        Useraccount useraccountById = useraccountCrudService.findById(userId);
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
    public List<Product> usersBids(String userEmail)
    {
        List<Product> products = new ArrayList<Product>();
        Useraccount useraccountByEmail = useraccountCrudService.getByPropertyName("email", userEmail);
        final BigDecimal userid = useraccountByEmail.getUserid();
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
    public List<Product> productsToBuy(Useraccount useraccount)
    {
        Character forSaleStatus = new Character('0');
        List<Product> productsToBuy = new ArrayList<Product>();
        Garage userGarage = useraccount.getGarageList().get(0);
        List<Product> products = productCrudService.findAll();
        for (Product product : products)
        {
            if (!product.getGarageid().equals(userGarage))
            {
                if (forSaleStatus.equals(product.getProdstatus()))
                {
                    productsToBuy.add(product);
                }
            }
        }
        return productsToBuy;
    }

    @Override
    public List<Product> productsToBuy(BigDecimal userId)
    {
        Character forSaleStatus = new Character('0');
        List<Product> productsToBuy = new ArrayList<Product>();
        Useraccount useraccountById = useraccountCrudService.findById(userId);
        Garage userGarage = useraccountById.getGarageList().get(0);
        List<Product> products = productCrudService.findAll();
        for (Product product : products)
        {
            if (!product.getGarageid().equals(userGarage))
            {
                if (forSaleStatus.equals(product.getProdstatus()))
                {
                    productsToBuy.add(product);
                }
            }
        }
        return productsToBuy;
    }

    @Override
    public List<Product> productsToBuy(String userEmail)
    {
        Character forSaleStatus = new Character('0');
        List<Product> productsToBuy = new ArrayList<Product>();
        Useraccount useraccountByEmail = useraccountCrudService.getByPropertyName("email", userEmail);
        Garage userGarage = useraccountByEmail.getGarageList().get(0);
        List<Product> products = productCrudService.findAll();
        for (Product product : products)
        {
            if (!product.getGarageid().equals(userGarage))
            {
                if (forSaleStatus.equals(product.getProdstatus()))
                {
                    productsToBuy.add(product);
                }
            }
        }
        return productsToBuy;
    }

    @Override
    public List<Product> userProductsForSale(String userEmail)
    {
        Character forSaleStatus = new Character('0');
        List<Product> productList = new ArrayList<Product>();
        List<Product> userProductsForSale = new ArrayList<Product>();
        Useraccount useraccountByEmail = useraccountCrudService.getByPropertyName("email", userEmail);
        Garage garage = useraccountByEmail.getGarageList().get(0);
        productList = garage.getProductList();
        for (Product product : productList)
        {
            if (product.getProdstatus().equals(forSaleStatus))
            {
                userProductsForSale.add(product);
            }
        }
        return userProductsForSale;
    }
}
