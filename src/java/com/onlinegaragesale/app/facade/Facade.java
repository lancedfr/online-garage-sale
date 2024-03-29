package com.onlinegaragesale.app.facade;

import com.onlinegaragesale.app.conf.GetContext;
import com.onlinegaragesale.services.AcceptBidService;
import com.onlinegaragesale.services.CreateUser;
import com.onlinegaragesale.services.GetProductsService;
import com.onlinegaragesale.services.crud.BidCrudService;
import com.onlinegaragesale.services.crud.CategoryCrudService;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
import com.onlinegaragesale.services.crud.ProductsalesCrudService;
import com.onlinegaragesale.services.crud.RolesCrudService;
import com.onlinegaragesale.services.crud.SaleshistoryCrudService;
import com.onlinegaragesale.services.crud.StudentCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.io.Serializable;
import org.springframework.context.ApplicationContext;

/**
 * File Name: Facade.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.app.facade
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class Facade implements Serializable
{

    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private StudentCrudService studentCrudService;
    private UseraccountCrudService useraccountCrudService;
    private GarageCrudService garageCrudService;
    private ProductCrudService productCrudService;
    private CategoryCrudService categoryCrudService;
    private BidCrudService bidCrudService;
    private RolesCrudService rolesCrudService;
    private SaleshistoryCrudService saleshistoryCrudService;
    private ProductsalesCrudService productsalesCrudService;
    private AcceptBidService acceptBidService;
    private GetProductsService getProductsService;
    private CreateUser createUser;

    /**
     *
     * @return studentCrudService
     */
    public StudentCrudService getSampleCrudService()
    {
        studentCrudService = (StudentCrudService) ctx.getBean("studentCrudService");
        return studentCrudService;
    }

    /**
     *
     * @return useraccountCrudService
     */
    public UseraccountCrudService getUseraccountCrudService()
    {
        useraccountCrudService = (UseraccountCrudService) ctx.getBean("useraccountCrudService");
        return useraccountCrudService;
    }

    /**
     *
     * @return garageCrudService
     */
    public GarageCrudService getGarageCrudService()
    {
        garageCrudService = (GarageCrudService) ctx.getBean("garageCrudService");
        return garageCrudService;
    }

    /**
     *
     * @return productCrudService
     */
    public ProductCrudService getProductCrudService()
    {
        productCrudService = (ProductCrudService) ctx.getBean("productCrudService");
        return productCrudService;
    }

    /**
     *
     * @return categoryCrudService
     */
    public CategoryCrudService getCategoryCrudService()
    {
        categoryCrudService = (CategoryCrudService) ctx.getBean("categoryCrudService");
        return categoryCrudService;
    }

    /**
     *
     * @return bidCrudService
     */
    public BidCrudService getBidCrudService()
    {
        bidCrudService = (BidCrudService) ctx.getBean("bidCrudService");
        return bidCrudService;
    }

    /**
     *
     * @return saleshistoryCrudService
     */
    public SaleshistoryCrudService getSaleshistoryCrudService()
    {
        saleshistoryCrudService = (SaleshistoryCrudService) ctx.getBean("saleshistoryCrudService");
        return saleshistoryCrudService;
    }

    /**
     *
     * @return productsalesCrudService
     */
    public ProductsalesCrudService getProductsalesCrudService()
    {
        productsalesCrudService = (ProductsalesCrudService) ctx.getBean("productsalesCrudService");
        return productsalesCrudService;
    }

    /**
     *
     * @return acceptBidService
     */
    public AcceptBidService getAcceptBidService()
    {
        acceptBidService = (AcceptBidService) ctx.getBean("acceptBidService");
        return acceptBidService;
    }

    /**
     *
     * @return getProductsService
     */
    public GetProductsService getGetProductsService()
    {
        getProductsService = (GetProductsService) ctx.getBean("getProductsService");
        return getProductsService;
    }

    public CreateUser getCreateUserService()
    {
        createUser = (CreateUser) ctx.getBean("createUser");
        return createUser;
    }

    public RolesCrudService getRolesCrudService()
    {
        rolesCrudService =  (RolesCrudService) ctx.getBean("rolesCrudService");
        return rolesCrudService;
    }
}
