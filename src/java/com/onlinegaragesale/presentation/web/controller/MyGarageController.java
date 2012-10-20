package com.onlinegaragesale.presentation.web.controller;

import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Category;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.presentation.web.model.ProductBean;
import com.onlinegaragesale.services.crud.CategoryCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * File Name: MyGarageController.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.controller
 * Author: Lance
 * Date: 19 Oct 2012
 * Edited: 19 Oct 2012
 */
@Controller
public class MyGarageController
{

    private final Facade facade = new Facade();

    @RequestMapping(value = "/addproduct.html", method = RequestMethod.GET)
    public String getAddProduct(Model model)
    {
        ProductBean productBean = new ProductBean();
        model.addAttribute(productBean);
        return "addproduct";
    }

    @RequestMapping(value = "/addproductprocess.html", method = RequestMethod.POST)
    public String addProductProcess(@Validated ProductBean productBean)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); //get logged in username
        UseraccountCrudService useraccountCrudService = facade.getUseraccountCrudService();
        Useraccount useraccount = useraccountCrudService.getByPropertyName("email", email);
        CategoryCrudService categoryCrudService = facade.getCategoryCrudService();
        Category category = categoryCrudService.getByPropertyName("categorytype", productBean.getCategoryid());
        Product product = AppFactory.createProduct(productBean, category, useraccount);
        ProductCrudService productCrudService = facade.getProductCrudService();
        productCrudService.persist(product);
        return "index";
    }
}
