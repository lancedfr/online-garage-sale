package com.onlinegaragesale.presentation.web.controller;

import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.services.crud.ProductCrudService;
import java.math.BigDecimal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * File Name: ProductController.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.controller
 * Author: Lance
 * Date: 20 Oct 2012
 * Edited: 20 Oct 2012
 */
@Controller
public class ProductController
{

    private final Facade facade = new Facade();

    @RequestMapping(value = "placebid.html", method = RequestMethod.GET)
    public ModelAndView getViewProduct(@RequestParam("id") String prodId, Model model)
    {
        ProductCrudService productCrudService = facade.getProductCrudService();
        Product product = productCrudService.findById(new BigDecimal(prodId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("placebid");
        return modelAndView;
    }
}
